package com.company;

import java.util.concurrent.CountDownLatch;

public class Guide extends Thread  {



    private static int tourist;
    private static CountDownLatch LATCH;

    public Guide(int tourist) {
        this.tourist = tourist;
    }

    public void run() {
        try {
            System.out.printf("Нашелся турист %d\n", tourist);
            LATCH.countDown();
            LATCH.await();

            System.out.printf("Все туристы наглись!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

