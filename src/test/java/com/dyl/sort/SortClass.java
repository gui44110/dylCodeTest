package com.dyl.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

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


    public static void quickSort2(int[] a,int low,int high){
        if(low>=high){
            return;
        }
        int left = low;
        int right = high;
        int temp = a[left];
        while(left<right){
            while (left<right&&temp<a[right]){
                --right;
            }
            a[left] = a[right];
            while (left<right&&a[left]>=temp){
                ++left;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        quickSort2(a,low,left - 1);
        quickSort2(a,left +1,high);

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

    /**
     * 插入排序
     * @param a
     */
    public static void insertSort(int[] a){
        for(int i = 1;i<a.length;i++){
            int num = a[i];
            int j ;
            for(j = i ;j>0&&num<a[j-1];j--){
                a[j]=a[j-1];
            }
            a[j] = num;
        }
    }

    /**
     * 希尔排序
     * @param a
     */
    public static void shellSort(int[] a){
        int num = a.length/2;
        int i,j;
        int temp;
        while(num>=1){
            for(i = num;i<a.length;i++){
               for(j = i ;j>0&&a[j-num]>a[j];j-=num){
                   swap(a[j],a[j-1]);
               }

            }
            num = num/2;
        }
    }


    public static void bubbleSort2(int[] a){
        for(int i = 0;i<a.length-1;i++){
            for(int j = 1;j<a.length - i;j++){
                if(a[j-1]< a[j]){
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
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
