package Priority_Queue;

public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    public UnorderedMaxPQ(int capacity){
        pq = (Key[])new Comparable[capacity];
    }
    /**
     * вставка и удаление будут работать за log(N)
     * Для минимальной очереди просто поменяй less на greater
     *
     * Proposition:largest key is a[1],which is root of a binary tree.
     * Proposition:
     * Parent of node at k is at k/2;
     * Children of node at k are at 2k and 2k+1
     * 				 T(1)
     * 				/    \
     * 			   /      \
     * 			 S(2)    R(3)
     * 			/ \         /\
     * 		   /   \	   /  \
     * 		P(4)   N(5)	 O(6) A(7)
     * 	   /\         /\
     * 	  /  \		 /  \
     * 	E(8)  I(9) H(10) G(11)
     *  ________________________________
     * 	1)Scenario:Child's key becomes larger key than it's parent key;
     * 	To eliminate(устранить) this violation(нарушение):
     * 	Exchange key in child with key in parent
     * 	Repeat until heap order restored
     * 	________________________________
     * 	2)Scenario
     * 	Parent's key becomes smaller than one (or both) of it's children
     * 	To eliminate this violation
     * 	Exchange key in parent with  key in larger child(вполне логично,ведь справа находится больший элемент,
     * 	а значит свапнув с правым,ты не нарушишь иерархию)
     * 	Repeat until heap order restored
     * 	________________________________
     * 	Basic plan for in-place sort
     * 	1)Create max-heap with all N keys(сделал кучу-максимум)
     * 	2)Repeatedly remove the maximum key(просто удалять из него максимальные элементы)
     *
     */
    private Key[] pq;
    private int N;

    /**
     * Метод для прохождения по дереву и установки больших элементов выше
     * А точно ли будет работать,если значение больше корня?
     * swim-для добавления
     */
    private void swim(int k){
        while(k>1 && less(k/2,k)){
            swap(pq,k,k/2);
            k/=2;
        }
    }

    /***
     * sink-для удаления
     * @param k
     */
    private void sink(int k){
        while(2*k<=N){
            int j = 2*k;/**Переходим к детям*/
            if(j<N && less(j,j+1))j++;/**Находим правого сына*/
            if(!less(k,j))break;/**Если он больше-ломаем программу*/
            swap(pq,k,j);/**или свапаем,если все нормально*/
            k = j;/**Идем дальше*/
        }
    }

    private static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<=0;
    }
    private static void swap(Comparable[] a,int i,int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public boolean isEmpty(){return N == 0;}
    public void insert(Key x){
        pq[++N]=x;/**Инкремент из-за необходимотис сделать a[1] корнем*/
        swim(N);
    }
    public Key delMax(){
        Key max = pq[1];/**Наибольщим элементом является корень*/
        swap(pq,1,N--);/**Свапаем с последним элементом*/
        sink(1);/**Тонем,начиная с первого*/
        pq[N+1] = null;
        return max;

    }
}
