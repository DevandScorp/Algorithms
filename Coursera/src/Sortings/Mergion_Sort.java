package Sortings;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Mergion_Sort {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) <=0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a, int lo, int high) {
        for (int i = lo; i < high - 1; ++i) {
            if (!less(a[i], a[i + 1])) return false;
        }
        return true;
    }
    private static void merge(Comparable[] a,Comparable[] aux,int lo,int mid,int hi) {
        assert isSorted(a,lo,mid);
        /**Проверяет, отсортирован ли маиисв*/
        assert isSorted(a,mid+1,hi);

        for(int k = lo;k<=hi;++k){
            aux[k] =a[k];

        }
        int i = lo,j = mid+1;
        /**сначала переносишь в aux все a*/
        /**переносишь в a все значения aux по алгоритму*/
        /**ТЫ ЖЕ ЗАНОСИШЬ В A ПО ИНДЕКСАММ K*/
        for(int k = lo;k<=hi;++k){
            if(i>mid)a[k] = aux[j++];
            else if(j>hi)a[k] = aux[i++];
            else if(less(aux[i],aux[j]))a[k] = aux[i++];/**Если i-ый меньше,то идем по i,пока оно будет меньше,если нет,то по j*/
            else a[k] = aux[j++];
        }
        assert isSorted(a,lo,hi);
    }
    private static void sort(Comparable[] a,Comparable[] aux,int low,int high){
        if(high<=low){
            Insertion.sort(a,low,high);
            return;
        }
        int mid = low+(high-low)/2;
        //System.out.println("Low = " + low + " High = " + high + " Mid = " + mid);
//        for(int i = low;i<=high;++i){
//            System.out.print(a[i] + " ");
//        }
        //System.out.println();
        sort(a,aux,low,mid);
        sort(a,aux,mid+1,high);
        if(!less(a[mid+1],a[mid])) return;//еще ускорение
        merge(a,aux,low,mid,high);
    }
    public static void sort(Comparable[] a) throws Exception{
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }

    /**
     * Этот метод делит их на подмассивы и там их сортирует,начниая с двух
     * @param a
     * @throws Exception
     */
    public static void sort_no_recirsion(Comparable[] a)  {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for(int size = 1;size<N;++size){
            for(int low = 0;low<N-size;low+=size*2){
                merge(a,aux,low,low+size-1,Math.min(low+2*size-1,N-1));
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Date date = new Date();
        Integer[] integers = new Integer[100];
        Integer[] integers_2 = new Integer[10];
        Random r = new Random();
        int counter = 0;
        Date data = new Date();
        for(int m = 0;m<10;++m) {
            for (int i = 0; i < integers.length; ++i) {
                integers[i] = r.nextInt(100);
            }
            for (int i = 0; i < integers.length; ++i) {
                System.out.print(integers[i] + " ");
            }
            System.out.println();
            Mergion_Sort.sort(integers);
//        String[] strings = new String[16];
//        strings[0] = "M";strings[1] = "E";strings[2] = "R";strings[3] = "G";strings[4] = "E";strings[5] = "S";
//        strings[6] = "O";strings[7] = "R";strings[8] = "T";strings[9] = "E";strings[10] = "X";strings[11] = "A";
//        strings[12] = "M";strings[13] = "P";strings[14] = "L";strings[15] = "E";
//
//        System.out.println("Sorted:");
            for (int i = 0; i < integers.length; ++i) {
                System.out.print(integers[i] + " ");
            }
            System.out.println(Mergion_Sort.isSorted(integers,0,integers.length));
        }
        Date date_2 = new Date();
        System.out.println(date_2.getTime()-date.getTime());
    }

}

