package com.github.scalerock.Logs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InaccessibleObjectException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTest {

    @DisplayName("Log formating tests")
    @Test
    void formatLogTest() throws NoSuchMethodException, SecurityException, InaccessibleObjectException, NullPointerException  {
        try {
            Method formatLog = Logger.class.getDeclaredMethod(
                    "format_log",
                    String.class, String.class, String.class, String.class, String.class
            );
            formatLog.setAccessible(true);

            String info_log = (String) formatLog.invoke(
                    null,
                    "12:00", "main", "INFO", "Test", "Hello World"
            );

            String debug_log = (String) formatLog.invoke(
                    null,
                    "15:21", "main", "DEBUG", "Test", "Hello World"
            );

            String warn_log = (String) formatLog.invoke(
                    null,
                    "12:00", "main", "WARN", "Test", "Hello World"
            );

            String error_log = (String) formatLog.invoke(
                    null,
                    "12:00", "main", "ERROR", "Test", "Hello World"
            );
            assertEquals("12:00 [main] [INFO] Test - Hello World", info_log);
            assertEquals("15:21 [main] [DEBUG] Test - Hello World", debug_log);
            assertEquals("12:00 [main] [WARN] Test - Hello World", warn_log);
            assertEquals("12:00 [main] [ERROR] Test - Hello World", error_log);

        } catch (NoSuchMethodException |
                 InvocationTargetException |
                 IllegalAccessException |
                 InaccessibleObjectException |
                 NullPointerException |
                 SecurityException e) {
            throw new RuntimeException(e);
        }

    }
}
