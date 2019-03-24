/**
 * @author : wangdi
 * @time : creat in 2019/3/24 13:59
 */
class StopThreadDemo extends Thread{
    private volatile boolean flag = true;

    @Override
    public void run(){
        while (flag){
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
                stopThread();
            }
            System.out.println("线程在运行");

        }
    }

    public void stopThread(){
        this.flag = false;
    }
}
public class ThreadDemo08 {

    public static void main(String[] args) {
        StopThreadDemo stopThreadDemo = new StopThreadDemo();
        stopThreadDemo.start();
        for(int i=0;i<6;i++){
            try {
                Thread.sleep(1000);
                System.out.println("i"+i);
                if(i==8){
                    stopThreadDemo.interrupt();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
