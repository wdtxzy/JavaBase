import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : wangdi
 * @time : creat in 2019/3/24 23:08
 */
class ProducerThread extends Thread{
    private BlockingDeque queue;
    private volatile boolean flag = true;
    private static AtomicInteger count = new AtomicInteger();
    ProducerThread(BlockingDeque blockingDeque){
        this.queue = blockingDeque;
    }
    @Override
    public void run(){
        try {
            while (flag){
                System.out.println("正在生产数据");
                String data = count.incrementAndGet()+"";
                boolean offer = queue.offer(data);
                if(offer){
                    System.out.println("生产者添加队列"+data+"成功！");
                }else {
                    System.out.println("生产者添加队列"+data+"失败！");
                }
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("生产者停止");
        }

    }
}

class ConsumerThread extends Thread{
    private BlockingDeque blockingDeque;
    private volatile boolean flag = true;

    ConsumerThread(BlockingDeque blockingDeque){
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run(){
        System.out.println("消费者成功启动");
        try {
            while (flag){
                String data = (String)blockingDeque.poll(2, TimeUnit.SECONDS);
                if(data != null){
                    System.out.println("消费者消费"+data+"成功！");
                }else {
                    System.out.println("消费者消费失败！");
                    this.flag = false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("消费者停止");
        }
    }

}
public class ThreadDemo12 {
}
