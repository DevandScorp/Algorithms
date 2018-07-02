package Arrays;

import java.util.ArrayList;

public class Pascal_Triangle {
//   public ArrayList<ArrayList<Integer>> generate(int A) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//        if(A <= 0)return result;
//        for(int i = 0;i<A;++i){
//            result.add(new ArrayList<>());
//        }
//        result.get(0).add(1);
//        for(int i = 1;i<A;++i){
//            result.get(i).add(1);
//            for(int j = 1;j<i;++j){
//                result.get(i).add(result.get(i-1).get(j)+result.get(i-1).get(j-1));
//            }
//            result.get(i).add(1);
//        }
//        return result;
//    }
    public ArrayList<ArrayList<Integer>> generate(int A) {
        int numRows = A;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (A == 0)
            return res;
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            res.add(new ArrayList<>());
            res.get(i).add(1);
            for (int j = 0; j < i - 1; j++) {
                int num = res.get(i - 1).get(j) + res.get(i - 1).get(j + 1);
                res.get(i).add(num);
            }
            res.get(i).add(1);
        }
        return res;
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> result = new Pascal_Triangle().generate(0);
        for(ArrayList<Integer> integers:result){
            System.out.println(integers.toString());
        }
    }
}
