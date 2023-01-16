package Multithreading;

public class SleepDemo extends Thread {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("child");
            }
        }

        public static void main(String[] args) throws InterruptedException {
            SleepDemo t = new SleepDemo();
            t.start();
            for (int i = 1; i <= 10; i++) {
                System.out.println("main");
                Thread.sleep(600);
            }
        }
}
