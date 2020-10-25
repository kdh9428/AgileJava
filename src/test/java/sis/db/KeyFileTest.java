package sis.db;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KeyFileTest {

    private static final String FILENAME = "keyfiletest.idx";
    private static final String KEY = "key";
    private static final long POSITION = 1;
    private static final int LENGTH = 100;

    private KeyFile keyFile;

    @BeforeEach
    void setUp() {
        TestUtil.delete(FILENAME);
        keyFile = new KeyFile(FILENAME);
    }

    @Test
    protected void tearDown() throws IOException {
        TestUtil.delete(FILENAME);
        keyFile.close();
    }

    @Test
    public void testCreate() {

        assertEquals(0, keyFile.size());
    }

    @Test
    public void testAddEntry() {

        keyFile.add(KEY, POSITION, LENGTH);

        assertEquals(1, keyFile.size());
        assertTrue(keyFile.containsKey(KEY));
        assertEquals(POSITION, keyFile.getPosition(KEY));
        assertEquals(LENGTH, keyFile.getLength(KEY));
    }

    @Test
    public void testReopen() throws IOException {
        keyfile.add(KEY, POSITION, LENGTH);

        keyFile.close();

        keyFile = new KeyFile(FILENAME);
        assertEquals(1, keyFile.size());
        assertEquals(POSITION, keyfile.getPosition(KEY));
        assertEquals(LENGTH, keyFile.getLength(KEY));
    }
}