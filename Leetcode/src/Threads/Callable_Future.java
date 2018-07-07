package Threads;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Callable_Future {
    /**
     * Иногда нужно,чтобы поток возвращал какой-либо результат.
     * Для этой цели вместо Runnable используют Callable
     */
    public static class String_Return implements Callable<String>{
        private int id;

        public String_Return(int id) {
            this.id = id;
        }

        @Override
        public String call() throws Exception {
            return "This id is: "+ this.id;
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //тут вместо execute submit
        ArrayList<Future<String>> result = new ArrayList<>();
        for(int i = 0;i<5;++i){
            result.add(executorService.submit(new String_Return(i)));
        }
        for(Future<String> res: result){
            System.out.println(res.get());
        }
        //не забывай ЗАКРЫВАТЬ ПОТОКИ
        executorService.shutdown();
    }
}
