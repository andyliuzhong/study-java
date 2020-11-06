package com.dayeliu.stack;

/**
 * @author liuch
 * @date 2020/10/3 - 16:01
 * stack 实现计算器
 */
public class CalculatorDemo {
    public static void main(String[] args) {
//        System.out.println((int)'1');
//        String operation = "2+3*6-8"; //20+3*6-8 多位操作情况
        String operation = "2+30*6-8"; //20+3*6-8 多位操作情况
        //创建两个stack 一个村数字 一个村操作符
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;//扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";//用于处理多位
        //扫描字符
        while (true) {
            //依次得到每个字符
            ch = operation.substring(index,index + 1).charAt(0);
            //判断ch是符号还是数字
            if (operStack.isOper(ch)) {
                //判断stack是否为空
                if (!operStack.isEmpry()) {
                    //处理
                    //判断优先级
                    if (operStack.getpriority(ch) <= operStack.getpriority(operStack.peek())) {
                        //如果当前的操作符小于栈顶的操作符 则先pop两个数进行运算
                         num1 = numStack.pop();
                         num2 = numStack.pop();
                         oper = operStack.pop();
                        res = operStack.cal(num1, num2, oper);
                        //把运算结果入数栈
                        numStack.push(res);
                        //操作数栈
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }else {
                    operStack.push(ch);
                }
            }else {
                //数字的情况 直接入栈
               // numStack.push(ch - 48); //char -》 int 转换
                //多位处理
                if (index == operation.length() - 1) {
                    //最后一位
                    numStack.push(ch - 48); //char -》 int 转换
                }else {
                    keepNum += ch;
                    //如果下一位是字符则push
                    if (operStack.isOper(operation.substring(index +1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            //判断是否扫描到最后
            if(index >= operation.length()) {
                break;
            }
        }

        //入栈后进行计算操作 顺序出栈计算

        while (true) {
            //当符号栈为空时则就算了最后结果
            if (operStack.isEmpry()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println("最后结果:" + numStack.pop());

    }
}
class ArrayStack2 {
    private int maxTop; //栈大小
    private int[] stack;
    private int top = -1; //栈顶指针,默认-1

    public ArrayStack2(int maxTop) {
        this.maxTop = maxTop;
        stack = new int[this.maxTop];
    }

    //判断stack是否满

    public boolean isFull(){
        return top == maxTop - 1;
    }

    //判断stack是否为空
    public boolean isEmpry(){
        return top == -1;
    }

    //push

    public void push(int value){
        if (isFull()) {
            throw new  RuntimeException("stack is full");
        }
        top++;
        stack[top] = value;
    }

    //pop
    public int pop(){
        if (isEmpry()){
            throw new RuntimeException("stack is empty");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示
    public void list(){
        if (isEmpry()){
            System.out.println("stack is empty");
        }

        //从top开始遍历
        for (int i = top; i >= 0; i--) {
            System.out.printf("第%d个源数：%d",i,stack[i]);

        }
    }

    //查看stack top元素

    public int peek(){
        return stack[top];
    }

    //判断优先级
    //char 和int 都可以
    public int getpriority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' ||  oper == '-') {
            return 0;
        }else {
            return -1; //目前支持 +-*/
        }
    }
    //判断是否为计算符
    public boolean isOper(char oper){
        return oper == '*' || oper == '/' || oper == '+' || oper == '-';

    }
    //计算
    public int cal(int num1,int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '*' :
                res = num1 * num2;
                break;
            case '/' :
                res = num2 / num1;
                break;
            case '+' :
                res = num1 + num2;
                break;
            case '-' :
                res = num2 - num1; //num先入栈
                break;
             default:
                 break;
        }
        return res;
    }
}

