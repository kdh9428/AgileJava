package sis.util;

import org.junit.Assert;

import java.io.File;

public class TestUtil {

    public static void assertGone(String... filenames) {
        for (String filename : filenames) {
            Assert.assertFalse(new File(filename).exists());
        }
    }

    public static void delete(String filename) {
        File file = new File(filename);

        if (file.exists()) {
            Assert.assertTrue(file.delete());
        }
    }
}
