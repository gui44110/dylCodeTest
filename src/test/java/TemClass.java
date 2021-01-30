import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import sun.nio.ch.DirectBuffer;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.channels.Channel;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TimeZone;
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

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");



    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

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
//        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
//        int start = 2;
//        int end = 4;
//        List<Integer> collect = list.stream().skip(7).collect(Collectors.toList());
//        System.out.println(collect.toString());
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

//        int[] index = new int[10];
//
//        for(int i = 0 ;i<100;i++){
//            executorService.execute( () -> {
//                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
//                String format = simpleDateFormat.format(new Date());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(format);
//            });
//        }
//        executorService.shutdown();
//
//        String st = "ssh://git@git.sankuai.com/bm/banma_service_dispatch_matching_server.git";
//
//        System.out.println(st.substring(st.indexOf(".com/") + ".com/".length(),st.indexOf(".git" )));

//        EventLoopGroup eventExecutors = new NioEventLoopGroup(1);
//
//        int i = 20_000;
//        System.out.println(i);

        System.out.println(STANDALONE_MASK);
        TemClass t = new TemClass();
        System.out.println(t.toStandaloneStyle(-2147483648));
        System.out.println(t.a());

        Stack<Integer> stack = new Stack<>();

        Queue<Integer> queue = new ArrayDeque<>();

        HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();

    }

    static final int STANDALONE_MASK = 0x8000;


    private int toStandaloneStyle(int style) {
        return style | STANDALONE_MASK;
    }

    private  int a(){
        return -2147483648;
    }




}
