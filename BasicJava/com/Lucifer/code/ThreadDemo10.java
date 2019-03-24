import java.util.concurrent.CyclicBarrier;

/**
 * @author : wangdi
 * @time : creat in 2019/3/24 21:43
 * CyclicBarrier的使用
 */
class Writer extends Thread{
    private CyclicBarrier cyclicBarrier;

    public Writer(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"开始写入数据");
        try {
            Thread.sleep(1000);
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+"写入数据成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class ThreadDemo10 {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for(int i=0;i<5;i++){
            new Writer(cyclicBarrier).start();
        }
    }
}
