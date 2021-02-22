package com.leecode.easy;

public class PrintInOrder {
    private volatile int i = 0;
    
    public PrintInOrder() {
    }
    
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        i = 1;
    }
    
    public void second(Runnable printSecond) throws InterruptedException {
        while (i != 1) {
        }
        printSecond.run();
        i = 2;
    }
    
    public void third(Runnable printThird) throws InterruptedException {
        while (i != 2) {
        }
        printThird.run();
    }
    
    public static void main(String[] args) {
        PrintInOrder p = new PrintInOrder();
        
        new Thread(() -> {
            try {
                p.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                p.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                p.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}