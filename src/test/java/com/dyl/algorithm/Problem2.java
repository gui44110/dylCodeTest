package com.dyl.algorithm;

public class Problem2 {

    public static void main(String[] args) {
        test1(20, 7);
    }


    /**
     * 题目：
     * 设有ｎ个人依围成一圈，从第１个人开始报数，数到第ｍ个人出列，
     * 然后从出列的下一个人开始报数，数到第ｍ个人又出列，
     * 如此反复到所有的人全部出列为止。
     * 设ｎ个人的编号分别为1，2，…，n，打印出出列的顺序
     */
    private static void test1(int n, int m) {

        /*原始队列*/
        int[] init = new int[n];

        for (int i = 0; i < n; i++) {
            init[i] = i + 1;
        }

        /*结果*/
        int[] result = new int[n];


        int offsetIndex = 0;
        for (int i = 0; i < n; i++) {

            /*剩余队列中，需要出列的下标*/
            int index = m % (n - i);
            /*如果余数是0，则是当前队列最后一人出列*/
            index = index == 0 ? n - i : index;

            int k = 0;
            j:
            for (int j = offsetIndex; j < n; j++) {
                if (init[j] != 0) {
                    k++;

                    if (index == k) {
                        result[i] = init[j];
                        init[j] = 0;
                        if (i == n - 1) {
                            break;
                        }
                    } else if (index + 1 == k) {
                        offsetIndex = j;
                        break j;
                    }
                }
                if (j == n - 1) {
                    j = -1;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (init[j] != 0) {
                result[n - 1] = init[j];
                break;
            }
        }

        System.out.println(toString(result));

    }

    private static String toString(int[] array) {
        String str = "{";

        for (int i = 0; i < array.length; i++) {
            str += array[i];
            if (i != array.length - 1) {
                str += ",";
            } else {
                str += "}";
            }
        }
        return str;
    }
}
