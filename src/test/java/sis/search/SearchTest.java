package sis.search;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchTest {

    private static final String URL = "http://www.langrsoft.com";

    @Test
    public void testCreate() throws IOException {
        Search search = new Search(URL, "x");

        assertEquals(URL, search.getUrl());
        assertEquals("x", search.getText());
    }

    @Test
    public void testPositiveSearch() throws IOException {

    }

}