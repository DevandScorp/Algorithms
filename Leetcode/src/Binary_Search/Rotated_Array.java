package Binary_Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Rotated_Array {
    /**
     * [1,2,3,4,5,6,7,8,9]
     * [7,8,9,1,2,3,4,5,6]
     * Тут три случая
     * @param a
     * @return
     */
    public int findMin(final List<Integer> a) {
        int low = 0,high = a.size()-1;
        while(low<=high){
            if(a.get(low)<=a.get(high))return a.get(low);//очевидно,что если массив не перевернут,то он отсортирован
            int mid = low + (high-low)/2;
            int prev = (mid+a.size()-1)%a.size();//зачем остаток от деления?Если этот элемент будет последним,то он автоматически станет первым
            int next = (mid+1)%a.size();
            if(a.get(mid)<=a.get(prev)&& a.get(mid)<=a.get(next))return a.get(mid);//т.к. минимальный элемент будет находиться
            //между двумя элементами,которые будут <= ему.
            else if(a.get(mid)<=a.get(high))high = mid-1;
            else if(a.get(mid)>=a.get(low))low = mid+1;

        }
        return -1;
    }
    public static void main(String[] args){
    }
}
