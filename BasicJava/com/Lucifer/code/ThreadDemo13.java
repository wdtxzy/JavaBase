import java.util.concurrent.*;

/**
 * @author : wangdi
 * @time : creat in 2019/3/25 15:25
 * 线程池的使用
 */
public class ThreadDemo13 {

    public static void main(String[] args) {
        //1.可缓存的线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            int temp = i;
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("threadName:"+Thread.currentThread().getName()+",i;"+temp);
                }
            });
        }

        //2.固定长度的线程池
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            int temp = i;
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("threadName:"+Thread.currentThread().getName()+",i;"+temp);
                }
            });
        }

        //3.可定时的线程池
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
        for(int i=0;i<10;i++){
            int temp = i;
            newScheduledThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("threadName:"+Thread.currentThread().getName()+",i;"+temp);
                }
            });
        }
    }
}

