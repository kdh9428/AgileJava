package AgileLesson8;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.logging.*;
import java.util.logging.Formatter;

import static org.junit.jupiter.api.Assertions.*;

public class LoggingTest {

    @Test
    public void testLogging() {
        try {
            throwException();
            fail("Excepted an exception was thrown from throwException()");
        } catch (Exception exceptedException) {
            log(exceptedException);
        }
    }

    private void throwException() {
        throw new RuntimeException("runtime exception arise");
    }


    private void log(Exception e){
        List<StackTraceElement> stackTraceElements = Arrays.asList(e.getStackTrace());
        ListIterator<StackTraceElement> li = stackTraceElements.listIterator(stackTraceElements.size());

        StringBuilder exceptionMessageBuilder = new StringBuilder();
        exceptionMessageBuilder.append(e.getMessage() + "\n");
        exceptionMessageBuilder.append("===========test==========="+"\t");

        while (li.hasPrevious()){
            StackTraceElement trace = li.previous();
            exceptionMessageBuilder.append(trace.toString() + "\n");
        }

        Logger logger = Logger.getAnonymousLogger();
        logger.warning(exceptionMessageBuilder.toString());
    }

    @Test
    public void testCountingLog(){
        Logger logger = Logger.getAnonymousLogger();
        CountingLogHandler handler = new CountingLogHandler();

        logger.addHandler(handler);

        logger.setLevel(Level.ALL);
        handler.setLevel(Level.ALL);

        logger.severe("severe event");
        logger.warning("warning event");
        logger.warning("warning event");
        logger.warning("warning event");

        System.out.println(handler.getCount(Level.SEVERE));
        System.out.println(handler.getCount(Level.WARNING));

        assertEquals(1, handler.getCount(Level.SEVERE));
        assertEquals(3, handler.getCount(Level.WARNING));
        assertEquals(0, handler.getCount(Level.INFO));
        assertEquals(0, handler.getCount(Level.CONFIG));
    }

    @Test
    public void testCountingLogFormatter(){
        CountingLogHandler handler = new CountingLogHandler();
        assertTrue(handler.getFormatter() instanceof CustomFormatter);

    }
    @Test
    public void testCountingLogHandlerLoggingSummary(){

        CountingLogHandler handler = new CountingLogHandler();
        CustomFormatter formatter = new CustomFormatter(handler);

        StringBuilder summaryBuilder = new StringBuilder();

        LogRecord record = new LogRecord(Level.INFO, "info message blah");
        for (int i = 0; i < 4; i++){
            handler.publish(record);
            summaryBuilder.append(formatter.format(record) + "\n");
        }

        String expectedSummary = summaryBuilder.toString();
        System.out.println(expectedSummary);

    }

    @Test
    public void tesCustomFormatter(){
        Formatter formatter = new CustomFormatter();

        Level level = Level.WARNING;
        String message = "A warning message..";

        LogRecord record = new LogRecord(level, message);

        String formattedMessage = formatter.format(record);
        String expectedFormattedMessage = String.format("%s: %s\n", level, message);
        assertEquals(expectedFormattedMessage, formattedMessage);

        CountingLogHandler handler = new CountingLogHandler();
        handler.publish(record);
        handler.publish(record);

        formatter = new CustomFormatter(handler);
        formattedMessage = formatter.format(record);

        expectedFormattedMessage = String.format("%s: %s(%s total = %d)\n",level, message, level, ((CountingLogHandler)handler).getCount(level));

        System.out.println(record.getMessage());
        System.out.println(formattedMessage);
        System.out.println(expectedFormattedMessage);

    }
}

class CountingLogHandler extends Handler {

    private Map<Level, Integer> levelMessageCounter = new HashMap<>();
    private StringBuilder summaryBuilder = new StringBuilder();

    public CountingLogHandler() {
        Formatter formatter = new CustomFormatter(this);
        setFormatter(formatter);
    }

    @Override
    public void publish(LogRecord record) {
        Level level = record.getLevel();

        int originalCount = getCount(level);

        levelMessageCounter.put(level, originalCount + 1);

        Formatter formatter = getFormatter();
        summaryBuilder.append(formatter.format(record) + "\n");

    }

    public int getCount(Level level) {
        if (levelMessageCounter.containsKey(level))
            return levelMessageCounter.get(level);
        return 0;
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }

    public String getLoggingSummary(){
        return summaryBuilder.toString();
    }
}
