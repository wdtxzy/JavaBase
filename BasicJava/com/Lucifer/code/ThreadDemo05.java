/**
 * @author : wangdi
 * @time : creat in 2019/3/23 17:30
 * AtomicInteger
 */
class AtomicInteger extends Thread {

    //需要10个线程共享count，static修饰关键字，存放在景台区，只会放一次，线程共享
    private static int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
        System.out.println(getName() + "," + count);
    }
}

public class ThreadDemo05 {
    public static void main(String[] args) {
        AtomicInteger[] atomicIntegers = new AtomicInteger[10];
        for (int i = 0; i < atomicIntegers.length; i++) {
            atomicIntegers[i] = new AtomicInteger();
        }
        for (AtomicInteger atmoic : atomicIntegers) {
            atmoic.start();
        }
    }
}
