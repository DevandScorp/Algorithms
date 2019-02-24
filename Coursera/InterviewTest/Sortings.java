package InterviewTest;

import java.util.Arrays;
import java.util.Random;

public class Sortings {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            int min = i;
            for (int j = i + 1; j < arr.length; ++j) {
                if(arr[j]< arr[min]){
                    min = j;
                }
            }
            if(i!=min){
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }
    public static void shellSort(int[] arr) {
        int d = arr.length/2;
        while(d!=0){
            for(int i = 0;i<arr.length-d;++i){
                for(int j = i; j>=0; --j){
                    if(arr[j] < arr[j+d]){
                        int tmp = arr[j];
                        arr[j] = arr[j+d];
                        arr[j+d] = tmp;
                    }
                }
            }
            d/=2;
        }
    }
    public static void quickSort(int[] arr,int begin, int end) {
        int left = begin, right = end;
        int mid = arr[(left+right)/2];
        while(left<=right) {
            while (arr[left] < mid) {
                ++left;
            }
            while (arr[right] > mid) {
                --right;
            }
            if (left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                ++left;
                --right;
            }
        }
        if(begin < right){
            quickSort(arr,begin, right);
        }
        if(end > left){
            quickSort(arr,left, end);
        }
    }
    public static void insertionSort(int[] arr){
        for (int i = 0; i < arr.length; ++i) {
            for(int j = i; j > 0; --j){
                if(arr[j]>arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = r.nextInt(10);
        }
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
