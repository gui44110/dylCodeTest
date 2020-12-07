import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.channels.Channel;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

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
    public void test() throws IOException, InterruptedException, ExecutionException {
//        Stack<Integer> stack = new Stack<>();
//
//        String abc = "abcadeaf";
//        System.out.println(StringUtils.lastOrdinalIndexOf(abc,"a",1));
//
//        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//
//        Selector selector = Selector.open();

//        System.out.println(new Date().toString());
//
        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
        int start = 2;
        int end = 4;
        List<Integer> collect = list.stream().skip(7).collect(Collectors.toList());
        System.out.println(collect.toString());
//
//        HashMap<String, Integer> map = new HashMap<>(1);
//
//        map.put("1",2);
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        Future<Integer> submit = executorService.submit(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return 1;
//        });
//        Integer integer = submit.get();



    }

}
