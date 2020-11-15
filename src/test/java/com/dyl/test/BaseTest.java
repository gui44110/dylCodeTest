package com.dyl.test;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Classname BaseTest
 * @Description 用于平时测试用
 * @Date 16.5.20 4:55 下午
 * @Created by dongyuliang
 */
public class BaseTest {


    @Test
    public void testBigDecimal(){
        String codeNumResultMis = getCodeNumResultMis("邹雪(zouxue)");
        System.out.println(codeNumResultMis);
    }

    private String getCodeNumResultMis(String string){
        return string.substring(string.lastIndexOf("("), string.lastIndexOf(")"));
    }


    @Test
    public void testBigDecimal2(){
        Double d = new Double(12.2);
        BigDecimal bigDecimal = new BigDecimal(d);
        System.out.println(bigDecimal);
    }



    @Test
    public void testMapMerge(){
        Map<String, Integer> m1 = Maps.newHashMap();
        m1.put("1",1);
        m1.put("2",2);
        m1.put("3",3);

        Map<String, Integer> m2 = Maps.newHashMap();

        m2.put("1",1);
        m2.put("2",2);
        m2.put("3",3);

        Map<String,Integer> m3 = Maps.newHashMap();

        String key = "1";
        m1.compute(key, (k, oldVal) -> oldVal + 1);

        m1.entrySet().stream().forEach(p ->m3.merge(p.getKey(),m2.get(p.getKey()),Integer::sum));

        System.out.println(m1.toString());
    }

    @Test
    public void mapCompute(){
        String k = "key";
        HashMap<String, Integer> map = new HashMap<String, Integer>() {{
            put(k, 1);
        }};
        map.compute(k, (key, oldVal) -> oldVal + 1);
    }

    @Test
    public void testPerson(){
        String str = "23.00%";
        System.out.println(percentToBigDecimal(str));
    }

    private BigDecimal percentToBigDecimal(String percentNum){
        String substring = percentNum.substring(0,percentNum.lastIndexOf("%"));
        return new BigDecimal(substring);
    }


    @Test
    public void listInsert() throws ParseException {
        Date date1 = new Date(0L);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println(fmt.format(date1));

    }

    @Test
    public void testString(){
        String strNameStr = "<a style = 'color:#000;text-decoration:underline;' target='_blank' href=https://yuntu.sankuai.com/dashboard/dashboard-799738d7-2061-4513-b88d-3c3ab2f870d8/view?config={'orgId':'112545*交易系统平台部','env':'prod','startDate':'2020-07-04','endDate':'2020-08-03','dateDimension':'WEEK_1'}><span style = 'color:red'>35</span></a>";
        analysisRollBackNum(strNameStr);
    }

    private String get(String orgNameStr){
        int i = orgNameStr.lastIndexOf("'orgId':'");
        int i1 = orgNameStr.lastIndexOf("*");
        System.out.println(i +"---->" + i1);
        return orgNameStr.substring(i+"'orgId':'".length(),i1);
    }

    private void analysisRollBackNum(String rollbackNumStr) {
        String firstStr = "'color:red'>";
        String lastStr = "</span>";
        int i = rollbackNumStr.lastIndexOf(firstStr) + firstStr.length();
        int i1 = rollbackNumStr.lastIndexOf(lastStr);
        System.out.println(i +"---->" + i1);
        System.out.println(rollbackNumStr.substring(i,i1));
    }


    @Test
    public void test0Time(){
        Date date = new Date();
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("string",date);

        System.out.println(JSONObject.toJSONString(retMap));

    }





}
