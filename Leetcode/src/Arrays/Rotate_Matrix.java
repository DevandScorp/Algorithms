package Arrays;

import java.util.ArrayList;
import java.util.Random;

public class Rotate_Matrix {
    public void rotate(ArrayList<ArrayList<Integer>> A) {

            // To get this we need to find Transpose of matrix then reverse each
            // list

        int n = A.size();
        for (int i = 0; i < n; i++) {
            /**
             * Нужно начинать с едиинцы,т.к. у тебя диагонлаьные элементы будут свапаться обратно
             */
            for (int j = i + 1; j < n; j++) {
                int temp = A.get(i).get(j);
                A.get(i).set(j, A.get(j).get(i));
                // A[i][j]=A[j][i];
                A.get(j).set(i, temp);
                // A[j][i]=temp;
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = A.get(j).get(i);
                A.get(j).set(i, A.get(j).get(n - i - 1));
                // A[j][i] = A[j][n - i - 1];
                A.get(j).set(n - i - 1, tmp);
                // A[j][n - i - 1] = tmp;
            }
        }

    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        Random r  = new Random();
        for(int i = 0;i<2;++i){
            ArrayList<Integer> m = new ArrayList<>();
            for(int j = 0;j<2;++j){
                m.add(r.nextInt(20));
            }
            a.add(m);
        }
        for(ArrayList<Integer> arrayList:a){
            System.out.println(arrayList.toString());
        }
        System.out.println("_____________________________________________");
        new Rotate_Matrix().rotate(a);
//        System.out.println("Rotated");
//        for(ArrayList<Integer> arrayList:a){
//            System.out.println(arrayList.toString());
//        }
    }
}
