package Multithreading;

public class InterruptDemo extends Thread {
        public void run() {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("child");
                    Thread.sleep(100);
                }
            }catch(InterruptedException e){
                System.out.println("Interruption");
            }
        }

        public static void main(String[] args) throws InterruptedException {
            InterruptDemo t = new InterruptDemo();
            t.start();
            t.interrupt();
            for (int i = 1; i <= 10; i++) {
                System.out.println("main");
                Thread.sleep(100);
            }

        }
}
