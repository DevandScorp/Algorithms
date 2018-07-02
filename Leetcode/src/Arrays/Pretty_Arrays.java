package Arrays;

import java.util.ArrayList;

public class Pretty_Arrays {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        int size = 1 + 2*(A-1);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i = 0;i<size;++i){
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int j = 0;j<size;++j)arrayList.add(0);
            arr.add(arrayList);
        }
        int top=0,left = 0,bottom = size-1,right = size-1;
        int direction = 0;
        int num = A;
        while(top<=bottom && left<=right){
            if(direction==0){
                for(int i = left;i<=right;++i){
                    arr.get(top).set(i,num);
                }
                ++top;
                direction++;
            }
            if(direction==1){
                for(int j = top;j<=bottom;++j){
                    arr.get(j).set(right,num);
                }
                --right;
                ++direction;
            }
            if(direction==2){
                for(int i = right;i>=left;--i){
                    arr.get(bottom).set(i,num);
                }
                ++direction;
                --bottom;
            }
            if(direction==3){
                for(int i = bottom;i>=top;--i){
                    arr.get(i).set(left,num);
                }
                direction = 0;
                ++left;
            }
            --num;
        }
        return arr;
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> arrayLists = new Pretty_Arrays().prettyPrint(1);
        for(ArrayList<Integer> arrayList:arrayLists){
            System.out.println(arrayList.toString());
        }
    }
}
