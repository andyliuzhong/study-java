package com.test.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author liuch
 * @date 2020/7/11 - 11:36
 * ArrayBlockingQueue
 */
public class BlockingQueueDemo {
public static void main(String[] args) {
    ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
    LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();//default Integer.MAX_VALUE
    arrayBlockingQueue.add("ee");
    arrayBlockingQueue.add("ee");
    arrayBlockingQueue.add("ee");
//    arrayBlockingQueue.add("ee");//exception
    arrayBlockingQueue.remove();
    arrayBlockingQueue.remove();
    arrayBlockingQueue.remove();
    arrayBlockingQueue.remove();
    arrayBlockingQueue.remove();//exception
}
}
