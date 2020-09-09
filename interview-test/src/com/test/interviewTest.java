package com.test;

/**
 * @author liuch
 * @date 2020/9/6 - 17:35
 */
public class interviewTest {
    public static void main(String[] args) {
        System.out.println(lastWordLength("123 tesgt test"));
    }
    //计算字符串最后一个单词的长度，单词以空格隔开。
    private static int lastWordLength(String str){
        if (str == null && str.isEmpty() ) return 0;

        String[] split = str.split(" ");
        return split[split.length - 1].length();
    }
}
