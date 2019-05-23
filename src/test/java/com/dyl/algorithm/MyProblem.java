package com.dyl.algorithm;

public class MyProblem {

    public void play(int m,int n){

        int[] p = new int[m];
        int[] result = new int[m];

        for(int i = 0;i<m;i++){
            p[i] = i+1;
        }

        for(int j=0;j<m;j++){
            int k = 0;
            while (k == n){
                for(int a=0;a<m;a++){
                    k += p[a];
                }
            }

        }

    }
}
