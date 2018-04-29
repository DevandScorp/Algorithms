package dynamic_union;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //int n = Integer.parseInt(reader.readLine());
        String s;
        QuickFindUF qf = new QuickFindUF(10);
        for(int i = 0;i<10;++i) {
            try {
                s = reader.readLine();
                String[] arr = s.split(" ");
                int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[1]);
                //System.out.println(a + " " + b);
                if(qf.connected(a,b))continue;
                qf.union(a,b);
            }catch(Exception e){
                break;
            }
        }
        System.out.println(qf.find(2));
        System.out.println("connections: " + qf.getCount());

        reader.close();
    }
}
