package Sortings;

import java.util.Date;
import java.util.Random;

public class QuickSort{
    /**The Java API for \verb#Arrays.sort()
    #Arrays.sort() for reference types requires that it is stable and guarantees n \log nnlogn performance.
    Neither of these are properties of standard quicksort.
    Quicksort uses less memory and is faster in practice on typical inputs (and is typically used by \verb#Arrays.sort()
    #Arrays.sort() when sorting primitive types, where stability is not relevant).
    */
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
    private static int partition(Comparable[] a,int lo,int hi){
        /**Прошу также отметить,что partition не отсортирует все за один шаг,т.к. мы будем знать лишь то,что
        *слева находятся все элементы,которые меньше j,а справа-большие,но они не обязаны быть отсортированными*/
        */
        int i = lo,j = hi+1;
        /**
        Прошу отметить,что во-первых,ты идешь не с самого низа, а с индекса low+1
        Во-вторых,элементы с j должны быть больше,а не меньше-это тоже важно
        Также j должны идти начиная с high+1,т.к. только тогда первым будет элемент high
        Т.е. если ты поставишь постинкремент,то в цикле все будет норм,но при обмене оно уже не будет учитывать high
        поэтому нужно задавать high+1 и делать преинкремент
        */
        while(true){
            while(less(a[++i],a[lo])){
                if(i==hi) break;/** find elements on the left*/
            }
            while(less(a[lo],a[--j])){
                if(j==lo) break;/**on the right*/
            }
            if(i>=j) break;
            swap(a,i,j);
        }
        swap(a,lo,j);/**обменял j и lo*/
        return j;
    }
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        int j = partition(a,lo,hi);
        /**
        Тут у тебя j есть середина,поэтому ты начинаешь с j-1 и j+1 соответственно
        */
        sort(a,lo,j-1);
        sort(a,j+1,hi);
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
        for(int m = 0;m<20;++m) {
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
            System.out.println(QuickSort.isSorted(integers));
        }
        Date date_2 = new Date();
        System.out.println(date_2.getTime()-date.getTime());
    }
}
