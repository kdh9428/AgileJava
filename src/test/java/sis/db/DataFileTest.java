package sis.db;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.*;

public class DataFileTest {

    private static final String ID1 = "12345";
    private static final String ID2 = "23456";
    private static final String FILE_BASE = "DataFileTest";

    private DataFile db;
    private TestData testData1;
    private TestData testData2;

    @BeforeEach
    void setUp() throws IOException{
        db = DataFile.create(FILE_BASE);

        assertEquals(0, db.size());

        testData1 = new TestData(ID1, "datum1a", 1);
        testData2 = new TestData(ID2, "datum2a", 2);
    }

    @AfterEach
    void tearDown() {
        db.close();
        db.deleteFiles();
    }

    @Test
    public void testAdd() throws IOException {
        db.add(ID1, testData1);
        assertEquals(1, db.size());

        db.add(ID2, testData2);
        assertEquals(2, db.size());

        assertTestDataEquals(testData1, (TestData) db.findBy(ID1));
        assertTestDataEquals(testData2, (TestData) db.findBy(ID2));
    }

    @Test
    public void testPersistence() throws IOException {
        db.add(ID1, testData1);
        db.add(ID2, testData2);

        db.close();

        db = DataFile.open(FILE_BASE);
        assertEquals(2, db.size());

        assertTestDataEquals(testData1, (TestData) db.findBy(ID1));
        assertTestDataEquals(testData2, (TestData) db.findBy(ID2));

        db = DataFile.create(FILE_BASE);
        assertEquals(0, db.size());
    }

    @Test
    public void testKeyNotFound() throws IOException {
        assertNull(db.findBy(ID2));
    }


    private void assertTestDataEquals(TestData expected, TestData actual){

        assertEquals(expected.id, actual.id);
        assertEquals(expected.field1, actual.field1);
        assertEquals(expected.field2, actual.field2);
    }
    static class TestData implements Serializable{
        String id;
        String field1;
        int field2;

        public TestData(String id, String field1, int field2) {
            this.id = id;
            this.field1 = field1;
            this.field2 = field2;
        }
    }
}

