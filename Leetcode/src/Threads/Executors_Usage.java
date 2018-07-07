package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executors_Usage {
    /**
     * Concurrency API вводит понятие сервиса-исполнителя (ExecutorService) — высокоуровневую замену работе с потоками напрямую.
     * Исполнители выполняют задачи асинхронно и обычно используют пул потоков,
     * так что нам не надо создавать их вручную.
     * Все потоки из пула будут использованы повторно после выполнения задачи,
     * а значит, мы можем создать в приложении столько задач, сколько хотим, используя один исполнитель.
     * @param args
     */
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<5;++i){
            executorService.execute(new Test(Integer.toString(i)));
        }
        executorService.shutdown();
        /**Вызов shutdown() предотвращает передачу Executor новых задач.По сути,исполнитеди позволяют тебе заставить потоки
         * работать и исполняться,не требуя при этом твоего личного управления
         * также существуют newFixedThreadPool(int)-логично,SingleThreadPool-единичный,удобен,когда нужно исполнять
         * какую-то одну задачу(например,данные по сокету перехватывать.*/
        /**Если SingleThreadExecutor передается более одной задачи, эти задачи ставятся в очередь,
         *  и каждая из них отрабатывает до завершения перед началом следующей задачи,
         *  причем все они используют один и тот же поток.
         * В следующем примере мы видим, что задачи последовательно завершаются в порядке их поступления
          */
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        for(int i = 0;i<5;++i){
            executorService1.execute(new Test(Integer.toString(i)));
        }
        executorService1.shutdown();
        /**
         * Expected Output:
         * 0 начал свою работу
         * 0 закончил свою работу
         * 1 начал свою работу
         * 1 закончил свою работу
         * 2 начал свою работу
         * 2 закончил свою работу
         * 3 начал свою работу
         * 3 закончил свою работу
         * 4 начал свою работу
         * 4 закончил свою работу
         * Кстати,без shutdown программа просто не завершится
         *
         */

    }
    public static class Test implements Runnable{
        private String name;

        public Test(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(this.name+" начал свою работу" );
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name+" закончил свою работу" );
        }
    }
}
