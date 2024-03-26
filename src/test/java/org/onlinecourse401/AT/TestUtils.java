package org.onlinecourse401.AT;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class TestUtils {

    public static String captureSystemOutput(Runnable runnable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream, true, StandardCharsets.UTF_8);
        PrintStream originalPrintStream = System.out;
        System.setOut(printStream);

        try {
            runnable.run();
            return byteArrayOutputStream.toString(StandardCharsets.UTF_8);
        } finally {
            System.setOut(originalPrintStream);
        }
    }
}
