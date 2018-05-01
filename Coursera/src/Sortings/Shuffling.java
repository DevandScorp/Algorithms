package Sortings;

import java.util.Random;

public class Shuffling {
    private static void swap(Object[] a,int i,int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    public static void shuffle(Object[] arr){
        /**
         * Фишка в том,что ты должен брать рандомное число r в промежутке
         * от нуля до i и свапать
         */
        Random rand = new Random();
        for(int i = 0;i<arr.length;++i){
            int r = rand.nextInt(i+1);
            swap(arr,r,i);
        }
    }
    public static void main(String[] args){
        Integer[] a = new Integer[10];
        for(int i = 0;i<10;++i){
            a[i] = i;
        }
        Shuffling.shuffle(a);
        for(int i = 0;i<10;++i){
            System.out.print(a[i] + " ");
        }
    }
}
