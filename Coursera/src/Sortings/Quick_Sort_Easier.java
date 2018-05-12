package Sortings;

public class Quick_Sort_Easier {
    private static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<=0;
    }
    private static void swap(Comparable[] a,int i,int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void sort(Comparable[] a,int low,int high){
        if(high<=low)return;
        int lt = low,gt = high,i = low;
        Comparable v = a[low];
        while(i<=gt){
            int cmp = a[i].compareTo(v);
            if(cmp<0)swap(a,lt++,i++);
            else if(cmp>0)swap(a,i,gt--);
            else i++;

        }
        sort(a,low,lt-1);
        sort(a,gt+1,high);
    }
    private static boolean isSorted(Comparable[] a, int lo, int high) {
        for (int i = lo; i < high - 1; ++i) {
            if (!less(a[i], a[i + 1])) return false;
        }
        return true;
    }
}
