public class Reverse_Integer {
//
    public static int reverse(int x){
        int rev = 0;
        while(x!=0){
            int ost = x%10;
            x/=10;
            if(rev>Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && ost>7))return 0;
            if(rev<Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && ost <-8))return 0;
            rev = rev*10+ost;
        }
        return rev;
    }
    public static void main(String[] args){
        System.out.println(reverse(-123));
        System.out.println(reverse(12001));
        System.out.println(reverse(-214748364));
    }
}
