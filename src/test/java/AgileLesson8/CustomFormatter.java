package AgileLesson8;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

    private CountingLogHandler handler;

    public CustomFormatter() {
    }

    public CustomFormatter(CountingLogHandler handler) {
        this.handler = handler;
    }

    @Override
    public String getHead(Handler h) {
        return "START LOG\n 스타트 : ";
    }

    @Override
    public String format(LogRecord record) {
        Level level = record.getLevel();
        String message = record.getMessage();

        if (handler == null){
            return String.format("%s: %s\n", level, message);
        }
        return String.format("%s: %s (%s total = %d\n) 커스텀 포멧 세팅", level, message, level, handler.getCount(level));
    }
}
