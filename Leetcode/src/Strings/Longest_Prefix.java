package Strings;


import java.util.ArrayList;

public class Longest_Prefix {
    public String longestCommonPrefix(ArrayList<String> A) {
        int count = 0;
        boolean isCount = true;
        int min_len = A.get(0).length();
        for(String a : A){
            if(a.length()<min_len)min_len = a.length();
        }
        while (isCount && count<min_len) {
            char a = A.get(0).charAt(count);
            for (int i = 1; i < A.size(); ++i) {
                if(A.get(i).charAt(count)!=a){
                    isCount = false;
                    break;
                }
            }
            if(isCount)++count;
        }
        return A.get(0).substring(0,count);
    }
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        list.add("abcdefgh");list.add("abghijk");list.add("abcefgh");
        System.out.println(new Longest_Prefix().longestCommonPrefix(list));
    }
}
