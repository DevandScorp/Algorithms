public class Buddy_Strings {
    /**
     * Given two strings A and B of lowercase letters,
     * return true if and only if we can swap two letters
     * in A so that the result equals B.
     * Алгоритм имеет сложность O(f(n)),
     * если при увеличении размерности входных данных N,
     * время выполнения алгоритма возрастает с той же скоростью, что и функция f(N).
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean is_buddy(String a,String b){
        if(a.length()!=b.length())return false;
        if(a.equals(b)){
            int[] count = new int[26];
            for(int i = 0;i<a.length();++i){
                count[a.charAt(i)-'a']++;
            }
            for(int c: count){ if(c>1)return true; }
            return false;

        }
        else {
            int first = -1,second  = -1;
            for(int i = 0;i<a.length();++i){
                if(a.charAt(i)!=b.charAt(i)){
                    if(first==-1)first=i;
                    else if(second==-1)second=i;
                    else return false;
                }
            }
            return (second!=-1 && a.charAt(first)==b.charAt(second) && a.charAt(second)==b.charAt(first));
        }
    }

    /**
     * Сложность этого алгоритма равна O(N).
     * Все константные операции - О(1).(и даже,если они в цикле-нам все равно похер)
     *     int a = 0, b = 0;
     *         for (i = 0; i < N; i++) {
     *             a = a + rand();
     *         }
     *         for (j = 0; j < M; j++) {
     *             b = b + rand();
     *         }
     * Assume that rand() is O(1) time, O(1) space function.
     * O(g(n))={f(n):exist c and n0,f(n)<=c*g(n),n>=n0}
     * O(f(n))-upper-bound of the algorithm
     * омега-нотация-это такое омега от g(n) = {f(n):c and n0 exists,c*g(n)<=f(n),n>=n0}-это lower bound
     * Тета-нотация(кружок с волной)-это {f(n):c1,c2 and n0,c1*g(n)<=f(n)<=c2*g(n)}
     * Если у нас есть условный оператор с различными сложностями,то мы выбираем наихудший случай
     *
     * @param args
     */
    public static void main(String[] args){
        System.out.println(is_buddy("ab","ba"));
        System.out.println(is_buddy("ab","ab"));
        System.out.println(is_buddy("aa","aa"));
        System.out.println(is_buddy("aaaaaaabc","aaaaaaacb"));
        System.out.println(is_buddy("","aa"));
    }
}
