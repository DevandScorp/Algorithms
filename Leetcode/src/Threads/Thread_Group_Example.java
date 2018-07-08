package Threads;

public class Thread_Group_Example {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup = new ThreadGroup("Group A");
        Thread t1 = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"one");
        t1.start();
        Thread t2 = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"second");
        t2.start();
        Thread t3 = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"third");
        t3.start();
        //ThreadGroup при методе list выведет список только активных потоков
        //т.е. без sleep хер бы здесь что-нибудь получилось
        //с помощью threadGroup ты можешь останавливать все потоки,чекать активные потоки
        //и много других штук
        System.out.println("Thread Group Name: "+threadGroup.getName());
        threadGroup.list();
    }

}
