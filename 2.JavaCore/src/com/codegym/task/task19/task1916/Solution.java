package com.codegym.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Tracking changes

*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileReader fr1 = new FileReader(file1);
        FileReader fr2 = new FileReader(file2);

        BufferedReader br1 = new BufferedReader(fr1);
        BufferedReader br2 = new BufferedReader(fr2);

        ArrayList<String> lines1 = new ArrayList<>();
        ArrayList<String> lines2 = new ArrayList<>();

        while (br1.ready()) {
            lines1.add(br1.readLine());
        }
        while (br2.ready()) {
            lines2.add(br2.readLine());
        }
        fr1.close();
        fr2.close();
        //br1.close();
        //br2.close();

        //nothing interesting until here, we have to iterate simultaneously through both arrays (but I think it could be
        //either done by just reading straight from the files using the same algorithm) so we need an Iterator
        Iterator <String> it2 = lines2.iterator();
        String line2 = it2.next();

        //algorithm:
        // if lineB is in array A && lineA is not in array B - > add line A with REMOVED, next line from A
        // if lineB is not in array A && lineA is in array B - > add line B with ADDED, next line from B
        // if lineB is in array A && lineA is in array B - > add line A or B with SAME, next lines from A and B

        for (String s:lines1) {
            if (lines1.contains(line2) && !lines2.contains(s)) {
                lines.add(new LineItem(Type.REMOVED, s));
            }
            if (lines2.contains(s) && !lines1.contains(line2)) {
                lines.add(new LineItem(Type.ADDED, line2));
                if (it2.hasNext()) {
                    line2 = it2.next();
                }
            }
            if (s.equals(line2)) {
                lines.add(new LineItem(Type.SAME, s));
                if (it2.hasNext()) {
                    line2 = it2.next();
                }
                continue;
            }
        }

        if(lines1.size()>=lines2.size())
            lines.add(new LineItem(Type.ADDED,line2));



    }

    public static enum Type {
        ADDED,        // New line added
        REMOVED,      // Line deleted
        SAME          // No change
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
