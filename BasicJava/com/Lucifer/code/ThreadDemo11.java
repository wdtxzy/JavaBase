import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author : wangdi
 * @time : creat in 2019/3/24 21:52
 */
class Parent extends Thread{
    Semaphore wc;
    String name;
    public Parent(Semaphore wc, String name){
        this.wc = wc;
        this.name = name;
    }

    @Override
    public void run(){
        //获取到资源，减去1
        int avaliablePemits = wc.availablePermits();
        if(avaliablePemits>0){
            System.out.println(name+"还有茅坑");
        }else{
            System.out.println(name+"没有茅坑了");
        }
        try {
            wc.acquire();
            System.out.println("终于能上了");
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("用完茅坑了");
            wc.release();
        }catch (InterruptedException e){
            e.getStackTrace();
        }
    }
}
public class ThreadDemo11 {

    public static void main(String[] args)throws Exception {
        //最多支持多少个资源访问
        Semaphore semaphore = new Semaphore(3);
       for(int i=0;i<3;i++){
           new Parent(semaphore,"李明"+i).start();
       }
    }
}
