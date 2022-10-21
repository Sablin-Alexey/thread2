import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final int countMyCallable = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Integer result = executorService.invokeAny(callableTasks(countMyCallable));
        System.out.println("Колличество сообщений" + result);
        executorService.shutdown();
    }
    public static List<Callable<Integer>> callableTasks(int countMyCallable) {
        List<Callable<Integer>> callableTasks = new ArrayList<>();
        for (int i = 1; i <= countMyCallable; i++) {
            MyCallable myCallable = new MyCallable(i);
            callableTasks.add(myCallable);
        }
        return callableTasks;
    }
}