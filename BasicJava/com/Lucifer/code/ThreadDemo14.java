import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : wangdi
 * @time : creat in 2019/3/25 18:18
 * 重入锁与非重入锁
 */
public class ThreadDemo14 extends Thread{

    private Lock lock = new ReentrantLock();
    public void get(){
        lock.lock();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId()+",get");
        set();
    }

    public void set(){
        lock.lock();
        try {
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId()+",set");
    }

    @Override
    public void run(){
        get();
    }

    public static void main(String[] args) {
        ThreadDemo14 thread = new ThreadDemo14();
        new Thread(thread).start();
        new Thread(thread).start();
        new Thread(thread).start();
        new Thread(thread).start();
    }
}
