package Strings;

public class StrStr {
    public int strStr(final String A, final String B) {
        if (A.length() == 0 || B.length() == 0 || B.length() > A.length()) {
            return -1;
        }
        int size = B.length();
        for (int i = 0; i <= A.length() - size; i++) {
            String str = A.substring(i, i + size);
            if (str.equals(B)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(new StrStr().strStr("","HelloWorld"));
    }
}
