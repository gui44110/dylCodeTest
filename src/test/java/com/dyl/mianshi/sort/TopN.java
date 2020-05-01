package com.dyl.mianshi.sort;


/**
 * 取一批数组中最大几个的通用的算法
 */
public class TopN {

    public int getParent(int n){
        return (n-1)/2;
    }

    public int getLeft(int n){
        return 2 * n + 1;
    }

    public int getRight(int n){
        return 2*n +2;
    }

    /**
     * 构建一个小顶堆，把最小的的放上面，和之后的数据做对比
     * @param a
     * @param n
     */
    public void buildSmallHeap(int[] a ,int n){
        for(int i = 0;i<n;i++){
            int t = i;
            while (t !=0 && a[getParent(t)] > a[t]){
                int temp = a[t];
                a[t] = a[getParent(t)];
                a[getParent(t)] = temp;
                t = getParent(t);
            }
        }
    }


    public void adjust(int[] a,int n,int i){
        if(a[0] >= a[i]){
            return;
        }
        int temp = a[i];
        a[i] = a[0];
        a[0] = temp;
        int t = 0;
        while ((getLeft(t)<n&&a[getLeft(t)]<a[t]) || getRight(t)<n&&a[getRight(t)]<a[t]){
            if(getLeft(t)<n&&a[getLeft(t)]<a[t]){
                temp = a[getLeft(t)];
                a[getLeft(t)] = a[t];
                a[t] = temp;
                t = getLeft(t);
            }else{
                temp = a[getRight(t)];
                a[getRight(t)] = a[t];
                a[t] = temp;
                t = getRight(t);
            }
        }
    }

}
