package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Daemon {
    public static class Simple_Demon implements Runnable {
        private String name;

        public Simple_Demon(String name) {
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
        for(int i = 0;i<5;++i){
            Thread simple_demon = new Thread(new Simple_Demon(Integer.toString(i)));
            simple_demon.setDaemon(true);
            //именно потоку ты устанавливаешь демона,но не нити
            simple_demon.start();
        }
        //если тут ты остановишь поток на какое-то время,то демоны успеют выполниться
        //если нет,то они не завершатся до конца,потому что метод main уже завершится и ему глубоко насрать
        //на потоки демоны
    }
}
