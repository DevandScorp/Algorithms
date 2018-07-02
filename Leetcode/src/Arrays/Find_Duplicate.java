package Arrays;

import java.util.*;

public class Find_Duplicate {
    public int repeatedNumber(final List<Integer> a) {
        int[] count = new int[a.size()];
        for(int i=0;i<a.size();i++)
        {
            count[a.get(i)]++;
            if(count[a.get(i)] > 1)
                return a.get(i);
        }
        return -1;
    }
    public static void main(String[] args){

    }
}
