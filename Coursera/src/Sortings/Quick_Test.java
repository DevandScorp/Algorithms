package Sortings;

import java.util.Date;
import java.util.Random;

public class Quick_Test {
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
            /**сначала идешь по i*/
            while(less(a[i++],a[low])){if(i>=high)break;}
            while(less(a[--j],a[low])){if(j<=low)break;}
            if(i>=j)break;
            swap(a,i,j);
        }
        swap(a,low,j);
        return j;
    }
    private static void sort(Comparable[] a,int low,int high){
        if(high<=low) return;
        int j = partition(a,low,high);
        sort(a,low,j-1);/**j-это уже середина*/
        sort(a,j+1,high);
    }
    public static void sort(Comparable[] a){
        Shuffling.shuffle(a);/**Нам нужно перемешать массив,чтобы избежать ситуации,когда массив отсортирован и приводит к N^2*/
        sort(a,0,a.length-1);
    }
    public static void main(String[] args){
        Date date = new Date();
        Integer[] integers = new Integer[10];
        Integer[] integers_2 = new Integer[10];
        Random r = new Random();
        int counter = 0;
        Date data = new Date();
        for(int m = 0;m<5;++m) {
            for (int i = 0; i < integers.length; ++i) {
                integers[i] = r.nextInt(100);
            }
            for (int i = 0; i < integers.length; ++i) {
                System.out.print(integers[i] + " ");
            }
            System.out.println();
            QuickSort.sort(integers);
//        String[] strings = new String[16];
//        strings[0] = "M";strings[1] = "E";strings[2] = "R";strings[3] = "G";strings[4] = "E";strings[5] = "S";
//        strings[6] = "O";strings[7] = "R";strings[8] = "T";strings[9] = "E";strings[10] = "X";strings[11] = "A";
//        strings[12] = "M";strings[13] = "P";strings[14] = "L";strings[15] = "E";
//
//        System.out.println("Sorted:");
            for (int i = 0; i < integers.length; ++i) {
                System.out.print(integers[i] + " ");
            }
            System.out.println(Quick_Test.isSorted(integers));
        }
        Date date_2 = new Date();
        System.out.println(date_2.getTime()-date.getTime());
    }
}
