package Red_Black_Trees;

import java.util.Random;

public class RBT<Key extends Comparable<Key>,Value> {
    /**
     * 2lgN - удаление
     * Небольшое вступление:
     * По сути-это то же самое бинарное дерево,но здесь есть красные ребра графа
     * (они связывают между собой якобы двойные ключи,а есть обычные черные ребра)
     * поиск идентичный,ведь это все то же бинарное дерево
     * и каждый элемент имеет одинаковое количество черных ребер до корня
     * (поэтому эти деревья быстрее)
     * все красные ребра находятся слева,поэтому нужен специальный метод,который их туда смещает
     * и смотри,получается так,что по одной стороне у левого элемента красного ребра находятся элементы <,<=
     * а справа от правого элемента красного ребра- >
     */
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    private class Node {
        Key key;
        Value value;
        Node left,right;
        boolean color;
        public Node(Key key, Value value,boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }
    private boolean isRed(Node x){
        if(x == null)return false;
        return x.color == RED;
    }
    public Value get(Key key){
        Node x = root;
        while(x!=null){
            int cmp = key.compareTo(x.key);
            if(cmp<0)x = x.left;
            else if(cmp>0)x = x.right;
            else return x.value;
        }
        return null;
    }
    /**Метод для смещения красных ребер влево*/
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    /**Метод,который иногда будет нам необходим*/
    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    /**
     * Высота дерева будет стабильно <2lgn
     * Case 1:Insert a 2-node at the bottom
     * 1)Do standard BST insert;color new link red;
     * 2)If new red link is a right link,rotate left
     * Case 2:Insert into a three-node at the bottom
     * 1)Do standart BST insert;color new link red;
     * 2)Rotate to balance the 4-node(if needed)
     * 3)Flip colors to pass red link up one level
     * 4)Rotate to make lean(наклон) left
     * Repeat case 1or case 2 if needed
     * Same code handles all case:
     * Right child red,left child black:rotate left;
     * Left child,left-left grandchild red:rotate right;
     * Both children red: flip colors;
     */
    private Node put(Node h,Key key,Value value){
        if(h==null)return new Node(key,value,RED);
        int cmp = key.compareTo(h.key);
        if(cmp<0)h.left = put(h.left,key,value);
        else if(cmp>0)h.right = put(h.right,key,value);
        else h.value = value;
        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left))h = rotateRight(h);
        if(isRed(h.left)&&isRed(h.right))flipColors(h);
        return h;
    }
    public void put(Key key,Value value){
        root = put(root,key,value);
        root.color = BLACK;
    }
    private Node balance(Node h){
        if(isRed(h.right))h = rotateLeft(h);
        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left))h = rotateRight(h);
        if(isRed(h.left)&&isRed(h.right))flipColors(h);
        return h;
    }
    private Node min(Node node){
        if(node.left == null)return node;
        return min(node.left);
    }
    private Node deleteMin(Node h){
        if(h.left==null)return null;
        if(!isRed(h.left) && !isRed(h.left.left))h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
    }
    private Node moveRedLeft(Node h){
        flipColors(h);
        if(isRed(h.right.left)){
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }
    private Node moveRedRight(Node h){
        flipColors(h);
        if(!isRed(h.left.left))h = rotateRight(h);
        return h;
    }
    private Node delete(Node node,Key key){
        if(key.compareTo(node.key)<0){
            if(!isRed(node.left) && !isRed(node.left.left))node = moveRedLeft(node);
                node.left = delete(node.left,key);
            }
            else {
                if(isRed(node.left)) node = rotateRight(node);
                if(key.compareTo(node.key)==0 && (node.right==null))return null;
                if(!isRed(node.right) && !isRed(node.right.left))node = moveRedRight(node);
                if(key.compareTo(node.key)==0){
                    node.value = get(min(node.right).key);
                    node.key = min(node.right).key;
                    node.right = deleteMin(node.right);
                }
                else node.right = delete(node.right,key);
            }
            return balance(node);
    }
    private boolean isEmpty(){return root==null;}
    public void delete(Key key){
        if(!isRed(root.left) && !isRed(root.right))root.color = RED;
        root = delete(root,key);
        if(!isEmpty())root.color = BLACK;

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
    public static void main(String[] args){
        RBT<Integer,String> bns = new RBT<>();
        Random r = new Random();
        for(int i = 0;i<10;++i){
            int a = r.nextInt(100);
            System.out.print(a + " ");
            bns.put(a,i+"-ый");
        }
        System.out.println("Now it is sorted");
        bns.show();
        bns.put(0,"нулевой");
        System.out.println("____________________________________");
        bns.show();
        bns.delete(0);
        System.out.println("____________________________________");
        bns.show();
    }
}
