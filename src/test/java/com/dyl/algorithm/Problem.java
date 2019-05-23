package com.dyl.algorithm;

/**
 * 设有ｎ个人依围成一圈，从第１个人开始报数，数到第ｍ个人出列，然后从出列的下一个人开始报数
 * ，数到第ｍ个人又出列，…，
 * 如此反复到所有的人全部出列为止。设ｎ个人的编号分别为1，2，…，n，打印出出列的顺序
 */
public class Problem {

    private static boolean same(int[] p,int l,int n){
        for(int i=0;i<l;i++){
            if(p[i]==n){
                return true;
            }
        }
        return false;
    }
    public static void play(int playerNum, int step){
        int[] p=new int[playerNum];
        int counter = 1;
        while(true){
            if(counter > playerNum*step){
                break;
            }
            for(int i=1;i<playerNum+1;i++){
                while(true){
                    if(same(p,playerNum,i)==false) break;
                    else i=i+1;
                }
                if(i > playerNum)break;
                if(counter%step==0){
                    System.out.print(i + " ");
                    p[counter/step-1]=i;
                }
                counter+=1;
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        play(5, 7);
    }

}
