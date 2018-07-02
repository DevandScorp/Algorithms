package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spiral_Order {
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        /**
         * У нас всегда есть четыре крайних точки:лево,право,верх,низ.
         */
        int top = 0,bottom = A.size()-1,left = 0,right = A.get(0).size()-1;
        int direction = 0;
        /**
         * 0 - вправо
         * 1 - вниз
         * 2 - влево
         * 3 - вправо
         */
        while(top<=bottom && left<=right){
            if(direction==0){
                for(int i = left;i<=right;++i)
                    result.add(A.get(top).get(i));
                ++top;
                direction = 1;
            }
            else if(direction == 1){
                for(int i = top;i<=bottom;++i){
                    result.add(A.get(i).get(right));
                }
                --right;
                direction = 2;
            }
            else if(direction==2){
                for(int i = right;i>=left;--i){
                    result.add(A.get(bottom).get(i));
                }
                --bottom;
                direction = 3;
            }
            else if(direction==3){
                for(int i = bottom;i>=top;--i){
                    result.add(A.get(i).get(left));
                }
                ++left;
                direction = 0;
            }
        }
        return result;
    }
    public static void main(String[] args){
        List<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> row;
        Random r = new Random();
        for(int i = 0;i<5;++i){
            row = new ArrayList<>();
            for(int j = 0;j<5;++j)
            row.add(r.nextInt(10));
            A.add(row);
        }
        for(ArrayList<Integer> rows : A){
            System.out.println(rows.toString());
        }
        ArrayList<Integer> arrayList = new Spiral_Order().spiralOrder(A);
        System.out.println(arrayList.toString());
        System.out.println(arrayList.size());
    }
}
