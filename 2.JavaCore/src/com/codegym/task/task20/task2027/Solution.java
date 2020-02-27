package com.codegym.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Word search

*/
public class Solution {
    public static void main(String[] args) {
        int[][] wordSearch = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        ArrayList<Word> list = (ArrayList<Word>)detectAllWords(wordSearch, "jrrad","jhvo","kovh");
        if(!list.isEmpty() ) {
            for(Word s : list) {
                System.out.println(s.text + " " + s.startX + "," + s.startY + " : " + s.endX + "," + s.endY);
            }
        }
        /*
Expected result
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] wordSearch, String... words) {

        ArrayList<Word> result = new ArrayList<>();
        int xlen = wordSearch[0].length;
        int ylen = wordSearch.length;
        for(String word : words) {
                char c = word.charAt(0);
                char c2 = word.charAt(1);
                for(int y=0; y<ylen;y++) {
                    for(int x = 0; x<xlen;x++) {
                        if(wordSearch[y][x]==c) {
                            int ych;
                            int xch;
                            if(y-1>=0)
                                ych=y-1;
                            else
                                ych=y;

                            if(x-1>=0) {
                                xch=x-1;
                            }else
                                xch=x;

                            int yche;
                            int xche;
                            if(x+1<xlen)
                                xche = x+1;
                            else xche = x;

                            if(y+1<ylen)
                                yche=y+1;
                            else yche = y;
                            for(int ys=ych;ys<=yche;ys++) {
                                for(int xs = xch; xs<=xche;xs++) {
                                    if(wordSearch[ys][xs]==c2) {
                                        int mx = xs-x;
                                        int my = ys-y;
                                        int X = x;
                                        int Y = y;
                                        int counter=0;
                                        int tempcounter = 0;
                                        for(char cw : word.toCharArray()) {
                                            if(cw == wordSearch[Y][X]){
                                                counter++;
                                            }
                                            if(X+mx>=0 && X+mx<xlen && Y+my>=0 && Y+my<ylen && tempcounter<word.length()-1) {
                                                X += mx;
                                                System.out.print(X + ", ");
                                                Y += my;
                                                System.out.print(Y + ", ");

                                            }
                                            tempcounter++;
                                            System.out.println("");

                                        }
                                        if(counter==word.length()){
                                            Word addition = new Word(word);
                                            addition.setStartPoint(x,y);
                                            addition.setEndPoint(X,Y);
                                            result.add(addition);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        return result;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
