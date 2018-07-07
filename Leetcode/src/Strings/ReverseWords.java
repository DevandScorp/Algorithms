package Strings;

public class ReverseWords {
    public String reverseWords(String a) {
        if(a==null)return null;
        String[] arr = a.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = arr.length-1;i>=0;--i){
            stringBuilder.append(arr[i]+" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        System.out.println(new ReverseWords().reverseWords("the sky is blue"));

    }
}
