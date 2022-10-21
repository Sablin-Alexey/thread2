import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

class MyCallable implements Callable<Integer> {
    private int id;
    final private int MESSAGE = 5;
    final private int SLEEP = 200;

    public MyCallable(int id) {
        this.id = id;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        try {
            for (int i = 1; i <= MESSAGE; i++) {
                TimeUnit.MILLISECONDS.sleep(SLEEP);
                System.out.println("Я поток " + Thread.currentThread().getName() + ". Всем привет!");
                count++;
            }
        } catch (InterruptedException e) {

        }
        return count;
    }
}