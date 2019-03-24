/**
 * @author : wangdi
 * @time : creat in 2019/3/21 22:22
 * 继承Thread类实现创建线程
 * 实现Runnable接口实现创建线程
 * 匿名内部类创建线程
 */
class CreateThreadDemo01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            //getId()获取当前线程ID，线程ID是唯一的，固定的
            System.out.println(getId() + "执行了Thread线程" + i + "次");
        }
    }
}

class CreateThreadDemo02 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            //Thread.currentThread().getId()可以获取到主线程Id
            //Thread.currentThread().getName()可以获取到主线程名称
            System.out.println(Thread.currentThread().getId() + "执行了Runable线程" + i + "次");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }

        }
    }
}


public class ThreadDemo01 extends Throwable {

    public static void main(String[] args) {
        CreateThreadDemo01 createThreadDemo01 = new CreateThreadDemo01();
        createThreadDemo01.start();
        CreateThreadDemo02 createThreadDemo02 = new CreateThreadDemo02();
        Thread thread = new Thread(createThreadDemo02);
        thread.start();

        Thread createThreadDemo03 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println("执行了匿名内部类线程" + i + "次");
                }
            }
        });
        createThreadDemo03.start();
    }
}
