package Threads;

public class Join_Test {
    public static class MyRunnable implements Runnable{
        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Поток "+ this.name + " начал свою работу");
            try{
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Поток "+ this.name + " завершил свою работу");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable("t1"));
        Thread t2 = new Thread(new MyRunnable("t2"));
        Thread t3 = new Thread(new MyRunnable("t3"));
        t1.start();
        t2.start();
        //т.е. все-таки join останавливает поток,который его вызвал
        t1.join();
        /**
         * Output:
         * Поток t2 начал свою работу       |       Поток t1 начал свою работу
         * Поток t1 начал свою работу       |       Поток t2 начал свою работу
         * Поток t1 завершил свою работу    |       Поток t2 завершил свою работу
         * Поток t2 завершил свою работу    |       Поток t1 завершил свою работу
         */
    }
}
