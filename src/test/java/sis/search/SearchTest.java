package sis.search;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sis.util.TestUtil;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

//    private static final String URL = "http://www.langrsoft.com";
    public static final String[] TEST_HTML = {
            "<html>",
            "<body>",
            "Book: Agile Java, by Jeff Langr<br/>",
            "Synopsis : Mr Langr teaches you<br/>",
            "Java via test-driven development.<br/>",
            "</body></html>"
    };

    public static final String FILE = "testFileSearch.html";
    public static final String URL = "file:" + FILE;

    @BeforeEach
    void setUp() throws IOException {
        TestUtil.delete(FILE);
        LineWriter.write(FILE, TEST_HTML);
    }

    @AfterAll
    static void afterAll() {
        TestUtil.delete(FILE);

    }

    @Test
    public void testCreate() throws IOException {
        Search search = new Search(URL, "x");
        System.out.println(URL+" : " + search.getUrl());
        assertEquals(URL, search.getUrl().toString());
        assertEquals("x", search.getText());
    }

    @Test
    public void testPositiveSearch() throws IOException {
        Search search = new Search(URL, "Jeff Langr");
        search.execute();
        assertTrue(search.matches() >= 1);
        assertFalse(search.errored());
    }

    @Test
    public void testErroredSearch() throws IOException {

        final String badUrl = URL + "/z2468.html";
        Search search = new Search(badUrl, "whatever");
        search.execute();
        assertTrue(search.errored());
        assertEquals(FileNotFoundException.class, search.getError().getClass());
    }
}