package Threads.Producer_Consumer;

import java.util.ArrayList;

public class Consumer implements Runnable {
    private ArrayList<Integer> amount;

    public Consumer(ArrayList<Integer> amount) {
        this.amount = amount;
    }

    @Override
    public void run() {
        while(amount.size()>0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            amount.remove(amount.size()-1);
            System.out.println("Потребитель использовал одну единицу товара.Товаров на складе: "+ amount.size());
        }

    }
}
