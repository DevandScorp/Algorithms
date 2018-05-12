package Sortings;

import java.util.Date;
import java.util.Random;

public class Selection_Kth {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) <=0;
    }
    private static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length-1; ++i) {
            if (!less(a[i], a[i + 1])) return false;
        }
        return true;
    }
    private static void swap(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    private static int partition(Comparable[] a,int low,int high){
        int i = low,j = high+1;
        while(true){
            while(less(a[++i],a[low])){if(i==high)break;}
            while(less(a[low],a[--j])){if(j==low)break;}
            if(i>=j)break;
            swap(a,i,j);
        }
        swap(a,low,j);
        return j;
    }

    /***
     * Этот алгоритм выбирает k-ое наибольшее число.Суть в том,что он просто выборкой находит нужный элемент,
     * а также левее этого элемента будут находиться меньшие элементы,а правее-наибольшие
     * @param a
     * @param k
     * @return
     */
    public static Comparable select(Comparable[] a,int k){
        Shuffling.shuffle(a);
        int lo = 0,hi = a.length-1;
        while(hi>lo){
            int j = partition(a,lo,hi);
            if(j<k)lo = j+1;
            else if(j>k)hi = j-1;
            else return a[k];
        }
        return a[k];
    }
    public static void main(String[] args){
        Integer[] integers = new Integer[10];
        Random r = new Random();
        int counter = 0;
        Date data = new Date();
            for (int i = 0; i < integers.length; ++i) {
                integers[i] = r.nextInt(100);
            }
            for (int i = 0; i < integers.length; ++i) {
                System.out.print(integers[i] + " ");
            }
            System.out.println();
            System.out.println(select(integers,3));
        /**
         * выведет третий наибольший элемент,при этом слева будут находиться все элементы,меньшие
         */
        for (int i = 0; i < integers.length; ++i) {
                System.out.print(integers[i] + " ");
            }
        }
}
