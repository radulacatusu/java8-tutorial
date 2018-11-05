package com.mine.tutorials.lambda;

/**
 * @stefanl
 */
public class RunnableLambda {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<3;i++){
                    System.out.println("hello from thread - " + Thread.currentThread().getName());
                }
            }
        };

        Runnable runnable1 = () -> {
            for (int i=0;i<3;i++){
                System.out.println("hello from thread - " + Thread.currentThread().getName());
            }
        };

        Thread t = new Thread(runnable1);
        t.start();
        t.join();
    }
}
