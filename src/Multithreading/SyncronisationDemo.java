package Multithreading;

public class SyncronisationDemo {

    public static synchronized void print(String msg) {

        for (int i = 1; i <= 2; i++) {
            System.out.println("Hi :" + msg);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Interruption");
            }
        }

    }
}
class Demo1 extends Thread{
    public void run() {
        SyncronisationDemo.print("demo1");
    }
}
class Demo2 extends Thread{
    public void run() {
        SyncronisationDemo.print("demo2");
    }
}
class Demo3 extends Thread{
    public void run() {
        SyncronisationDemo.print("demo3");
    }
}

 class MyThread1{
        public static void main(String[] args) throws InterruptedException {

            Demo2 t2 = new Demo2();
            Demo1 t1 = new Demo1();
            Demo3 t3 = new Demo3();

            t2.start();
            t1.start();
            t3.start();
        }
}
