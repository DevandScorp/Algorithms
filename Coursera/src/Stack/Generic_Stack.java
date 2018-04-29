package Stack;

import java.util.Iterator;

public class Generic_Stack<T> {
    private Node first = null;
    private class Node{
        T data;
        Node next;
    }
    /*** Итераторы */
    public Iterator<T> iterator(){return new List_T_Iterator();}
    private class List_T_Iterator implements Iterator<T> {
        private Node current = first;
        public Node getCurrent() {
            return current;
        }

        @Override
        public boolean hasNext() {return current == null;}
        @Override
        public T next() {
            T t = current.data;
            current = current.next;
            return t;
        }
    }
    public boolean isEmpty(){return first==null;}
    public void push(T data){
        Node oldfirst = new Node();
        oldfirst.data = data;
        oldfirst.next = first;
        first = oldfirst;
    }
    /*** Для того,чтобы избежать проблем с массивами,удаленному элементу присваивай нулевую ссылку*/
    public T pop(){
        T item = first.data;
        first = first.next;
        return item;
    }
    public void show(){
        Node copy = first;
        while(copy!=null){
            System.out.print(copy.data+ " ");
            copy = copy.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        /**Generic не прокатят с массивами,т.к. Java запрещает создавать массивы из generic
         * Вообще можно конечно сделать Generic Object,а потом приводить типы массива,но это плохо*/

        Generic_Stack<Integer> string_stack = new Generic_Stack<>();
        for(int i = 0;i<11;++i){
            string_stack.push(i);
        }
        System.out.println(string_stack.isEmpty());
        string_stack.show();
        string_stack.pop();
    }
}
