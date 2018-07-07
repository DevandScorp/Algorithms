package Strings;

public class Longest_palindrome {
    public String longestPalindrome(String A) {
        if(A == null || A.length() == 0) return "";
        int n = A.length();
        boolean [][] dp = new boolean[n][n];
        int maxLength = 1;
        String palindrome = A.substring(0, 1);
        for(int i=0; i<n; i++) {
            dp[i][i] = true;
            //тут ты находишь первый палиндром
            if(i+1 < n && A.charAt(i) == A.charAt(i+1)) {
                dp[i][i+1] = true;
                if(2 > maxLength) {
                    palindrome = A.substring(i, i+2);//тут тоже нужно на один больше,т.к. тут же подстрока
                    maxLength = 2;
                }
            }
        }
        for(int l=3; l <= n; l++) {
            for(int start=0; start<n; start++) {
                int end = start+l-1;
                if(end < n) {
                    if(A.charAt(start) == A.charAt(end) && dp[start+1][end-1]) {
                        //возможно,булевский массив здесь необходим для того,чтобы чекать предыдущие палиндромы
                        //и тогда очевидно,что следующий элемент тоже можно считать верным.
                        //и если длина этого промежутка больше,то меняем и присваиваем палиндрому новую строку.
                        dp[start][end] = true;
                        if(end-start+1 > maxLength) {
                            maxLength = end-start+1;//Тут определенно нужно добавить
                            palindrome = A.substring(start, end+1);
                        }
                    }
                }
            }
        }
        return palindrome;
    }
    public String long_Palindrom(String a){
        if(a==null || a.length()==1)return a;
        int n = a.length();
        int maxLength=1;
        boolean[][] dp = new boolean[n][n];
        String palindrom = a.substring(0,1);
        for(int i = 0;i<n;++i){
            dp[i][i]=true;//заполняем по диагонали.Очевидно,что элементы с одинаковыми индексами равны
            if(i+1<n && a.charAt(i)==a.charAt(i+1)){
                dp[i][i+1]=true;//все палиндромы с двумя последовательными символами
                if(2>maxLength){
                    maxLength = 2;
                    palindrom = a.substring(i,i+2);
                }
            }
        }
        for(int l = 3;l<=n;++l){
            for(int start = 0;start<n;++start){
                int end = start+l-1;
                if(end<n){
                    if(a.charAt(start)==a.charAt(end) && dp[start+1][end-1]){
                        dp[start][end]=true;
                        if(end-start+1>maxLength){
                            maxLength = end-start+1;
                            palindrom = a.substring(start,end+1);
                        }
                    }
                }
            }
        }
        return palindrom;
    }
    public static void main(String[] args){
        System.out.println(new Longest_palindrome().longestPalindrome("aaaabaaa"));
        System.out.println(new Longest_palindrome().long_Palindrom("aaaabaaa"));
    }
}
