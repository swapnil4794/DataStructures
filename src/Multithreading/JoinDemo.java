package Multithreading;

class MyThread extends Thread {

    static Thread m;
    public void run() {
        try {
            m.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println("child");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        m = Thread.currentThread();
        MyThread t = new MyThread();
        t.start();
//t.join();
        for (int i = 1; i <= 10; i++) {
            System.out.println("main");
            Thread.sleep(100);
        }
    }
}