package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Thread_Factory {
    public static class DaemonThreadFactory implements ThreadFactory{

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    }
    public static class Daemon_Runnable implements Runnable{
        private String name;

        public Daemon_Runnable(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println("Thread started: " + this.name);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread finished: " + this.name);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor(new DaemonThreadFactory());
        //т.е. по сути ты в параметрах можешь указывать эту самую фабрику,и она будет просто присваивать каждому потоку
        //нужное тебе свойство
        for(int i = 0;i<5;++i){
            executorService.execute(new Daemon_Runnable(Integer.toString(i)));
        }
        TimeUnit.SECONDS.sleep(10);
        executorService.shutdown();
    }
}
