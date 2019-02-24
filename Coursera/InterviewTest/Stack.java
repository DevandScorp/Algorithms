package InterviewTest;

public class Stack {
    private static class Node {
        String key;
        Node next;

        public Node(String key) {
            this.key = key;
        }
    }
    private static Node first;

    public static void push(String key){
        Node node = new Node(key);
        node.next = first;
        first = node;
    }
    public static String remove(){
        String data = first.key;
        first = first.next;
        return data;
    }
    public static void show(){
        Node copy = first;
        while(copy!=null){
            System.out.println(copy.key);
            copy = copy.next;
        }
    }

    public static void main(String[] args) {
        Stack.push("1");
        Stack.push("2");
        Stack.push("3");
        Stack.push("4");
        Stack.show();
        Stack.remove();
        System.out.println("__________________________________");
        Stack.show();
    }
}
