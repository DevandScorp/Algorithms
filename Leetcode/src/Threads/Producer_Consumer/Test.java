package Threads.Producer_Consumer;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<5;++i){
            list.add(i);
        }
        Thread producer = new Thread(new Producer(list));
        Thread consumer = new Thread(new Consumer(list));
        producer.start();
        consumer.start();
    }
}
