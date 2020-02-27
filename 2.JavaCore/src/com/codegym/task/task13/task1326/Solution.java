package com.codegym.task.task13.task1326;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

/* 
Sorting even numbers from a file

*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        try{
            String fileName =rdr.readLine();
            FileInputStream inStream = new FileInputStream(fileName);
            ArrayList<Integer> list = new ArrayList<Integer>();
            int data;
            while (inStream.available()>0){
                data=inStream.read();
                list.add(data);
            }
            ArrayList<Integer> list2 = list;
            Iterator<Integer> iter = list.iterator();
            Iterator<Integer> iter2 = list2.iterator();
            while(iter.hasNext()){
                int element = iter.next();
                if(element%2==1){
                    iter2=iter;
                    iter2.remove();
                }
            }
            Collections.sort(list2);
            for(int a:list2){
                System.out.println(a);
            }
            
            rdr.close();
            inStream.close();
        }
        catch(IOException e){
            
        }
        
    }
}
