package Threads;

public class Wait_Notify_Example {
    /**
     * wait(): освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор,
     * пока другой поток не вызовет метод notify()
     * notify(): продолжает работу потока, у которого ранее был вызван метод wait()
     * notifyAll(): возобновляет работу всех потоков, у которых ранее был вызван метод wait()
     * Важно понять, что метод sleep() не освобождает объект блокировки.
     * С другой стороны, метод wait() снимает блокировку с объекта,
     * тем самым позволяя остальным потокам вызывать другие синхронизированные методы объекта во время выполнения wait().
     * Это очень важно, потому что обычно именно «другие» методы приводят к изменению условия и активизации приостановленной задачи.
     * @param args
     */
    public static void main(String[] args){
        Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
    public  static class Store {
        private int product = 0;
        public synchronized void get() throws InterruptedException {
            /**
             * Метод wait,notify и notifyAll() вызывается только из синхронизированных блоков
             */
            while(product<1){
                wait();
            }
            --product;
            System.out.println("Покупатель купил 1 единицу товара");
            System.out.println("Товаров на складе " + product);
            notify();
        }
        public synchronized void put() throws InterruptedException {
            while(product>=3){
                wait();
            }
            ++product;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("Товаров на складе: " + product);
            notify();
        }
    }
    public static class Producer implements Runnable{

        Store store;
        Producer(Store store){
            this.store=store;
        }
        public void run(){
            for (int i = 1; i < 6; i++) {
                try {
                    store.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // Класс Потребитель
    public static class Consumer implements Runnable{

        Store store;
        Consumer(Store store){
            this.store=store;
        }
        public void run(){
            for (int i = 1; i < 6; i++) {
                try {
                    store.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
