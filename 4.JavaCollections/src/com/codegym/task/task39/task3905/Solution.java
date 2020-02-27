package com.codegym.task.task39.task3905;

/* 
Fill 'er up

*/

public class Solution {
    public static void main(String[] args) {
        Color[][] colors = new Color[10][10];
        for(int i=0; i<10;i++) {
            for(int j=0; j<10;j++) {
                colors[i][j] = Color.ORANGE;
            }
        }
        colors[0][5] = Color.BLUE;
        colors[1][6] = Color.BLUE;
        colors[2][5] = Color.BLUE;
        colors[3][4] = Color.BLUE;
        colors[4][3] = Color.BLUE;
        colors[5][2] = Color.BLUE;
        colors[6][2] = Color.BLUE;
        colors[7][1] = Color.BLUE;
        colors[8][0] = Color.BLUE;
        colors[9][0] = Color.BLUE;


        for(int i=0; i<10;i++) {
            for(int j=0; j<10;j++) {
                System.out.print(colors[i][j] + " ");
            }
            System.out.println();
        }
        PhotoPaint photoPaint = new PhotoPaint();
        photoPaint.paintFill(colors,0,0,Color.RED);

        System.out.println();
        System.out.println();

        for(int i=0; i<10;i++) {
            for(int j=0; j<10;j++) {
                System.out.print(colors[i][j] + " ");
            }
            System.out.println();
        }

    }
}
