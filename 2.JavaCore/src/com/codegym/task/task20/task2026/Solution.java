package com.codegym.task.task20.task2026;

/* 
Rectangle algorithms

*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Must be 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Must be 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int[][]at = new int[a.length][a[0].length];
        for(int y =0; y<a.length; y++) {
            for (int x = 0; x < a[0].length; x++) {
                if (a[y][x]==1) at[y][x]=1;
            }
        }

        int count = 0;


        int foundy = 0;
        int foundx =0;
        int yzero = 0;
        int xzero = 0;
        for(int y =0; y<at.length; y++) {
            int xLen = at[0].length;
            int yLen = at.length;
            for(int x=0;x<at[0].length;x++) {
                if(at[y][x] == 1) {
                    foundx=1;
                    foundy=1;
                    int yt = y;
                    int xt = x;
                    while(xt<xLen) {
                        yt=y;
                        while (yt < yLen) {
                            if( at[yt][xt] == 1 ) {
                                at[yt][xt] = count + 2;
                            }
                            if (at[yt][xt] == 0||yt==yLen-1) {
                                if(foundy==1)
                                    foundy=0;
                                yt=yLen;

                            }
                            yt++;
                        }
                        if(at[y][xt]==0||xt==yLen-1) {
                            foundx=0;
                            xt=xLen; //break dla while'a z xt
                        }
                        if(foundx==0 && foundy==0)
                            count++;

                        xt++;
                    }
                }
            }
        }

        for(int y =0; y<a.length; y++) {
            for (int x = 0; x < a[0].length; x++) {
                System.out.print(at[y][x]);

            }
            System.out.println("");
        }
        return count;
    }


}
