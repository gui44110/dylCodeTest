package com.dyl.findSort;

public class ErClass {

    public static int rank(int[] a, int  m){
        int low = 0;
        int hight = a.length - 1;

        while(low<hight){
            int mid = low +(hight-low)/2;

            if(a[mid]>m){
                hight = mid - 1;
            }else if(a[mid]<m){
                low = mid +1;
            }else{
                return mid;
            }
        }

        return  -1;

    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6};
        System.out.println(rank(a,5));
    }
}
