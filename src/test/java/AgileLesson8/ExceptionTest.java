package AgileLesson8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExceptionTest {

    private String Exception_Message = "Somebody should catch this!";

    @Test
    public void testBlowsUpException(){

        try {
        blowsUp();

        }catch (RuntimeException e){
            e.printStackTrace();
        }

    }

    private void blowsUp() {
        throw new SimpleException(Exception_Message);
    }

    @Test
    public void testRethrowsException(){

        try {
        rethrows();

        }catch (RuntimeException e){
            Throwable cause = e.getCause();
            assertTrue(cause instanceof RuntimeException);
            assertEquals(Exception_Message, cause.getMessage());
        }
    }

    private void rethrows() {
        try {
            blowsUp();
        }catch (RuntimeException e){
            throw new RuntimeException(e);

        }
    }


    private class SimpleException extends RuntimeException {
        public SimpleException(String exception_message) {
            super(exception_message);
        }
    }
}
