/**
 * @author : wangdi
 * @time : creat in 2019/3/23 17:04
 * volatile的用法
 */
class ThreadVolatileDemo extends Thread {

    private boolean flag = true;

    @Override
    public void run() {
        System.out.println("子线程开始执行。。。");
        while (flag) {
            System.out.println("子线程的while在执行");
        }
        System.out.println("子线程执行结束。。。");
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

public class ThreadDemo04 {

    public static void main(String[] args) {
        ThreadVolatileDemo threadVolatileDemo = new ThreadVolatileDemo();
        threadVolatileDemo.start();
        //如果不加volatile线程中的flag的值不会变的
        threadVolatileDemo.setFlag(false);
    }
}
