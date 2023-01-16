package Multithreading;

public class DaemonDemo extends Thread {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("daemon:");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            DaemonDemo t = new DaemonDemo();
            t.setDaemon(true);
            t.start();

            for (int i = 1; i <= 5; i++) {
                System.out.println("main");
                Thread.sleep(100);
            }
        }
}
