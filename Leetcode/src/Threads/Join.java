package Threads;

public class Join {
    /**
     * По идее метода join(), если я правильно его понимаю, он должен передавать управление программой тому потоку,
     * на объекте которого был вызван,
     * в то время как тот поток который этот вызов произвел, должен ждать.
     */
    public static void main(String[] args){
        Thread t1 = new Thread(new MyRunnable("t1"));
        Thread t2 = new Thread(new MyRunnable("t2"));
        Thread t3 = new Thread(new MyRunnable("t3"));
        //начали первый поток
        t1.start();
        /**t2.start();*/
        //остановили работу потока на 2 секунды.Он не завершил свое выполнение
        try{
            t1.join(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**-------------------------------------------------------------------*/
        /**Expected output:
         * Поток t1 начал свою работу
         * Поток t2 начал свою работу
         * Поток t2 завершил свою работу
         * Поток t1 завершил свою работу
         */
        //стартанул второй и начал работать.
        t2.start();
        //Даем возможность первому потоку до конца закончиться(т.к. второй то уже закончился)
        try{
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
        //даем возможность всем трем потокам закончиться до того,как программа закончит свое выполнение
        try{
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
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
}
