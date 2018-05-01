package Sortings;

import java.util.Date;
import java.util.Random;

public class Shell_Sort {
    private static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }
    private static void swap(Comparable[] a,int i,int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    public static void shell_sort(Comparable[] arr){
        int d = arr.length/2;
        while(d!=0){
            for(int i = 0;i<arr.length-d;++i){
                int j = i;
                while(j>=0 && less(arr[j],arr[j+d])){
                    swap(arr,j,j+d);
                    --j;
                }
            }
            d/=2;
        }

    }
    public static void main(String[] args){
        Date date = new Date();
        Integer[] integers = new Integer[10];
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
            Shell_Sort.shell_sort(integers);
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
