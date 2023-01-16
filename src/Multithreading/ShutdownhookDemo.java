package Multithreading;



public class ShutdownhookDemo extends Thread {
        public void run() {

                System.out.println("shutdown hook");
        }

        public static void main(String[] args) throws InterruptedException {
            ShutdownhookDemo t = new ShutdownhookDemo();
            Runtime.getRuntime().addShutdownHook(t);
            for (int i = 1; i <= 10; i++) {
                System.out.println("main");
                Thread.sleep(600);
            }
        }
}
