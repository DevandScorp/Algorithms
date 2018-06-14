package Hash_Table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Hash_Tables<Key,Value> {
    /**
     *
     * Кластеризация (или кластерный анализ) — это задача разбиения множества объектов на группы,
     * называемые кластерами. Внутри каждой группы должны оказаться «похожие» объекты,
     * а объекты разных группы должны быть как можно более отличны.
     * Главное отличие кластеризации от классификации состоит в том,
     * что перечень групп четко не задан и определяется в процессе работы алгоритма.
     * Алгоритм в этом файле-это Separate Chaining
     * +:
     *      -Легче реализовать удаление
     *      -Выполение ухудшается не так стремительно(вежливо)
     *      -Кластеризация менее чувствительна к плохо написанной хеш-функции
     *
     */
    private int M;//размр хеш-таблицы
    private static class Node {
        private Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val,Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    private Node[] st;
    public Hash_Tables(int M) {
        st = new Node[M];
        for(int i = 0;i<M;++i){
            st[i] = new Node(i,"",null);
        }
        this.M = M;
    }

    /**
     * Хеш-функция преобразует ключи в индексы массива
     * @param key
     * @return
     */
    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff)%M;//для того,чтобы не выходить за границы массива
    }

    /**
     * если ты просто будешь запихивать в массив новые ключи,то они могут повторяться,
     * и для поиска нужных понадобится квадартичное время.Поэтому у тебя для каждого ключа
     * просто добавляется новая ссылка
     * arr[i]->a->b->c...
     * И главное-ХЕШИРУЮТСЯ КЛЮЧИ,А НЕ ИНДЕКСЫ МАССИВА
     * @param key
     * @return
     */
    public Value get(Key key){
        int i = hash(key);
        for(Node x = st[i];x!=null;x = x.next){
            if(key.equals(x.key)){return (Value)x.val;}
        }
        return null;
    }

    /**
     * Т.е. смотри,ты нашел по хешу ключа,а потом прошелся по связному списку и переименовал нужное значение
     * или создал новое
     * @param key
     * @param value
     */
    public void put(Key key,Value value){
        int i = hash(key);
        for(Node x = st[i];x!=null;x = x.next){
            if(key.equals(x.key)){x.val = value;return;}
            st[i] = new Node(key,value,st[i]);
        }
    }
    public static void main(String[] args){
        Hash_Tables<Integer,String> hash_tables = new Hash_Tables<>(20);
        /**
         * Т.е. ключи разные,они просто хранятся как связные списки с хешами
         */
        Random r = new Random();
        for(int i = 0;i<20;++i){
            hash_tables.put(i,"Value: " + i);
        }
        hash_tables.put(20,"Another one");
        hash_tables.put(30,"Second one");
        for(int i = 0;i<20;++i){
            System.out.println(hash_tables.get(i));
        }
        System.out.println(hash_tables.get(20));
        System.out.println(hash_tables.get(30));
    }
}
