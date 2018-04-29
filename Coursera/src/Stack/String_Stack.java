package Stack;
/**Работают быстрее,чем массивы как операции,но общее время больше,чем у массивов*/
public class String_Stack {
    private Node first = null;
    private class Node{
        String data;
        Node next;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public void push(String data){
        Node oldfirst = new Node();
        oldfirst.data = data;
        oldfirst.next = first;
        first = oldfirst;
    }

    /**
     * Для того,чтобы избежать проблем с массивами,удаленному элементу присваивай нулевую ссылку
     *
     * @return
     */
    public String pop(){
        String item = first.data;
        first = first.next;
        return item;
    }
    public void show(){
        while(first!=null){
            System.out.print(first.data+ " ");
            first = first.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        String_Stack string_stack = new String_Stack();
        for(int i = 0;i<10;++i){
            string_stack.push(Integer.toString(i));
        }
        string_stack.pop();
        System.out.println(string_stack.isEmpty());
        string_stack.show();
    }

}
