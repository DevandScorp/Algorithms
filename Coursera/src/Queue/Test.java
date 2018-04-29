package Queue;

public class Test {
    public static void main(String[] args){
//        String_Queue string_queue = new String_Queue();
//        for(int i = 0;i<10;++i){
//            string_queue.enqueue(i + "-ый элемент");
//        }
//        string_queue.print();
//        System.out.println("__________________________________________");
//        for(int i = 0;i<10;++i){
//            System.out.println(string_queue.dequeue()+" ");
//        }
        Array_Queue array_queue = new Array_Queue();
        for(int i = 0;i<10;++i){
            array_queue.enqueue(i + "-ый элемент");
        }

        array_queue.print();
        System.out.println("____________________________________________");
        for(int i = 0;i<10;++i){
            System.out.println(array_queue.deque()+" ");
        }
        array_queue.enqueue("11");
        System.out.println("____________________________________________");
        array_queue.print();
    }
}
