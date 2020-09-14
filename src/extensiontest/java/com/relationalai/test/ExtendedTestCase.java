package com.relationalai.test;

import junit.framework.TestCase;

public class ExtendedTestCase extends TestCase {
    @FunctionalInterface
    public interface CallableTest {
        public void call() throws Exception;
    }

    // Addes a missing JUnit 5 method to JUnit 4
    public static void assertThrows(Class exceptionClass, CallableTest fn) {
        try {
            fn.call();
        } catch (Exception e) {
            if (e.getClass().equals(exceptionClass)) {
                assertTrue(true);
                return;
            }
        }
        fail();
    }
}
