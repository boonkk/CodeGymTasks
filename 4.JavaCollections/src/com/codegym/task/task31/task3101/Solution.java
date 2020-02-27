package com.codegym.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Iterating through a file tree

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        File file = new File(path);

        File beforeRename = new File(resultFileAbsolutePath);
        File afterRename = new File(beforeRename.getParent()+"\\allFilesContent.txt"); // Use "/" as the path separator. But we should "\\" !
        FileUtils.renameFile(beforeRename, afterRename);

        ArrayList<File> chosenOnes = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.add(file);

        while(!queue.isEmpty()) {
            File curr = queue.poll();
            File[] currFiles = curr.listFiles();
            if (currFiles != null){
                for (File f : currFiles){
                    if (f.isDirectory()){
                        queue.add(f);
                    }
                    else{
                        if (f.isFile() && f.length() <= 50){
                            chosenOnes.add(new File(f.getAbsolutePath()));
                        }
                    }
                }
            }
        }

        Collections.sort(chosenOnes, new CompareFileName());

        // sequentially write contents of each file
        FileOutputStream fileOutputStream = new FileOutputStream(afterRename);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        BufferedReader reader = null;
        for (File f : chosenOnes){
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            while(reader.ready()){
                writer.write(reader.readLine());
                writer.flush();
            }
            writer.write("\n"); // After the body of each file, write "\n".
        }


        writer.close();
        fileOutputStream.close();
        reader.close();
    }
    static class CompareFileName implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return ((File) o1).getName().compareTo(((File) o2).getName());
        }
    }




}