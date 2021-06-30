package com.yamdeng.reboot.java.collection;

import com.yamdeng.reboot.java.util.YamdengCollectionUtil;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

// Queue
public class QueueFunction {

    public static void main(String[] args) {
        System.out.println("========== Queue ==========");
        System.out.println();

        // queue api
        queueFunction();
        System.out.println();

        // PriorityQueue
        priorityQueueFunction();
        System.out.println();

        System.out.println("========== QueueFunction End ==========");
    }

    private static void priorityQueueFunction() {
        System.out.println("PriorityQueue");
        Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2.compareTo(i1));
        YamdengCollectionUtil.initIntegerList(queue);
        YamdengCollectionUtil.iteratorToString(queue, "queue");
        System.out.println("queue.poll() : " + queue.poll());
        System.out.println("queue.poll() : " + queue.poll());
        System.out.println("queue.poll() : " + queue.poll());
        System.out.println("queue.poll() : " + queue.poll());
        System.out.println("queue.poll() : " + queue.poll());
        YamdengCollectionUtil.iteratorToString(queue, "queue");
    }

    // element, peek, offer, poll, remove
    private static void queueFunction() {
        System.out.println("queue api");
        Queue<String> queue = new LinkedList<>();
        YamdengCollectionUtil.initStringList(queue);
        YamdengCollectionUtil.iteratorToString(queue, "queue");

        // element
        String elementValue = queue.element();
        System.out.println("elementValue : " + elementValue);

        // peek
        String peekValue = queue.peek();
        System.out.println("peekValue : " + peekValue);

        // offer
        queue.offer("111");
        queue.offer("222");
        YamdengCollectionUtil.iteratorToString(queue, "queue");

        // poll
        String pollValue = queue.poll();
        System.out.println("pollValue : " + pollValue);
        YamdengCollectionUtil.iteratorToString(queue, "queue");

        // remove
        queue.remove();
        queue.remove();
        queue.remove();
        YamdengCollectionUtil.iteratorToString(queue, "queue remove after");
    }
}
