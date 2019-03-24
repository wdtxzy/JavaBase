/**
 * @author : wangdi
 * @time : creat in 2019/3/23 00:16
 * 线程安全，模拟两个人抢票
 */
class ThreadTrain implements Runnable {
    private int train1Count = 100;

    @Override
    public void run() {
        while (train1Count > 0) {
            try {
                Thread.sleep(50);
                sale();
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }

    private synchronized void sale() {
        if (train1Count > 0) {
            System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - train1Count + 1) + "票");
            train1Count--;
        }
    }
}


public class ThreadDemo03 {

    public static void main(String[] args) {
        ThreadTrain threadTrain = new ThreadTrain();
        Thread thread1 = new Thread(threadTrain, "窗口1");
        Thread thread2 = new Thread(threadTrain, "窗口2");
        thread1.start();
        thread2.start();
    }
}
