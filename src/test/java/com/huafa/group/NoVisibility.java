package com.huafa.group;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lhw
 * @date: 2021/6/25 下午4:26
 **/
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class Reader extends Thread {
        public void run() {
            System.out.println(number);
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new Reader().start();
        number = 42;
        ready = true;

        List<Integer> list = new ArrayList<>();
        list.add(1);
        List bb = list;
        bb.add(2);
        bb.add("asas");
        System.out.println(list);
        System.out.println(bb);
    }
}