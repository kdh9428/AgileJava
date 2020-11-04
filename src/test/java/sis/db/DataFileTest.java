package sis.db;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class DataFileTest {

    private static final String ID1 = "12345";
    private static final String ID2 = "45678";
    private static final String FILE_BASE = "DataFileTest";

    private DataFile db;
    private TestData testData1;
    private TestData testData2;

    @BeforeEach
    void setUp() throws IOException {
        db = DataFile.create(FILE_BASE);

        assertEquals(0, db.size());

        testData1 = new TestData(ID1, "datum1a", 1);
        testData2 = new TestData(ID2, "datum2a", 2);
    }

    @AfterEach
    void tearDown() throws IOException {
        db.close();
        db.deleteFiles();
    }

    @Test
    public void testAdd() throws IOException {
        db.add(ID1, testData1);
        assertEquals(1, db.size());

//        db.add(ID2, testData2);
//        assertEquals(2, db.size());

        assertTestDataEquals(testData1, (TestData) db.findBy(ID1));
//        assertTestDataEquals(testData2, (TestData) db.findBy(ID2));
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


    private void assertTestDataEquals(TestData expected, TestData actual) {

        assertEquals(expected.id, actual.id);
        assertEquals(expected.field1, actual.field1);
        assertEquals(expected.field2, actual.field2);
    }

    public static class TestData implements Serializable {
        String id;
        String field1;
        int field2;

        public TestData(String id, String field1, int field2) {
            this.id = id;
            this.field1 = field1;
            this.field2 = field2;
        }
    }


    @Test
    public void testRandomAccessFile() throws IOException {
        //일반 파일을 불러올 경우

        //읽어들일 사이즈를 정한다.
        int seekSize = 5;

        RandomAccessFile accessFile = new RandomAccessFile("text.txt", "r");

        String line = "";

        while ((line = accessFile.readLine()) != null) {
            System.out.println("전체 문자열 : " + line);
        }

        System.out.println("문자열의 총 길이 : " + accessFile.length() + "\n");

        byte[] dataFile = null;

        long size = accessFile.length() / seekSize + (accessFile.length() % seekSize == 0 ? 0 : 1);

        for (int i = 0; i < size; i++) {

            dataFile = new byte[seekSize];

            accessFile.seek(i * seekSize);
            accessFile.read(dataFile);

            System.out.printf("pointer : %02d str : %s \n", accessFile.getFilePointer(), new String(dataFile).trim());
        }

        accessFile.close();
    }
}

