package sis.search;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sis.util.TestUtil;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    private int numberOfResults = 0;
    private Server server;
    private static final long TIMEOUT = 3000L;
    private static final String[] URLS = {
            SearchTest.URL, SearchTest.URL, SearchTest.URL
    };

    @BeforeEach
    void setUp() throws IOException {
        TestUtil.delete(SearchTest.FILE);
        LineWriter.write(SearchTest.FILE, SearchTest.TEST_HTML);

        ResultsListener listener = new ResultsListener() {
            public void executed(Search search) {
                numberOfResults++;
            }
        };
        server = new Server(listener);
    }

    @AfterEach
    void tearDown() throws Exception {
        assertTrue(server.isAlive());
        server.shutDown();
        server.join(3000);
        assertFalse(server.isAlive());
        TestUtil.delete(SearchTest.FILE);
    }

    @Test
    public void testSearch() throws Exception {

        long start = System.currentTimeMillis();
        for (String url : URLS) {
            server.add(new Search(url, "xxx"));
        }

        long elapsed = System.currentTimeMillis() - start;
        long averageLatency = elapsed / URLS.length;

        assertTrue(averageLatency < 20);
        assertTrue(waitForResults());

    }

    private boolean waitForResults() {
        long start = System.currentTimeMillis();
        while (numberOfResults < URLS.length) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                if (System.currentTimeMillis() - start > TIMEOUT)
                    return false;
            }
        }
        return true;
    }
}