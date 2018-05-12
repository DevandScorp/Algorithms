package Priority_Queue;

import Sortings.Insertion;
import Sortings.Mergion_Sort;

import java.util.Date;
import java.util.Random;

public class Binary_Heap_Sorting {
    /**
     *Наилучший алгоритм с in-place(как я понял,типо не выделяет дополнительную память)
     * скорость -NlogN в худщшем случае
     * Минусы,из-за которого его почти не используют
     * 1)не stable
     * 2)внутренний цикл больше,чем у quicksort
     * 3)плохое использование кэша(типо у Heap_sort разбежка по циклу намного больше,чем у quicksort)
     */
    private static void sink(Comparable[] pq,int k,int N){
        while(2*k<=N){
            int j = 2*k;/**Переходим к детям*/
            if(j<N && less_second(pq,j,j+1))j++;/**Находим правого сына*/
            if(!less_second(pq,k,j))break;/**Если он больше-ломаем программу*/
            swap(pq,k,j);/**или свапаем,если все нормально*/
            k = j;/**Идем дальше*/
        }
    }

    /***
     * Прошу обратить внимание,молодой человек,что т.к. sink начинается с единицы,поэтому для того,чтобы учесть
     * 0,необходимо еще и уменьшить i,j в swap and less на 1
     * @param a
     * @param i
     * @param j
     * @return
     */
    private static boolean less_second(Comparable[] a,int i,int j){
        return a[--i].compareTo(a[--j])<=0;
    }
    private static boolean less(Comparable[] a,int i,int j){
        return a[i].compareTo(a[j])<=0;
    }
    private static void swap(Comparable[] a,int i,int j) {
        --i;--j;
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void sort(Comparable[] a){
        int N = a.length;
        /**
         * Суть алгоритма такова:
         * 1)Сначала ты спускаешься вниз,начиная с N/2,и там все max-heap-аешь
         * 2)Потом ты постоянно меняешь корень с последним элементом,опять при этом начиная тонуть
         * с корня
         */
        for(int k = N/2;k>=1;--k){
            sink(a,k,N);
        }
        while(N>1){
            swap(a,1,N);
            sink(a,1,--N);
        }
    }
    private static boolean isSorted(Comparable[] a, int lo, int high) {
        for (int i = lo; i < high - 1; ++i) {
            if (!less(a,i,i + 1)) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Date date = new Date();
        Integer[] integers = new Integer[10];
        Random r = new Random();
        int counter = 0;
        for (int m = 0; m < 3; ++m) {
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
            Binary_Heap_Sorting.sort(integers);
            System.out.println();
            for (int i = 0; i < integers.length; ++i) {
                if (counter == 20) {
                    counter = 0;
                    System.out.println();
                }
                System.out.print(integers[i] + " ");
                ++counter;
            }
            System.out.println(Binary_Heap_Sorting.isSorted(integers,0,integers.length));

        }
        Date date_1 = new Date();
        System.out.println("\nTIME: " + (date_1.getTime() - date.getTime()));
    }
}
