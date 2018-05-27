package Binary_Search_Trees;

public class Key_Queue<Key extends Comparable<Key>> {
        private Node first,last;
        private class Node {
            Key item;
            Node next;
        }
        public boolean isEmpty(){
            return first == null;
        }
        public void enqueue(Key item){
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if(isEmpty())first = last;
            else{
                oldLast.next = last;
            }
        }
        public void print(){
            Node copy = first;
            while(copy!=null){
                System.out.println(copy.item+" ");
                copy = copy.next;
            }
        }
        public Key dequeue(){
            Key item = first.item;
            first = first.next;
            if(isEmpty())last = null;
            return item;
        }
}
