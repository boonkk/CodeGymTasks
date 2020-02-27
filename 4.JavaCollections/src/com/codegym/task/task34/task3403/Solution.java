package com.codegym.task.task34.task3403;


/*
Factorization using recursion

*/
public class Solution {

    public void recurse(int n) {
        if(n<=1)
            return;

        int divisor = 2;

        while(divisor<=n) {
            if(n%divisor==0) {
                System.out.print(divisor + " ");
                recurse(n/divisor);
                return;
            }
            divisor++;
        }


        }

}

//    int divisor = 2;
//        if (n <= 1) {
//                return;
//                }
//                int biggestDiv=1;
//                while ((Math.sqrt(n) >= divisor)) {
//                if((n % divisor==0))
//                biggestDiv=divisor;
//                divisor++;
//                }
//                if(biggestDiv!=1) {
//                recurse(n / biggestDiv);
//                System.out.print(biggestDiv + " ");
//                }else {
//                System.out.print(2 + " ");
//                }