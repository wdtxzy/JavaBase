import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : wangdi
 * @time : creat in 2019/3/24 13:18
 * Lock锁的使用
 */

class Res2 {
    public String userName;
    public String sex;
    //如果flag为true，消费者启动；为false，生产者启动
    public boolean flag = false;
    public Lock lock = new ReentrantLock();
}

class InputThread extends Thread {
    private Res2 res;
    int count = 0;
    Condition newCondition;

    public InputThread(Res2 res, Condition condition) {
        this.res = res;
        this.newCondition = condition;
    }

    @Override
    public void run() {

        while (true) {
            try {
                res.lock.lock();
                if (res.flag) {
                    try {
                        newCondition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (count == 0) {
                    res.userName = "David";
                    res.sex = "man";
                } else {
                    res.userName = "Linda";
                    res.sex = "woman";
                }
                count = (count + 1) % 2;
                res.flag = true;
                newCondition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                res.lock.unlock();
            }
        }
    }
}

class OutputThread extends Thread {
    private Res2 res;
    private Condition newCondition;

    public OutputThread(Res2 res, Condition newCondition) {
        this.res = res;
        this.newCondition = newCondition;
    }

    @Override
    public void run() {
        while (true) {
            try {
                res.lock.lock();
                if (!res.flag) {
                    try {
                        newCondition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.userName + "," + res.sex);
                res.flag = false;
                newCondition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                res.lock.unlock();
            }
        }
    }
}

public class ThreadDemo07 {

    public static void main(String[] args) {
        Res2 res = new Res2();
        Condition newCondition = res.lock.newCondition();
        InputThread inputThread = new InputThread(res, newCondition);
        OutputThread outputThread = new OutputThread(res, newCondition);
        inputThread.start();
        outputThread.start();
    }
}
