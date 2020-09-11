package sis.studentinfo;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class HandlerTest extends Handler {

    private LogRecord record;

    @Override
    public void publish(LogRecord record) {
        this.record = record;
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }

    public String getMessage() {
        return record.getMessage();
    }
}
