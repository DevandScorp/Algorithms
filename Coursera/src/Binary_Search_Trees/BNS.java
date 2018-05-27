package Binary_Search_Trees;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class BNS<Key extends Comparable<Key>,Value> {
    private class Node {
        private Key key;
        private Value value;
        private Node left,right;
        private int count;//количество поддеревьев
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node root;
    public BNS(Key key,Value value){
        root = new Node(key,value);
    }
    private Node min(Node node){
        if(node.left == null)return node;
        return min(node.left);
    }
    public void deleteMin(){root = deleteMin(root);}
    private Node deleteMin(Node node){
        if(node.left == null) return node.right;//идем,пока не находим нулевую левую ссылку
        //если нашли-заменяем на правую ветку(т.к. слева уже ничего нет,а значит отец тих двух поддеревьев и есть
        //наименьший элемент
        node.left = deleteMin(node.left);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }
    public Key_Queue<Key> keys(){
        Key_Queue<Key> q = new Key_Queue<Key>();
        inorder(root,q);
        return q;

    }
    private void show(Node node){
        if(node!=null){
            show(node.left);
            System.out.println(node.key + ": " + node.value);
            show(node.right);
        }
    }
    public void show(){
        show(root);
    }
    private void inorder(Node x,Key_Queue<Key> q){
        if(x==null) return;
        inorder(x.left,q);
        q.enqueue(x.key);
        inorder(x.right,q);
    }
    /**
     * Для того,чтобы определить,сколько ключей,меньших k
     * @param key
     * @return
     */
    public int rank(Key key){
        return rank(key,root);
    }
    private int rank(Key key,Node x){
        if(x == null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp<0) return rank(key,x.left);
        else if(cmp > 0) return 1 + size(x.left) + rank(key,x.right);
        else return size(x.left);/** ты же возвращаешь количетсов ключей,меньших k
         */
    }
    public int size(){
        return size(root);
    }
    private int size(Node x){
        if(x==null) return 0;
        return x.count;
    }
    public void put(Key key,Value value){
        root = put(root,key,value);
    }
    private Node put(Node node,Key key,Value value){
        if(node == null)return new Node(key,value);
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            node.left = put(node.left,key,value);
        }
        else if(cmp>0){
            node.right = put(node.right,key,value);
        }
        else{
            node.value = value;
        }
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }
    public Key floor(Key key){
        Node x = floor(root,key);
        if(x==null) return null;
        return x.key;
    }
    private Node floor(Node x,Key key){
        if(x==null)return null;
        int cmp = key.compareTo(x.key);
        if(cmp==0) return x;
        if(cmp<0) return floor(x.left,key);
        Node t = floor(x.right,key);
        if(t!=null) return t;
        return x;
    }
    public Value get(Key key){
        Node x = root;
        while(x!=null){
            int cmp = key.compareTo(x.key);
            if(cmp<0)x = root.left;
            else if(cmp>0)x = root.right;
            else return x.value;
        }
        return null;
    }
    public void delete(Key key){
        root = delete(root,key);
    }
    private Node delete(Node x,Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp<0) x.left = delete(x.left,key);
        else if(cmp > 0) x.right = delete(x.right,key);
        else{
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;
            Node t = x;
            x = min(t.right);//наименьший правый элемент
            x.right = deleteMin(t.right);//присваиваем правому наименьший
            x.left = t.left;


        }
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }
    public static void main(String[] args){
        BNS<Integer,String> bns = new BNS<>(0,"0-ой");
        Random r = new Random();
        for(int i = 0;i<10;++i){
            int a = r.nextInt(100);
            System.out.println(a);
            bns.put(a,a+"-ый");
        }
        System.out.println("Now it is sorted");
        bns.show();
    }
}
