package Arrays;
import java.util.*;

public class Wave_Array {
        public ArrayList<Integer> wave(ArrayList<Integer> a) {
            Collections.sort(a);
            for(int i = 0; i < a.size() - 1; i = i + 2) {
                int temp = a.get(i);
                a.set(i, a.get(i + 1));
                a.set(i+1, temp);
            }
            return a;
        }

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>();
        Random r = new Random();

        for(int i = 0;i<9;++i){
            a.add(r.nextInt(20));
        }
//        a.add(1);a.add(2);a.add(3);a.add(4);
        System.out.println(a.toString());
        System.out.println(new Wave_Array().wave(a).toString());
    }
}
