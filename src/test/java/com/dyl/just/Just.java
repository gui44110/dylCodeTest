package com.dyl.just;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

public class Just {



    public static void sort(String a,String b,int i){
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int lastIndex = 0;
    }


    public static void sort2(char[] a,char [] b,int n){
        if(n<b.length){
            return;
        }
        int i = 0;
        int lastIndex = 0;
        while (i<n){
            int j = 0;
            if(a[i] != b[j]){
                a[lastIndex] = a[i++];
                continue;
            }else{

            }

        }
    }

    public static void main(String[] args) {
        System.out.println(sort("aabcbaabcb"));

        Stack<Integer> stack = new Stack<>();

    }


    public static int sort(String str){
        int count = 0 ;
        char[] strChar = str.toCharArray();
        for(int i = 0;i<strChar.length - 1;i++){
            for(int j = 1;j<=strChar.length -1-i;j++){
                if(isRe(strChar,i,i+j)){
                    count ++;
                }
            }
        }
        count = count + strChar.length;
        return count;
    }

    public static boolean isRe(char[] str ,int low,int high){
        int n = (low + high)/2;
        int i = low;
        while (i<=n){
           if(str[i++]!=str[high--]){
               return false;
           }
        }
        return true;

    }

    public static void sort1(Tree tree){
        LinkedList<Tree> queue = new LinkedList<Tree>();
        queue.add(tree);
        while (!queue.isEmpty()){
            Tree root = queue.pop();
            System.out.println(root.val);
            if(root.children!=null){
                Tree[] children = root.children;
                for(int i = 0 ;i<children.length;i++){
                    queue.add(children[i]);
                }
            }
        }
    }


    static class Tree{
        int val;
        Tree[] children;
    }
}
