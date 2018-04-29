package dynamic_union;

public class UF {
    /**@param N инициализация узлов с целочисленными именами(от 0 до n-1)
     *
     * */
    private int[] id;/**доступ к идентификатору компонента(индексация узлами)*/
    private int count;/**количество компонентов*/
    public UF(int N){
        count = N;
        id = new int[N];
        for(int i = 0;i<N;++i){
            id[i] = i;
        }

    }
    /**@return добавляет соединение между элементами*/
    public void union(int p,int q){

    }
    /**идентификатор компоненат для p*/
    public int find(int p){
        return 0;
    }
    /** есть ли соединение*/
    public boolean connected(int p,int q){
        return this.find(p)==this.find(q);
    }
    /**Количество компонентов*/
    public int count(){
        return count;
    }
}
