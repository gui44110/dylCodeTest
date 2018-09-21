package com.dyl.sort;

import java.util.Arrays;

public class SortClass {

    public static void quickSort(int[] a ,int low,int high){
        if(low>high){
            return;
        }

        int first = low;
        int last = high;

        int key = a[first];

        while(first<last){
            while(first<last&&a[last]>key){
                --last;
            }
            a[first] = a[last];

            while(first<last&&a[first]<=key){
                ++first;
            }
            a[last] = a[first];
        }

        a[first] = key;

        quickSort(a,low,first-1);
        quickSort(a,first+1,high);

    }

    public static void bubbleSort(int[] a){
        int k = 0;
        for(int i = 0;i<a.length-1;i++){
            for(int j = 0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    k++;
                }
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println("总次数"+k);

    }

    public static void selectSort(int[] a){
        int min;
        for(int i = 0;i<a.length-1;i++){
            min = i;
            for(int j =i+1;j<a.length;j++){
                if(a[j]<a[min]){
                    min = j;
                }
            }
            if(i!=min){
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;

            }
        }
    }

    public static void insertSort(int[] a){

        int i,j;
        int temp;

        for(i = 1;i<a.length;i++){
            temp = a[i];
            for(j=i;j>0&&a[j-1]>temp;j--){
                a[j] = a[j-1];
            }
            a[j] =temp;

        }
    }

    public static void main(String[] args) {
//        int[] a = {9,7,2,4,8,5,3,1,6,0};
//        quickSort(a,0,9);
//        System.out.println(a.toString());

        int[] b = {5,3,4,2,1};
        insertSort(b);
        System.out.println(Arrays.toString(b));
    }
}
