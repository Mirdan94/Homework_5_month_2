package com.company;

import java.util.concurrent.CountDownLatch;

public class Main {

    private static final int touristsNumber = 15;
    private static CountDownLatch LATCH;

    public static void main(String[] args) throws InterruptedException {

        LATCH = new CountDownLatch(touristsNumber + 1);
        for (int i = 1; i <= touristsNumber; i++) {

            Guide guide = new Guide (i);
            guide.start();
        }
while (LATCH.getCount() > 1) {
    Thread.sleep(1000);
}

System.out.println ("Все участники набрались! Вперед!");
LATCH.countDown();
    }
}
