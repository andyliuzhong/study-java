package com.dayeliu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liuch
 * @date 2020/10/4 - 16:58
 * 中缀表达式转后缀表达式
 */
public class PolanDemo {
    public static void main(String[] args) {
        //
//        String inExpression = "1+((2+3)*5)-6"; //对应后缀表达式: 123+5*+6-
        String inExpression = "1*((2+3*5)*5)/17"; //对应后缀表达式: 1235*+5*+6-
        //转成中缀表达式
        List<String> inExpre =  toInExpre(inExpression);
        System.out.println(inExpre);

        //中缀表达式转后缀表达式 对应后缀表达式: 123+5*+6-
        List<String> suffixList = parseToSuffixExpre(inExpre);
        System.out.println(suffixList);

        //根据后缀表达式 实现计算器

       int res =  calculate(suffixList);
        System.out.println("计算结果:" + res);



    }

    private static int calculate(List<String> suffixList) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int num1 = 0;
        int num2 = 0;
        for (String ss:suffixList) {
            if (ss.matches("\\d+")) {
                //数字直接入栈
                stack.push(Integer.parseInt(ss));
            }else {
                num1 = stack.pop();
                num2 = stack.pop();
                switch (ss) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                      res = num2 / num1;
                        break;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }

    private static List<String> parseToSuffixExpre(List<String> inExpre) {
        //符号栈
        Stack<String> s1 = new Stack<>();
        //存储最后结果
        List<String> s2  = new ArrayList<>();

        for (String item : inExpre) {
            if (item.matches("\\d+")){
                //数字直接进s2
                s2.add(item);
            }else if ("(".equals(item)) {
                //直接入栈
                s1.push(item);

            }else if (")".equals(item)){
                //如果是")" s1 pop直到 "("
                while (!s1.peek().equals("(")) {
                    //符号加入到s2
                    s2.add(s1.pop());
                }
                s1.pop();//把"(" 移出去
            }else {
                //考虑优先级
                //当item的优先级小于或等于s1栈顶的优先级时  取出s1栈顶的运算符  加入到s2
                while (s1.size() != 0 && !s1.peek().equals("(")  && getpriority(item) <= getpriority(s1.peek())) {
                    System.out.println("===========");
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //将s1中剩余的操作符加入到s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    //判断优先级
    public static int getpriority(String oper1){
        if (oper1.equals("*") || oper1.equals("/")){
            return 1;
        }else if (oper1.equals("+") ||  oper1.equals("-")) {
            return 0;
        }else {
            System.out.println("不支持的运算符");
            return -1; //目前支持 + - * /
        }
    }
    private static List<String> toInExpre(String inExpression) {
        int i = 0;
        String str = "";
        char ch;
        List<String> list = new ArrayList<>();
        do {
            ch = inExpression.charAt(i);
            //当遍历的字符为操作符时 非数字
            if (  ch < 48 || ch > 57) {
                list.add(ch + "");
                i++;
            }else {
                //数字  考虑多位数问题
                str = "";
                while (i < inExpression.length() && ((ch = inExpression.charAt(i)) >= 48 && ch <= 57)) {
                    str += ch;
                    i++;
                }
                list.add(str);
            }
        }while (i < inExpression.length());

        return list;
    }
}
