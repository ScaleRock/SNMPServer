/*
MIT License

Copyright (c) 2026 ScaleRock

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/


package com.github.scalerock.Logs;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 <code>Logger</code> is a static class designed for logging. It supports messages and exceptions (Throwable) in the following formats: INFO, DEBUG, WARN, ERROR.
 Each login type has a corresponding color.
 @since 0.1.1
 */
public class Logger {
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS z");

    private enum LEVEL {
        INFO,
        DEBUG,
        WARN,
        ERROR
    }

    @Contract(pure = true)
    private static @NotNull String format_log(
            @NotNull String time,
            @NotNull String thread,
            @NotNull String leven,
            @NotNull String class_name,
            @NotNull String msg) {
        return String.format("%s [%s] [%s] %s - %s",
                time,
                thread,
                leven,
                class_name,
                msg);
    }

    private static void log(@NotNull String class_name,
                            @NotNull String msg,
                            @NotNull LEVEL level) {

        System.out.println(colorFor(level) + format_log(
                ZonedDateTime.now(ZoneId.systemDefault()).format(timeFormatter),
                Thread.currentThread().getName(),
                level.name(),
                class_name,
                msg
        ) + "\u001B[0m");
    }
    private static void log(@NotNull String class_name,
                            @NotNull String msg,
                            @NotNull LEVEL level,
                            @NotNull Throwable throwable) {
        System.out.println(colorFor(level) + format_log(
                ZonedDateTime.now(ZoneId.systemDefault()).format(timeFormatter),
                Thread.currentThread().getName(),
                level.name(),
                class_name,
                msg
        ) + "\u001B[0m");
        throwable.printStackTrace(System.out);
    }

    public static void INFO(Class<?> clazz, @NotNull String msg){
        log(
                (clazz == null) ? "Unknown" : clazz.getSimpleName(),
                msg,
                LEVEL.INFO
        );
    }
    public static void INFO(Class<?> clazz,
                            @NotNull String msg,
                            @NotNull Throwable throwable){
        log(
                (clazz == null) ? "Unknown" : clazz.getSimpleName(),
                msg,
                LEVEL.INFO,
                throwable
        );
    }

    public static void DEBUG(Class<?> clazz, @NotNull String msg){
        log(
                (clazz == null) ? "Unknown" : clazz.getSimpleName(),
                msg,
                LEVEL.DEBUG
        );
    }
    public static void DEBUG(Class<?> clazz,
                            @NotNull String msg,
                            @NotNull Throwable throwable){
        log(
                (clazz == null) ? "Unknown" : clazz.getSimpleName(),
                msg,
                LEVEL.DEBUG,
                throwable
        );
    }

    public static void WARN(Class<?> clazz, @NotNull String msg){
        log(
                (clazz == null) ? "Unknown" : clazz.getSimpleName(),
                msg,
                LEVEL.WARN
        );
    }
    public static void WARN(Class<?> clazz,
                            @NotNull String msg,
                            @NotNull Throwable throwable){
        log(
                (clazz == null) ? "Unknown" : clazz.getSimpleName(),
                msg,
                LEVEL.WARN,
                throwable
        );
    }

    public static void ERROR(Class<?> clazz, @NotNull String msg){
        log(
                (clazz == null) ? "Unknown" : clazz.getSimpleName(),
                msg,
                LEVEL.ERROR
        );
    }
    public static void ERROR(Class<?> clazz,
                            @NotNull String msg,
                            @NotNull Throwable throwable){
        log(
                (clazz == null) ? "Unknown" : clazz.getSimpleName(),
                msg,
                LEVEL.ERROR,
                throwable
        );
    }

    @Contract(pure = true)
    private static @NotNull String colorFor(@NotNull LEVEL level) {
        return switch (level) {
            case DEBUG -> "\u001B[36m";
            case INFO -> "\u001B[32m";
            case WARN -> "\u001B[33m";
            case ERROR -> "\u001B[31m";
            default -> "\u001B[0m";
        };
    }
}
