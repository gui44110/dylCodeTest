import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Classname TemClass
 * @Date 29.10.20 9:23 下午
 * @Created bongyuliang
 */
public class TemClass {

    /**
     * 二分查找法
     *
     * 边界问题
     *
     */
    public int binarySort(int[] a,int n,int target){
        int l = 0,r = n - 1;//确定好边界[l,r]
        while (l<=r){
            int mid = (r - l)/2+l;//t非常大的时候防止内存溢出
            if(target == a[mid]){
                return mid;
            }else if(target > a[mid]){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }


    @Test
    public void test(){
        Stack<Integer> stack = new Stack<>();

        String abc = "abcdef";
        System.out.println(abc.substring(0,2));
    }

}
