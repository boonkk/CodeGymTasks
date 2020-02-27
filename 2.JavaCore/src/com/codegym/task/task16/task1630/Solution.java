package com.codegym.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }catch (IOException e){}
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, IOException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //System.out.println(f.getFileContents());
    }


    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContents() throws IOException;

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String fileName;
        String end="";
        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        @Override
        public String getFileContents() throws IOException {
            return end.trim();
        }

        @Override
        public void run() {
            String print="";
            try {
                FileReader file = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(file);

                while (reader.ready()) {
                    String start = reader.readLine();
                    print += start + " ";

                }
                reader.close();
                end = print;
            } catch (IOException e) {

            }
            try {
                System.out.println(getFileContents());
            } catch(IOException e ){

            }

        }
    }
}
