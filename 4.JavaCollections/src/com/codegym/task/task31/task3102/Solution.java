package com.codegym.task.task31.task3102;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Find all the files

*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            String p = queue.poll();
            File file = new File(p);
            for(File f : file.listFiles()) {
                if(f.isDirectory())
                    queue.add(f.getAbsolutePath());
                else if (f.isFile())
                    result.add(f.getAbsolutePath());
            }
        }

        return result;

    }

    public static void main(String[] args) {

    }
}