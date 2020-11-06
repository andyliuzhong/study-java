package com.dayeliu.linkedlist;

import java.util.Stack;

/**
 * @author liuch
 * @date 2020/9/18 - 21:47
 */
public class SingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedListDemo demo = new SingleLinkedListDemo();

        HeroNode heroNode1 = new HeroNode(1, "andy", "dayeliu");
        HeroNode heroNode2 = new HeroNode(2, "andy1", "dayeliu1");
        HeroNode heroNode3 = new HeroNode(3, "andy2", "dayeliu2");
        HeroNode heroNode5 = new HeroNode(5, "andy5", "dayeliu5");
        HeroNode heroNode6 = new HeroNode(6, "andy6", "dayeliu6");
        demo.add(heroNode1);
        demo.add(heroNode5);
        demo.add(heroNode2);
        demo.add(heroNode3);
        demo.add(heroNode6);
//        demo.addByOrder(heroNode2);
//        demo.addByOrder(heroNode1);
//        demo.addByOrder(heroNode3);
//        demo.addByOrder(heroNode6);
//        demo.addByOrder(heroNode5);
        demo.showReverse(demo.getHead());
        //update
//        demo.update(new HeroNode(6, "andy8", "dayeliu8"));

//        System.out.println(demo.getLength(demo.getHead()));


//        System.out.println(demo.getLastIndex(demo.getHead(), 3));
//        demo.delete(1);
//        demo.delete(2);
//        demo.delete(5);
//        demo.delete(3);
//        demo.delete(6);

        demo.list();
        demo.printReverse(demo.getHead());

    }
}



////定义一个类 管理HeroNode

class SingleLinkedListDemo {
    //定义一个头结点 不存放数据
    private HeroNode head = new HeroNode(0, "", "");

    //反向打印链表
    public HeroNode showReverse(HeroNode head){
        //为空或只有一个节点
        if (head.next == null ||head.next.next == null) return head;

        //创建一个链表
        HeroNode reverseNode = new HeroNode(0, "", "");
        HeroNode current = head.next;
        //
        HeroNode next = null;
        while (current != null) {
            next = current.next;
            current.next = reverseNode.next;
            reverseNode.next = current;
            current = next;
        }
        head.next = reverseNode.next;
        return head;
    }

    //反向打印链表

    public void printReverse(HeroNode head){
        Stack<String> stack = new Stack<>();
        stack.add("jack");
        stack.add("sms");
        stack.add("andy");
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
    //查找链表中倒数第K个节点
    public HeroNode getLastIndex(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int length = getLength(head);
        if (index < 0 || index > length) {
            System.out.println("index error");
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < length -index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //pub
    public int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //添加节点
    //1.不考虑排序
    public void add(HeroNode heroNode) {
        //设置临时变量  head不能修改
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            //指针后移
            temp = temp.next;
        }

        //退出循环后 temp执行链表的最后
        temp.next = heroNode;
    }


    //add by order
    public void addByOrder(HeroNode heroNode) {
        HeroNode tmp = head;
        boolean flag = false;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            if (tmp.next.no > heroNode.no) {
                break;
            } else if (tmp.next.no == heroNode.no) {
                flag = true;//编号已存在
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            System.out.println("编号已存在");
        } else {
            //交换位置
            heroNode.next = tmp.next;
            tmp.next = heroNode;
        }


    }

    //显示链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                return;
            }
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    //update

    public void update(HeroNode heroNode) {
        HeroNode tmp = head;
        boolean flag = false;
        while (true) {
            if (tmp.next == null) {
                System.out.println("list is empty");
                break;
            }
            if (tmp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            tmp.next.name = heroNode.name;
            tmp.next.nickName = heroNode.nickName;
        }
    }

    //delete
    public void delete(int no) {
        HeroNode tmp = head;
        boolean flag = false;
        while (true) {
            if (tmp.next == null) {
                System.out.println("list is empty");
                break;
            }
            if (tmp.next.no == no) {
                //找到被删除节点
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            //tmp.next = tmp.next.next
            tmp.next = tmp.next.next;
        } else {
            System.out.println("do not find");
        }
    }

    public HeroNode getHead() {
        return head;
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
