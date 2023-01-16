package Multithreading;

public class AnonymousThreadDemo {

        public static void main(String[] args) throws InterruptedException {
           new Thread(){
               public void run() {
                   for (int i = 1; i <= 10; i++) {
                       System.out.println(Thread.currentThread().getName()+" :"+i);
                   }
               }}.start();
        }
}
