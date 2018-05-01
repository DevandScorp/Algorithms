package Sortings;

import java.io.File;
import java.util.Date;
import java.util.Random;

public class Selection {
    private static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }
    private static void swap(Comparable[] a,int i,int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    public static void sort(Comparable[] a){
        /**
         * Рофл этой сортировки в том,что ты ходишь
         */
        int N = a.length;
        for(int i = 0;i<N-1;++i){
            int min = i;
            for(int j = i+1;j<N;++j){
                if(less(a[j],a[min]))min = j;
            }
            if(min!=i){
                swap(a,min,i);
            }
        }
    }
    public static void main(String[] args) {
        Date date = new Date();
        Integer[] integers = new Integer[10000];
        Random r = new Random();
        int counter = 0;
        for (int i = 0; i < integers.length; ++i) {
            integers[i] = r.nextInt(100);
        }
        for (int i = 0; i < integers.length; ++i) {
            if (counter == 20) {
                counter = 0;
                System.out.println();
            }
            System.out.print(integers[i] + " ");
            ++counter;
        }
        Selection.sort(integers);
        System.out.println("\nSorted");
        for (int i = 0; i < integers.length; ++i) {
            if (counter == 20) {
                counter = 0;
                System.out.println();
            }
            System.out.print(integers[i] + " ");
            ++counter;
        }
        Date date_1 = new Date();
        System.out.println("\nTIME: "+ (date_1.getTime()-date.getTime()));
    }
}
