package Hash_Table;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

public class Sparse_Vector {
    private HashMap<Integer,Double> hashMap;

    public Sparse_Vector() {
        this.hashMap = new HashMap<>();
    }
    public void put(int i,double x){
        hashMap.put(i,x);
    }
    public double get(int i){
        if(!hashMap.containsKey(i))return 0.0;
        else return hashMap.get(i);
    }
    public double dot(double[] that){
        double sum = 0.0;
        for(int i : hashMap.keySet()){
            sum+=that[i]*this.get(i);
        }
        return sum;
    }
    public void swap(double[] a,int i,int j){
        double m = a[i];
        a[i] = a[j];
        a[j] = m;
    }

    @Override
    public String toString() {
        StringBuilder  stringBuilder = new StringBuilder();
        for(Integer key : hashMap.keySet()){
            stringBuilder.append(hashMap.get(key)+" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        Sparse_Vector[] a = new Sparse_Vector[10];
        for(int i = 0;i<10;++i){
            a[i] = new Sparse_Vector();
        }
        Random r = new Random();
        double[] x = new double[10];
        double[] b = new double[10];
        for(int i = 0;i<10;++i){
            for(int j = 0;j<10;++j){
                a[i].put(j,r.nextInt(10));
            }
            System.out.println(a[i].toString());
        }
        for(int i = 0;i<10;++i){
            x[i] = r.nextInt(10);
            System.out.print(x[i] + " ");
        }
        System.out.println();
        for(int i = 0;i<10;++i){
            b[i] = a[i].dot(x);
            System.out.print(b[i] + " ");
        }
    }
}
