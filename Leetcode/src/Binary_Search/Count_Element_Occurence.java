package Binary_Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Count_Element_Occurence {
    public static final boolean LESS = true;
    public static final boolean GREATER = false;
    int get_Index(final List<Integer> A, int B,boolean searchFirst){
        int low = 0,high = A.size()-1;
        int result = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(A.get(mid)==B){
                if(searchFirst)high = mid-1;
                else low = mid+1;
                result = mid;
            }
            else if(B>A.get(mid)) low = mid+1;
            else high = mid-1;
        }
        return result;
    }
    public int findCount(final List<Integer> A, int B) {
        if(get_Index(A,B,false)==-1)return 0;
        return get_Index(A,B,GREATER) - get_Index(A,B,LESS)+1;
    }
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        for(int i = 0;i<10;++i){
            list.add(r.nextInt(10));
        }
        Collections.sort(list);
        System.out.println(list.toString());
        System.out.println(new Count_Element_Occurence().findCount(list,8));
    }
}
