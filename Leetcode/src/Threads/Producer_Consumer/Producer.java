package Threads.Producer_Consumer;

import java.util.ArrayList;

public class Producer implements Runnable{
    private ArrayList<Integer> amount;

    public Producer(ArrayList<Integer> amount) {
        this.amount = amount;
    }
    public void get(){

    }
    @Override
    public void run() {
        while(amount.size()<=10){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            amount.add(amount.size()-1);
            amount.add(amount.size()-1);
            System.out.println("Производитель произвел одну единицу товара.Товаров на складе: "+ amount.size());
        }

    }
}
