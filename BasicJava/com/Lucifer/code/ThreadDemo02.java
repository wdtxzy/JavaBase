
/**
 * @author : wangdi
 * @time : creat in 2019/3/22 22:50
 */
public class ThreadDemo02 {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 60; i++) {
                    System.out.println("子线程，i"+i);
                }
            }
        });
        thread.start();
        try {
            //等待其他线程执行完，再继续执行
            thread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        for (int i=0;i<30;i++){
            System.out.println("主线程，i"+i);
        }

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 60; i++) {
                    System.out.println("子线程t1，i"+i);
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 60; i++) {
                    try {
                        t1.join();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("子线程t2，i"+i);
                }
            }
        });
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 60; i++) {
                    try {
                        t2.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程t3，i" + i);
                }
            }
        });
        t3.start();
    }
}
