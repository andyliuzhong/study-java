package com.dayeliu.linkedlist;

/**
 * @author liuch
 * @date 2020/9/26 - 16:00
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1, "andy", "dayeliu");
        HeroNode2 heroNode2 = new HeroNode2(2, "andy1", "dayeliu1");
        HeroNode2 heroNode3 = new HeroNode2(3, "andy2", "dayeliu2");
        HeroNode2 heroNode5 = new HeroNode2(5, "andy5", "dayeliu5");
        HeroNode2 heroNode6 = new HeroNode2(6, "andy6", "dayeliu6");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode5);
        doubleLinkedList.add(heroNode6);

        //update
        doubleLinkedList.update(new HeroNode2(5, "andyda", "dayeliu"));
        doubleLinkedList.delete(1);
        doubleLinkedList.list();
    }
}
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre; //上一个节点

    public HeroNode2(int no, String name, String nickName) {
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
class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");
    public HeroNode2 getHead() {
        return head;
    }

    public void add(HeroNode2 heroNode) {
        //设置临时变量  head不能修改
        HeroNode2 temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            //指针后移
            temp = temp.next;
        }

        //退出循环后 temp执行链表的最后
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head;

        while (true) {
            if (temp.next == null) {
                return;
            }
            System.out.println(temp.next);
            temp = temp.next;
        }
    }
    public void delete(int no) {
        HeroNode2 tmp = head.next;
        boolean flag = false;
        while (true) {
            if (tmp == null) {
                System.out.println("list is empty");
                break;
            }
            if (tmp.no == no) {
                //找到被删除节点
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            tmp.pre.next = tmp.next;
            //当 temp为链表最后节点是 tmp.next == null
            if (tmp.next != null) tmp.next.pre = tmp.pre;
        } else {
            System.out.println("do not find");
        }
    }

    public void update(HeroNode2 heroNode) {
        HeroNode2 tmp2 = head;
        boolean flag = false;
        while (true) {
            if (tmp2.next == null) {
                System.out.println("list is empty");
                break;
            }
            if (tmp2.next.no == heroNode.no) {
                flag = true;
                break;
            }
            tmp2 = tmp2.next;
        }
        if (flag) {
            tmp2.next.name = heroNode.name;
            tmp2.next.nickName = heroNode.nickName;
        }
    }
}
