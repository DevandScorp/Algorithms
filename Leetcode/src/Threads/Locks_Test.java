package Threads;

import java.util.concurrent.locks.ReentrantLock;

public class Locks_Test {
    public static class CommonResource {
        public int x = 0;
    }
    public static void main(String[] args){
        CommonResource commonResource= new CommonResource();
        ReentrantLock locker = new ReentrantLock(); // создаем заглушку
        for (int i = 1; i < 6; i++){

            Thread t = new Thread(new CountThread(locker,commonResource));
            t.setName("Thread "+ i);
            t.start();
        }
    }
    public static class CountThread implements Runnable{
        private ReentrantLock reentrantLock;
        private CommonResource commonResource;

        public CountThread(ReentrantLock reentrantLock, CommonResource commonResource) {
            this.reentrantLock = reentrantLock;
            this.commonResource = commonResource;
        }

        @Override
        public void run() {
            reentrantLock.lock();//устанавливаем блокировку
            try{
                commonResource.x = 1;
                for (int i = 1; i < 5; i++){
                    System.out.printf("%s %d \n", Thread.currentThread().getName(), commonResource.x);
                    commonResource.x++;
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                reentrantLock.unlock();//в конце снимаем блокировку
            }
        }
    }

}
