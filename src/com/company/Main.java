package com.company;

import java.util.concurrent.CountDownLatch;

public class Main {

    private static final int touristsNumber = 15;
    static CountDownLatch LATCH;

    public static void main(String[] args) throws InterruptedException {

        LATCH = new CountDownLatch(touristsNumber + 1);
        for (int i = 1; i <= touristsNumber; i++) {

            Tourist tourist = new Tourist(i, LATCH);

            tourist.start();
        }
        while (LATCH.getCount() > 1) {
            Thread.sleep(1000);
        }

        System.out.println("Все участники набрались! Вперед!");
        System.out.println("Все туристы пошли в поход");
        LATCH.countDown();
    }
}
