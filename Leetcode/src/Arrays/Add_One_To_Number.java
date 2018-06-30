package Arrays;

import java.util.ArrayList;

public class Add_One_To_Number {
    public static ArrayList<Integer> plus_One_Bad_Solution(ArrayList<Integer> A) {
        int n = A.size()-1;
        int zero = 0;
        //находим количество нулей в массиве
        while(A.get(zero)== 0){
            if(++zero==A.size())break;
        }
        if(zero==A.size()){
            A.set(A.size()-1,1);
            return A;
        }
        try{
            for(int i = n;i>=zero;--i){
                if(A.get(i)>=9){
                    A.set(i,0);
                    A.set(i-1,A.get(i-1)+1);
                    if(A.get(i-1)>9)continue;
                    else break;
                }
                else{
                    A.set(i,A.get(i)+1);
                    break;
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            A.add(0,1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        zero = 0;
        while(A.get(zero)== 0){
            if(++zero==A.size())break;
        }
        for(int i = zero;i<A.size();++i){
            res.add(A.get(i));
        }
        return res;
    }
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A){
        int carry = 1;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = A.size()-1;i>=0;--i){
            int sum = (A.get(i)+carry);
            carry=0;
            if(sum==10){
                carry = 1;
                sum = 0;
            }
            A.set(i,sum);

        }
        if(carry==1)result.add(1);
        for(int i:A){
            if((i==0)&&(result.size()==0)){
                continue;
            }
            result.add(i);
        }
        return result;
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(0);
        a.add(0);
        a.add(6);
        a.add(4);
        a.add(9);
        a.add(9);
        a.add(9);
        a.add(9);
        System.out.println(plusOne(a).toString());
    }
}
