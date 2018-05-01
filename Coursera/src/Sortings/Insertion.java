package Sortings;

import java.util.Date;
import java.util.Random;

public class Insertion {
    private static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }
    private static void swap(Comparable[] a,int i,int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    public static void insertion_sort(Comparable[] arr){
        for(int i = 0;i<arr.length;++i){
            for(int j = i;j>0;--j){
                //less(arr[j],arr[j-1]) для сортировки по возрастанию и наоборот для сортировки по убыванию
                //(логично)
                if(less(arr[j],arr[j-1]))swap(arr,j,j-1);
                else break;
            }
        }
    }
    public static void main(String[] args){
            Date date = new Date();
            Integer[] integers = new Integer[100];
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
        Insertion.insertion_sort(integers);
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
