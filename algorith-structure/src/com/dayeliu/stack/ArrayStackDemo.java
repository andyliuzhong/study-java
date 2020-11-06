package com.dayeliu.stack;


import java.util.Scanner;

/**
 * @author liuch
 * @date 2020/9/29 - 22:39
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack2 stack = new ArrayStack2(5);
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (loop) {
            System.out.println("push: 入栈");
            System.out.println("pop: 出栈栈");
            System.out.println("list: 显示");
            System.out.println("exit: 退出");
            input = scanner.next();

            switch (input){
                case "push":
                    stack.push(scanner.nextInt());
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                case "list":
                    stack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
    }
}

class ArrayStack{
    private int maxTop; //栈大小
    private int[] stack;
    private int top = -1; //栈顶指针,默认-1

    public ArrayStack(int maxTop) {
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
}
