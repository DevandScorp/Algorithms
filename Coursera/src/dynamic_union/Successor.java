package dynamic_union;

import java.io.IOException;

public class Successor {
    private boolean nums[];
    public Successor(int n){
        nums = new boolean[n];
        for(int i = 0;i<n;++i){
            nums[i] = true;
        }
    }
    public void remove(int x) throws IOException {
        if(x>=nums.length)throw new IOException("No way to remove this");
        nums[x] = false;
    }
    public int successor(int x)throws IOException {
        if (x >= nums.length) throw new IOException("No way to remove this");
        int y = x;
        while(true){
            if(++y>=x && y<nums.length && nums[y]){
                return y;
            }
            else if( y>=nums.length){
                return x;
            }
        }
    }
    public static void main(String[] args){
        try {
            Successor test = new Successor(10);
            test.remove(2);
            System.out.println(test.successor(2) == 3);
            test.remove(3);
            System.out.println(test.successor(2) == 4);
            System.out.println(test.successor(8) == 8);
            test.remove(8);
            System.out.println(test.successor(8) == 9);
            test.remove(9);
            System.out.println(test.successor(8) == -1);
            test.remove(5);
            test.remove(4);
            System.out.println(test.successor(3) == 6);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
