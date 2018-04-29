package Stack;

public class Array_Stack {
    private String[] arr;
    private int N = 0;
    public Array_Stack(){
        arr = new String[1];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void push(String s){
        if(N==arr.length){resize(N*2);}
        arr[N++] = s;
    }

    public String pop(){
            String item = arr[--N];
            arr[N] = null;
            if(N>0 && N==arr.length/4)resize(arr.length/2);
        /**
         * Смотри,как бы изначальная мысль переопределять массив,если заполнена только половина,
         * но это не есть хорошо,т.к. если в середине массива пользователь начнет делать push-pop-push-pop
         * то оно будет помтоянно переопределять массив,поэтому делим на четвертинки(если расписать,то это действительно кажется логичным
         */
        return item;
    }
    /**Т.е рофл в том,что ты увеличиваешь размер массива на два,если это необходимо,пропуская постоянные переопределения*/
    private void resize(int n){
        String[] arr2 = new String[n];
        for(int i = 0;i<arr.length;++i){
            arr2[i] = arr[i];
        }
        arr = arr2;
    }
    public static void main(String[] args){
        Array_Stack array_stack = new Array_Stack();
        for(int i = 0;i<10;++i){
            array_stack.push(Integer.toString(i));
        }
        System.out.println(array_stack.isEmpty());
        for(int i = 0;i<10;++i){
            System.out.println(array_stack.pop() + " ");
        }
    }
}
