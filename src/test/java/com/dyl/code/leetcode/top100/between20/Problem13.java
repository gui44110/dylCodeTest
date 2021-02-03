package com.dyl.code.leetcode.top100.between20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname Problem13
 * @Description
 * 题目 17
 * 定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2.2.21 12:19 下午
 * @Created by dongyuliang
 */
public class Problem13 {















    /**
     * 思路
     * 回溯法，遍历出所有的可能
     * for循环 + 递归
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        Map<Character, String> charMap = getCharMap();
        findStr(digits,0,"",charMap,result);
        return result;
    }

    public void findStr(String digits,int index,String lastStr,Map<Character,String> charMap,List<String> result){
        if(index == digits.length()){
            result.add(lastStr);
            return;
        }
        char c = digits.charAt(index);
        String s = charMap.get(c);
        for(int i = 0 ; i< s.length();i++){
            findStr(digits, index + 1,lastStr + s.charAt(i),charMap,result);
        }
    }

    public Map<Character,String> getCharMap(){
        Map<Character,String> map = new HashMap();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        return map;
    }

    public static void main(String[] args) {
        Problem13 problem13 = new Problem13();
        problem13.letterCombinations("23");
    }

}
