package Queue;

public class String_Queue {
    private Node first,last;
    private class Node {
        String item;
        Node next;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void enqueue(String item){
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
    public String dequeue(){
        String item = first.item;
        first = first.next;
        if(isEmpty())last = null;
        return item;
    }
}
