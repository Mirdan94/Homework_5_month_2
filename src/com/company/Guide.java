package com.company;

import java.util.concurrent.CountDownLatch;

public class Guide extends Thread {


    private static int guide;
    private static CountDownLatch LATCH;

    public Guide(int guide, CountDownLatch LATCH) {
        this.LATCH = LATCH;
        this.guide = guide;

    }


    public void run() {
        try {
            System.out.printf("Нашелся турист %d\n", guide);
            LATCH.countDown();
            LATCH.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

