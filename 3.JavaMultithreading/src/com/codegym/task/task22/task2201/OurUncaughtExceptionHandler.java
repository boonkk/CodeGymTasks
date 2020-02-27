package com.codegym.task.task22.task2201;

public class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.out.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.out.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        int i = e.toString().indexOf(e.getMessage());
        String s = String.format(string, e.toString().substring(10,i-2), e.getMessage(), t.getName());

        return s;
    }
    //RuntimeException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : 3#






    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        int i = e.toString().indexOf(e.getMessage());
        String s = String.format(string, e.getMessage(), e.toString().substring(10,i-2), t.getName());

        return s;
    }

    //java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : StringForSecondThreadTooShortException : 2#

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        int i = e.toString().indexOf(e.getMessage());
        String s = String.format(string, t.getName(), e.toString().substring(10,i-2), e.getMessage());

        return s;
    }

    //1# : StringForFirstThreadTooShortException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1
}
