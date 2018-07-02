package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SetMatrixZeros {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int m = a.get(0).size();
        boolean fColZero = false;
        boolean fRowZero = false;
        /**
         * Булевские переменные для определения того,имеются ли нули в первом столбце,строке
         */
        for(int i = 0; i < n; i++) {
            if (a.get(i).get(0).intValue() == 0) {
                fColZero = true;
                break;
            }
        }
        for(int i = 0; i < m; i++) {
            if (a.get(0).get(i).intValue() == 0) {
                fRowZero = true;
                break;
            }
        }
        //ставим в начале следующей строки 0
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a.get(i).get(j).intValue() == 0) {
                    a.get(i).set(0, 0);
                    break;
                }
            }
        }
        //ставим в начале следующего столбца ноль
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(a.get(j).get(i).intValue() == 0) {
                    a.get(0).set(i, 0);
                    break;
                }
            }
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if (a.get(0).get(j).intValue() == 0
                        || a.get(i).get(0).intValue() == 0) a.get(i).set(j, 0);
            }
        }
        if(fColZero) {
            for(int i = 0; i < n; i++) {
                a.get(i).set(0, 0);
            }
        }
        if(fRowZero) {
            for(int i = 0; i < m; i++) {
                a.get(0).set(i, 0);
            }
        }
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        Random r = new Random();
        for(int i = 0;i<2;++i){
            a.add(new ArrayList<>());
//            for(int j = 0;j<2;++j){
//                a.get(i).add(r.nextInt(2));
//            }
        }
        a.get(0).add(0);a.get(0).add(0);
        a.get(1).add(1);a.get(1).add(1);
        for(ArrayList<Integer> arrayList : a){
            System.out.println(arrayList.toString());
        }
        new SetMatrixZeros().setZeroes(a);
        System.out.println();
        for(ArrayList<Integer> arrayList : a){
            System.out.println(arrayList.toString());
        }
    }
}
