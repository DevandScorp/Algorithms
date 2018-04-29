package Queue;

public class Array_Queue {
     private String[] arr;
     private int size,tail,head;
     public Array_Queue(){
         tail = head = size = 0;
         arr = new String[1];
     }
     public void enqueue(String item){
        if(arr.length==size)resize(size*2);
        arr[tail++]=item;
        ++size;
     }
     boolean isEmpty(){
         return head==tail;
     }
     public String deque(){
         String item = arr[head];
         arr[head++] = null;
        if(head>0 && size==arr.length/4)resize(arr.length/2);
        return item;
     }
     public void print(){
        for(int i = head;i<tail;++i){
            System.out.println(arr[i]);
        }
     }
     private void resize(int n){
         String[] arr_2 = new String[n];
         for(int i = 0;i<arr.length;++i){
             arr_2[i] = arr[i];
         }
         arr = arr_2;
     }
}
