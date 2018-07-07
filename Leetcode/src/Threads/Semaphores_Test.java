package Threads;

import java.util.concurrent.Semaphore;

public class Semaphores_Test {
    /**
     * Семафоры отлично подходят для решения задач, где надо ограничивать доступ.
     * Например, классическая задача про обедающих философов.
     * Ее суть: есть несколько философов, допустим, пять, но одновременно за столом могут сидеть не более двух.
     * И надо, чтобы все философы пообедали,
     * но при этом не возникло взаимоблокировки философами друг друга в борьбе за тарелку и вилку:
     */
    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(2);
        for(int i = 0;i<5;++i){
            new Phylosopher(semaphore,i).start();
        }
    }
    public static class Phylosopher extends Thread {
        Semaphore semaphore;//семафор,ограничивающий доступ к ресурсам.
        int num = 0;//количество приемов пищи.
        int id;
        public Phylosopher(Semaphore semaphore,int id){
            this.semaphore = semaphore;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                while(num<3){
                    semaphore.acquire();//запрашиваем разрещение на выполнение.
                    System.out.println("Философ " + id + " садится за стол");
                    //философ ест
                    sleep(500);
                    num++;
                    System.out.println("Философ " + id + " выходит из-за стола");
                    semaphore.release();
                    sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
