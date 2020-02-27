package com.codegym.task.task30.task3012;

/* 
Derive a specific number

*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        int[] powersOf3={1, 3, 9, 27, 81, 243, 729, 2187};
        String signsString="";
        int numberCopy=number;
        while (numberCopy>0)
        {
            if (numberCopy%3==0)
            {
                signsString=signsString+"0";
                numberCopy/=3;
            }
            else if (numberCopy%3==1)
            {
                signsString=signsString+"+";
                numberCopy/=3;
            }
            else if (numberCopy%3==2)
            {
                signsString=signsString+"-";
                numberCopy/=3;
                numberCopy++;
            }
        }
        int sum=0;
        String result="";
        for (int i=0;i<signsString.length(); i++)
        {
            if (signsString.charAt(i)=='+') {
                result+=" + "+powersOf3[i];
                sum+=powersOf3[i];
            }
            else if (signsString.charAt(i)=='-')
            {
                result+=" - "+powersOf3[i];
                sum-=powersOf3[i];
            }
        }
        System.out.println(sum+" ="+result);
    }
}