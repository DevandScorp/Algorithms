package Hash_Table;

public class LinearProbingHash<Key,Value> {
    /**
     * -Меньше затраченного времени
     * -Лучшее исполнение для кеша
     * Which is the main reason to use a hash table instead of a red–black BST?
     * better performance in practice on typical inputs
     * С помощью Symbol tables
     */
    private int M = 30;
    private Value[] vals = (Value[])new Object[M];
    private Key[] keys = (Key[])new Object[M];
    private int size = 0;
    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff)%M;//для того,чтобы не выходить за границы массива
    }
    private boolean checkValiditry(){
        for(Key key:keys){
            if(key==null)return true;
        }
        return false;
    }
    public void put(Key key,Value val){
        int i;

        for(i = hash(key);keys[i]!=null;i = (i+1)%M){
            if(keys[i].equals(key))break;
        }
        keys[i] = key;
        vals[i] = val;
    }
    public Value get(Key key){
        for(int i = hash(key);keys[i]!=null;i = (i+1)%M){
            if(key.equals(keys[i]))return vals[i];

        }
        return null;
    }
    public static void main(String[] args){
        LinearProbingHash<Integer,String> linearProbingHash = new LinearProbingHash<>();
        for(int i = 0;i<30;++i){
            linearProbingHash.put(i,"Value: " + i);
        }
//        linearProbingHash.put(20,"Another one");
//        linearProbingHash.put(30,"Second one");
        for(int i = 0;i<30;++i){
            System.out.println(linearProbingHash.get(i));
        }
//        System.out.println(linearProbingHash.get(20));
//        System.out.println(linearProbingHash.get(30));
    }
}
