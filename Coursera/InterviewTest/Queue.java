package InterviewTest;

public class Queue {
    private static class Node {
        String key;
        Node next;

        public Node(String key) {
            this.key = key;
        }
    }
    private static Node first,last;

    public static void push(String key){
        Node oldLast = last;
        last = new Node(key);
        last.next = null;
        if(first==null) first = last;
        else {
            oldLast.next = last;
        }
    }
    public static String remove(){
        String item = first.key;
        first = first.next;
        if(first==null)last = null;
        return item;
    }
    public static void show(){
        Node copy = first;
        while(copy!=null){
            System.out.println(copy.key+" ");
            copy = copy.next;
        }
    }
    public static void main(String[] args) {
        Queue.push("1");
        Queue.push("2");
        Queue.push("3");
        Queue.push("4");
        Queue.show();
        Queue.remove();
        System.out.println("__________________________________");
        Queue.show();
    }
}
