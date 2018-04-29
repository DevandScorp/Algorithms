package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Binary_Search {
    public static int binary_search(int[] arr,int x,int low,int high){
        while(low<high){

            int mid = low + (high-low)/2;
            if(x < arr[mid])return binary_search(arr, x, low,mid);
            else if(x>arr[mid])return binary_search(arr, x, mid,high);
            else return mid;
        }
        return -1;
    }
    /*для массива,в котором элементы до середины возврастают,а потом убывают*/
    public static int down_side_binary_search(int[] arr,int x,int low,int high){
        while(low<high){
            int mid = low + (high-low)/2;
           //System.out.println(mid);
            if(x > arr[mid])return down_side_binary_search(arr,x,low,mid);
            else if(x<arr[mid])return down_side_binary_search(arr,x,mid,high);
            else return mid;

        }
        return -1;
    }
    /*public int new_search(int[] arr,int x){
        int low = 0;
        int high = Arrays.sea
    }*/

    public static void main(String[] args) throws IOException {
        int[] arr = new int[11];
        Random r = new Random();
        /*for(int i = 0;i<arr.length;++i){
            arr[i] = r.nextInt(100);
        }*/
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 4;
        arr[3] = 6;
        arr[4] = 9;
        arr[5] = 14;
        arr[6] = 11;
        arr[7] = 7;
        arr[8] = 2;
        arr[9] = -4;
        arr[10] = -9;
       /* Arrays.sort(arr);*/
        System.out.println(Arrays.toString(arr));
/*
        for(int i = 0;i<arr.length;++i){
             System.out.print(binary_search(arr,arr[i],0,arr.length) + " ");
        }*/
        System.out.println();
        int mid = (arr.length)/2;

        int max = arr[mid+1]<arr[mid-1]?mid-1:mid+1;
        System.out.println("mid = " + mid);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            for(int i = 0;i<arr.length;++i){
                int a = arr[i];
                if(a<arr[max]){
                    System.out.println("a < mid");
                    System.out.println(binary_search(arr,a,0,max));

                }
                else if(a>arr[max]){
                    System.out.println("a > mid");
                    System.out.println(down_side_binary_search(arr,a,max,arr.length-1));

                }
                else if(arr[i]==mid){
                    System.out.println(mid);
                    System.out.println("MAX = " + max);
                }
                else{
                    System.out.println(max);
                }
            }


        }catch(IOException e){

        }

        /*Усовершенствованный алгоритм поиска трех чисел,сумма которых дает ноль.
         * сложность такого алгоритма будет N^2*log(N),т.к. сложность бинарного поиска составляет 1*log(N)*/
//        for(int i = 0;i<arr.length;++i){
//            for(int j = i+1;j<arr.length;++j){
//                int k = binary_search(arr,-(arr[i]+arr[j]),0,arr.length);
//                if(k!=-1)
//                    System.out.println(k + " i = " + i + " j = " +j);
//            }
//        }




    }
}
