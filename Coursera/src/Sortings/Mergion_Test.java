package Sortings;

import java.util.Date;
import java.util.Random;

public class Mergion_Test {
    private static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<=0;
    }
    private void swap(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void merge(Comparable[] a,Comparable[] aux,int low,int mid,int high){
        /**сначала переносишь в aux все a*/
        for(int i = low;i<=high;++i){
            aux[i] = a[i];
        }
        int i = low,j = mid+1;
        /**переносишь в a все значения aux по алгоритму*/
        /**ТЫ ЖЕ ЗАНОСИШЬ В A ПО ИНДЕКСАММ K*/
        for(int k = low;k<=high;++k){
            if(i>mid)a[k] = aux[j++];
            else if(j>high)a[k] = aux[i++];
            else if(less(aux[i],aux[j]))a[k] = aux[i++];/**Если i-ый меньше,то идем по i,пока оно будет меньше,если нет,то по j*/
            else a[k] = aux[j++];
        }
    }
    private static void sort(Comparable[] a,Comparable[] aux,int low,int high){
        if(high<=low){
            return;
        }
        int mid = low + (high-low)/2;
        sort(a,aux,low,mid);
        sort(a,aux,mid+1,high);
        merge(a,aux,low,mid,high);
    }
    private static boolean isSorted(Comparable[] a, int lo, int high) {
        for (int i = lo; i < high - 1; ++i) {
            if (!less(a[i], a[i + 1])) return false;
        }
        return true;
    }
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }
    public static void main(String[] args){
        Date date = new Date();
        Integer[] integers = new Integer[10];
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
            Mergion_Test.sort(integers);
//        String[] strings = new String[16];
//        strings[0] = "M";strings[1] = "E";strings[2] = "R";strings[3] = "G";strings[4] = "E";strings[5] = "S";
//        strings[6] = "O";strings[7] = "R";strings[8] = "T";strings[9] = "E";strings[10] = "X";strings[11] = "A";
//        strings[12] = "M";strings[13] = "P";strings[14] = "L";strings[15] = "E";
//
//        System.out.println("Sorted:");
            for (int i = 0; i < integers.length; ++i) {
                System.out.print(integers[i] + " ");
            }
            System.out.println(Mergion_Test.isSorted(integers,0,integers.length));
        }
        Date date_2 = new Date();
        System.out.println(date_2.getTime()-date.getTime());
    }
    }
