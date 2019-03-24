/**
 * @author : wangdi
 * @time : creat in 2019/3/24 11:05
 * 生产者，消费者
 */
class Res {
    public String userName;
    public String sex;
    //如果flag为true，消费者启动；为false，生产者启动
    public boolean flag = false;
}

class Input extends Thread {
    Res res;

    public Input(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        synchronized (res) {

            while (true) {
                if (res.flag) {
                    try {
                        res.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (count == 0) {
                    res.userName = "Tom";
                    res.sex = "man";
                } else {
                    res.userName = "Allen";
                    res.sex = "woman";
                }
                count = (count + 1) % 2;
                res.flag = true;
                res.notify();
            }
        }
    }
}

class OutPut extends Thread {
    Res res;

    public OutPut(Res res) {
        this.res = res;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (res) {
                if (!res.flag) {
                    try {
                        res.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                System.out.println(res.userName + "," + res.sex);
                res.flag = false;
                res.notify();
            }
        }
    }
}

public class ThreadDemo06 {

    public static void main(String[] args) {
        Res res = new Res();
        OutPut out = new OutPut(res);
        Input input = new Input(res);
        out.start();
        input.start();
    }
}
