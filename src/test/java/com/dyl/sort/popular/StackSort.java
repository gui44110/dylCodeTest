package com.dyl.sort.popular;


import org.junit.Test;

import java.util.Stack;

/**
 * 通过栈解决的算法题
 */
public class StackSort {


    /**
     * leetcode 20
     *
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i< chars.length ; i++){
            if(matchLeft(chars[i])){
                stack.push(chars[i]);
            }else if( matchRight(chars[i])){
                if(!stack.isEmpty()){
                    char pop = stack.pop();
                    if(!match(pop,chars[i])){
                        return false;
                    };
                }else {
                    return false;
                }

            }else{
                return false;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean matchLeft(char c){
        if(c == '{' ||c =='('|| c == '[' ){
            return true;
        }
        return false;
    }

    public boolean matchRight(char c){
        if(c == ']' ||c ==')'|| c == '}' ){
            return true;
        }
        return false;
    }

    public boolean match(char c1,char c2){
        if(c1 == '(' && c2 == ')'){
            return true;
        }
        if(c1 == '[' && c2 == ']'){
            return true;
        }
        if(c1 == '{' && c2 == '}'){
            return true;
        }
        return false;
    }

    @Test
    public void testIsValid(){
        System.out.println(isValid("]"));
    }


    /**
     *150. 逆波兰表达式求值
     * 根据逆波兰表示法，求表达式的值。
     *
     * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     *
     * 说明：
     *
     * 整数除法只保留整数部分。
     * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer num;
        for(String s :tokens){
            if(s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(s.equals("-")){
                num = stack.pop();
                stack.push(stack.pop() - num);
            }else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(s.equals("/")){
                num = stack.pop();
                stack.push(stack.pop()/num);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }



    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String s : split){
            if(s.length()<=0){
                continue;
            }
            if(s.equals(".")){
                continue;
            }else if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else {
                stack.push(s);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ;i<stack.size();i++){
            builder.append("/").append(stack.get(i));
        }
        return builder.toString();
    }

    @Test
    public void simplifyPath(){
        simplifyPath("/home//foo");
    }


}
