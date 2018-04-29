package dynamic_union;

public class QuickFindUF {
    private int[] id;
    private int[] size;
    private int[] max;
    private int count;
    public QuickFindUF(int n){
        id = new int[n];
        size = new int[n];
        max = new int[n];
        for(int i = 0;i<n;++i){
            id[i] = i;
            size[i] = 1;
            max[i] = i;
        }
        count = n;
    }

    public int getCount() {
        return count;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }
    private int root(int i){
        while(i!=id[i]){
            id[i] = id[id[i]];
            i = id[i];/*урезаем проход на половину*/
        }
        return i;
    }

    /**
     * Hint: maintain an extra array to the weighted quick-union
     * data structure that stores for each root i the large element
     * in the connected component containing i;
     * @param i
     * @return
     */
    public int find(int i){
        return max[root(i)];
    }
    public void union(int a,int b){
        int r2 = root(b);
        int r1 = root(a);
        int maxA = max[r1];
        int maxB = max[r2];
        if(r1==r2) return;
        if(size[r1]<size[r2]){
            id[r1] = r2;
            if(maxB<maxA){
                max[r2] = maxA;
            }
            size[r2]+=size[r1];
        }
        else{
            id[r2] = r1;
            if(maxA<maxB){
                max[r1] = maxB;
            }
            size[r1]+=size[r2];
        }
        count--;
    }
}
