package com.dayeliu.linkedlist;

/**
 * @author liuch
 * @date 2020/9/27 - 10:43
 * 约瑟夫问题
 *
 */
public class CircleLinkedListDemo {
    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.init(5);

        circleLinkedList.countBoy(1, 3, 5);
        circleLinkedList.showList();
    }
}

class CircleLinkedList{
    private Boy first; //指向第一个节点

    /**
     *
     * @param nums 总共节点数
     */
    public void init(int nums){
        if (nums < 1) return;
        Boy cur = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //如果第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first); //构成环状
                cur = first; //cur指向第一个小孩
            }else {
               cur.setNext(boy);
               boy.setNext(first);
               cur = boy;
            }
        }
    }

    public void showList(){
        if (first == null) return;
        Boy cur = first;
        while (true) {
            System.out.println("小孩编号:" + cur.getNo());
            if (cur.getNext() == first) break;
            cur = cur.getNext();
        }
    }


    /**
     * 约瑟夫问题 丢手帕问题 计算小孩出圈顺序
     * @param begin 从第几个开始
     * @param skip 每次数几个
     * @param nums 环形队列节点数
     */
    public void countBoy(int begin,int skip,int nums){
        if (first == null || begin > nums || skip < 1 || begin < 1) return;

        Boy helper = first;
        while (true) {
            //让helper指向环形队列的最后
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }


        //找到从第几个节点开始
        for (int i = 1; i <= begin - 1 ; i++) {
            first = first.getNext();
            helper = helper.getNext();

        }

        //确定每次报数
        while (true) {
            if (helper == first) {
                //当helper == first的时候，说明只有一个队列
                break;
            }

            //开始移到
            for (int i = 0; i < skip - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();

            }
            System.out.printf("出圈小孩%d\n",first.getNo());
            //出圈后 first 后移
            first = first.getNext();
            //helper 节点后移
            helper.setNext(first);
        }
        System.out.printf("最后出圈小孩%d\n",first.getNo());
    }
}
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }
}
