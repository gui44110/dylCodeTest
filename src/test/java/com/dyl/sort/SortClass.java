package com.dyl.sort;

import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class SortClass {

    /**
     * 插入排序
     * @param a
     */
    public static void insertSort(int[] a){
        for(int i = 1;i<a.length;i++){
            int temp = a[i];
            int j ;
            for(j = i;j>0&&a[j-1]>temp;j--){
                a[j] = a[j-1];
            }
            a[j] = temp;
        }
    }

    public static void insertSort1(int[] a){
        for(int i = 1;i<a.length;i++){
            int j ;
            int temp = a[i];
            for(j = i;j>0&&a[j-1]>temp;j--){
                a[j] = a[j-1];
            }
            a[j] = temp;
        }
    }

    @Test
    public void testInsertSort(){
        int[] ints = randomArray();
        printArray(ints);
        insertSort1(ints);
        printArray(ints);
    }

    /**
     * 希尔排序
     * @param a
     */
    public static void shellSort(int[] a){
        int num = a.length/2;
        int i,j,temp;
        while (num>=1){
            for( i = num;i<a.length;i++){
                temp = a[i];
                for(j = i;j>=num&&a[j-num]>temp;j-=num){
                    a[j] = a[j-num];
                }
                a[j] = temp;
            }
            num = num/2;
        }
    }

    public static void shell(int[] a){
        int num = a.length/2;
        int i,j;
        int temp;
        while (num>=1){
            for(i = num;i<a.length;i++){
                temp = a[i];
                for(j = i;j >= num && a[j-num]>temp;j-=num){
                    a[j] = a[j-num];
                }
                a[j] = temp;
            }
            num = num/2;
        }
    }

    @Test
    public void testShellSort(){
        int[] ints = randomArray();
        printArray(ints);
        shell(ints);
        printArray(ints);
    }


    /**
     * 选择排序
     * @param a
     */
    public static void selectSort(int[] a){
        int min;
        int temp;
        for(int i = 0;i<a.length - 1;i++){
            min = i;
            for(int j = i+1 ;j<a.length ;j++){
                if(a[min]>a[j]){
                    min = j;
                }
            }
            if(min != i){
                temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void selectSort2(int[] a){
        int min;
        int temp;
        for(int i = 0 ;i<a.length-1;i++){
            min = i;
            for(int j = i+1;j<a.length;j++){
                if(a[min]>a[j]){
                    min = j;
                }
            }
            if(min !=i){
                temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }

        }
    }


    @Test
    public void testSelectSort(){
        System.out.println("选择排序");
        int[] ints = randomArray();
        printArray(ints);
        selectSort2(ints);
        printArray(ints);
    }


    /**
     * 堆排序
     * @param a
     */
    public static void heapSort(int[] a){
        int temp ;
        for(int i = a.length - 1;i>0;i--){
            maxHeap(a,i);
            temp = a[i];
            a[i] = a[0];
            a[0] = temp;
        }
    }

    public static void maxHeap(int[] a,int n){
        int child;
        int temp;
        for(int i = (n-1)/2;i>=0;i--){
            child = 2 * i +1;
            if(child != n && a[child] < a[child +1]){
                child = child + 1;
            }
            if(a[i] < a[child]){
                temp = a[child];
                a[child] = a[i];
                a[i] = temp;
            }
        }
    }


    public static void heapSort2(int[] a){
        for(int i = a.length - 1;i>0;i--){
            maxHeap2(a,i);
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
        }
    }
    public static void maxHeap2(int[] a ,int n){
        int child;
        int temp;
        for(int i = (n-1)/2;i>=0;i--){
            child = 2 * i + 1;
            if( child !=n && a[child] < a[child + 1]){
                child = child + 1;
            }
            if(a[i] < a[child]){
                temp = a[i];
                a[i] = a[child];
                a[child] = temp;
            }
        }
    }

    @Test
    public void testHeapSort(){
        System.out.println("堆排序");
        int[] ints = randomArray();
        printArray(ints);
        heapSort2(ints);
        printArray(ints);
    }


    public static void bubbleSort(int[] a){
        int temp;
        for(int i = 0;i<a.length - 1;i++){
            for(int j = 0 ;j<a.length - 1 - i;j++){
                if(a[j] > a[j+1]){
                    temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }


    public static void bubbleSort2(int[] a){
        int temp;
        for(int i = 0 ;i<a.length -1;i++){
            for(int j = 0;j<a.length - 1 - i ;j++){
                if(a[j]>a[j+1]){
                    temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    @Test
    public void testBubbleSort(){
        System.out.println("冒泡排序");
        int[] ints = randomArray();
        printArray(ints);
        bubbleSort2(ints);
        printArray(ints);
    }

   public static void quickSort(int[] a,int low ,int high){
        if(low >=high){
            return;
        }
        int first = low;
        int last = high;
        int temp = a[first];
        while (first <last){
            while (first<last&&a[last]> temp){
                last --;
            }
            a[first ] = a[last];
            while (first<last && a[first] <=temp){
                first ++;
            }
            a[last] = a[first];
        }
        a[first] = temp;
        quickSort(a,low,first-1);
        quickSort(a,first+1,high);
   }


   public static void quickSort2(int[] a ,int low,int high){
        if(low>=high){
            return;
        }
        int left = low;
        int right = high;
        int temp = a[left];
        while (left<right){
            while (left<right&&a[right]>temp){
                right -- ;
            }
            a[left] = a[right];
            while (left<right&&a[left]<=temp){
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
       quickSort2(a,low,left-1);
       quickSort2(a,left + 1,high);
   }


    @Test
    public void testQuickSort(){
        System.out.println("快速排序");
        int[] ints = randomArray();
        printArray(ints);
        quickSort2(ints,0,9);
        printArray(ints);
    }



    public static void mergeSort(int[] a){
        int[] result = new int[a.length];
        mergeSort(a,0,a.length-1,result);
    }

    public static void mergeSort(int[] a,int low,int high,int[] result){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(a,low,mid,result);
            mergeSort(a,mid+1,high,result);
            merge(a,low,high,mid,result);
        }
    }

    public static void merge(int[] a,int low,int high,int mid,int[] result){
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j<=high){
            if (a[i] <a[j]){
                result[k++] = a[i++];
            }else{
                result[k++] = a[j++];
            }
        }
        while (i<=mid){
            result[k++] = a[i++];
        }
        while (j<=high){
            result[k++] = a[j++];
        }
        for(int z = low;z <= high;z++){
            a[z] = result[z];
        }
    }

    @Test
    public void testMergeSort(){
        System.out.println("归并排序");
        int[] ints = randomArray();
        printArray(ints);
        mergeSort(ints);
        printArray(ints);
    }

    public static void  radixSort(int[] a){
        int max = a[0];
        for(int i = 1;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
            }
        }
        int index = 0;
        while (max >0){
            index ++ ;
            max = max/10;
        }
        int[][] buckets = new int[10][index];
        int[] bucketLen = new int[10];
        int base = 1;
        for(int i = 0 ;i<index;i++){
            for(int j = 0 ;j<a.length;j++){
                int n = (a[j] /base )% 10 ;
                buckets[n][bucketLen[n]] = a[j];
                bucketLen[n]++;
            }
            int k = 0;
            for(int j = 0;j< buckets.length;j++){
                for(int z = 0;z<bucketLen[j];z++){
                    a[k++] = buckets[j][z];
                }
                bucketLen[j] = 0;
            }
            base = base*10;
        }

    }

    @Test
    public void testRadixSort(){
        System.out.println("基数排序");
//        int[] ints = randomArray();
        int[] ints = {2,77,84,68,51,70,38,24,1,86};
        printArray(ints);
        radixSort(ints);
        printArray(ints);
    }

    /**
     * 随机生成10个大于1 小于100的数组
     * @return
     */
    public static int[] randomArray(){
        int[] result = new int[10];
        for(int i = 0 ;i<result.length;i++){
            result[i] = (int) (Math.random()*100 + 1);
        }
        return result;
    }

    public static void printArray(int[] array){
        System.out.println(JSONArray.toJSON(array));
    }
    public static void main(String[] args) {
//        int[] a = {9,7,2,4,8,5,3,1,6,0};
//        quickSort(a,0,9);
//        System.out.println(a.toString());

        int[] b = {5,3,4,2,1};
        insertSort(b);
        System.out.println(Arrays.toString(b));
    }


    /**
     * 杨辉三角，求某行，某列的值
     * @param n
     * @param m
     * @return
     */
    public int sort(int n,int m){
        if(m < 0){
            return 0;
        }
        if(m==n || m == 0 ){
            return 1;
        }
        return sort(n - 1, m - 1) + sort(n -1,m);
    }


    @Test
    public void test(){
        System.out.println(sort(4,3));
    }
}
