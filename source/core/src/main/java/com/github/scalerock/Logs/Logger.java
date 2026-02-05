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

    /**White - ASCI color*/
    private static final String defult_color = "\u001B[0m";
    /**Grean - ASCI color*/
    private static final String info_color = "\u001B[32m";
    /**Blue - ASCI color*/
    private static final String debug_color = "\u001B[36m";
    /**Yellow - ASCI color*/
    private static final String warn_color = "\u001B[33m";
    /**Read - ASCI color*/
    private static final String error_color = "\u001B[31m";


    /**
        <code>LEVEL</code> - enume for log leven (ig. info, debug, etc.)
     */
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

        final var time = ZonedDateTime.now(ZoneId.systemDefault()).format(timeFormatter);
        final var thread = Thread.currentThread().getName();

        final var out_log = colorFor(level) + format_log(
                time,
                thread,
                level.name(),
                class_name,
                msg
        ) + defult_color;

        System.out.println(out_log);
    }
    private static void log(@NotNull String class_name,
                            @NotNull String msg,
                            @NotNull LEVEL level,
                            @NotNull Throwable throwable) {

        final var time = ZonedDateTime.now(ZoneId.systemDefault()).format(timeFormatter);
        final var thread = Thread.currentThread().getName();

        final var out_log = colorFor(level) + format_log(
                time,
                thread,
                level.name(),
                class_name,
                msg
        ) + defult_color;

        System.out.println(out_log);
        throwable.printStackTrace(System.out);
    }

    /** Returns a not ASCI encode color*/
    @Contract(pure = true)
    private static @NotNull String colorFor(@NotNull LEVEL level) {
        return switch (level) {
            case DEBUG -> debug_color;
            case INFO -> info_color;
            case WARN -> warn_color;
            case ERROR -> error_color;
            default -> defult_color;
        };
    }

    /**
     *  Log info
     * @param clazz Class whitch use loger
     * @param msg message
     */
    public static void INFO(Class<?> clazz, @NotNull String msg){
        final var class_name = (clazz == null) ? "Unknown" : clazz.getSimpleName();
        log(
                class_name,
                msg,
                LEVEL.INFO
        );
    }

    /**
     * Log info with throwable
     * @param clazz Class which uses logger
     * @param msg - message
     * @param throwable exception to log
     */
    public static void INFO(Class<?> clazz,
                            @NotNull String msg,
                            @NotNull Throwable throwable){
        final var class_name = (clazz == null) ? "Unknown" : clazz.getSimpleName();
        log(
                class_name,
                msg,
                LEVEL.INFO,
                throwable
        );
    }

    /**
     * Log debug info
     * @param clazz Class which uses logger
     * @param msg message
     */
    public static void DEBUG(Class<?> clazz, @NotNull String msg){
        final var class_name = (clazz == null) ? "Unknown" : clazz.getSimpleName();
        log(
                class_name,
                msg,
                LEVEL.DEBUG
        );
    }

    /**
     * Log debug info with throwable
     * @param clazz Class which uses logger
     * @param msg - message
     * @param throwable exception to log
     */
    public static void DEBUG(Class<?> clazz,
                             @NotNull String msg,
                             @NotNull Throwable throwable){
        final var class_name = (clazz == null) ? "Unknown" : clazz.getSimpleName();
        log(
                class_name,
                msg,
                LEVEL.DEBUG,
                throwable
        );
    }

    /**
     * Log warning message
     * @param clazz Class which uses logger
     * @param msg message
     */
    public static void WARN(Class<?> clazz, @NotNull String msg){
        final var class_name = (clazz == null) ? "Unknown" : clazz.getSimpleName();
        log(
                class_name,
                msg,
                LEVEL.WARN
        );
    }

    /**
     * Log warning message with throwable
     * @param clazz Class which uses logger
     * @param msg message
     * @param throwable exception to log
     */
    public static void WARN(Class<?> clazz,
                            @NotNull String msg,
                            @NotNull Throwable throwable){
        final var class_name = (clazz == null) ? "Unknown" : clazz.getSimpleName();
        log(
                class_name,
                msg,
                LEVEL.WARN,
                throwable
        );
    }

    /**
     * Log error message
     * @param clazz Class which uses logger
     * @param msg message
     */
    public static void ERROR(Class<?> clazz, @NotNull String msg){
        final var class_name = (clazz == null) ? "Unknown" : clazz.getSimpleName();
        log(
                class_name,
                msg,
                LEVEL.ERROR
        );
    }

    /**
     * Log error message with throwable
     * @param clazz Class which uses logger
     * @param msg message
     * @param throwable exception to log
     */
    public static void ERROR(Class<?> clazz,
                             @NotNull String msg,
                             @NotNull Throwable throwable){
        final var class_name = (clazz == null) ? "Unknown" : clazz.getSimpleName();
        log(
                class_name,
                msg,
                LEVEL.ERROR,
                throwable
        );
    }



}
