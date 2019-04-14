import java.util.concurrent.*;

/**
 * @author : wangdi
 * @time : creat in 2019/4/10 15:14
 */
public class CallableDemo01 implements Callable<String> {

    @Override
    public String call() throws Exception{
        System.out.println("asdasdas");
        return "Callable";
    }


    public static void main(String[] args) throws Exception{
        ExecutorService exec= Executors.newCachedThreadPool();
        Future task = exec.submit(new CallableDemo01());
        System.out.println(task.get());

    }
}
