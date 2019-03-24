import java.util.concurrent.CountDownLatch;

/**
 * @author : wangdi
 * @time : creat in 2019/3/24 21:28
 * countDownLatch的使用
 */
public class ThreadDemo09 {

    public static void main(String[] args)throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是子线程，开始执行任务");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.getStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("我是子线程，开始执行任务");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是子线程2，开始执行任务");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.getStackTrace();
                }
                System.out.println("我是子线程2，开始执行任务");
                countDownLatch.countDown();
            }
        }).start();
        countDownLatch.await();//如果不为0的时候，一直等待
        System.out.println("主线程开始执行任务");
        for(int i=0;i<10;i++){
            System.out.println("main i:"+i);
        }
    }
}
