package com.codegym.task.task18.task1827.asdas;

/* 
Prices

*/



import java.io.*;
import java.util.ArrayList;


public class Solutionfds {
    public static void main(String[] args) throws Exception {
        if (args.length<=0)
            return;
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String fileName = reader.readLine();
                reader.close();

                FileInputStream fis = new FileInputStream(fileName);
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(fis));
                String line;

                ArrayList<String> list = new ArrayList<>();
                while(reader2.ready()){
                    list.add(reader.readLine());
                }
                reader2.close();
                fis.close();

                String idmax=getNewId(list);

                FileOutputStream fos = new FileOutputStream(fileName);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
                for(String i:list){
                    writer.write(i);
                    writer.write('\n');
                }


                StringBuffer sb = new StringBuffer();
                sb.append(String.format("&s-8%-30s%-8s%-4s",idmax,args[1],args[2],args[3]));

                writer.write('\n'+sb.toString());
                writer.close();
                fos.close();



        }
    

    private static String getNewId(ArrayList<String> list) {
        int maxId = 0;
        for (String s : list) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                if (s.charAt(i) != ' ') {
                    sb.append(s.charAt(i));
                }
            }
            maxId = Integer.parseInt(sb.toString()) > maxId ? Integer.parseInt(sb.toString()) : maxId;
        }
        StringBuilder newId = new StringBuilder();
        newId.append(maxId + 1);
        for (int i = (maxId + "").length(); i < 8; i++) {
            newId.append(' ');
        }
        return newId.toString();
    }
}
