package com;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        Phaser p = new Phaser(3);
        new Washer(p);
        new Washer(p);
        new Washer(p);

    }

    static class Washer extends Thread {
        Phaser p;

        public Washer(Phaser p) {

            this.p = p;
            start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(getName()+" washing the car ");
                p.arriveAndAwaitAdvance();
            }
        }
    }
}
