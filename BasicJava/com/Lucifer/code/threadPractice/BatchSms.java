package threadPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wangdi
 * @time : creat in 2019/3/22 23:50
 * 利用多线程发送短信
 */

class UserSendThread implements Runnable {
    private List<UserEntity> list;

    public UserSendThread(List<UserEntity> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (UserEntity userEntity : list) {
            System.out.println(Thread.currentThread().getName() + "," + userEntity.getUsername());
        }
    }
}

public class BatchSms {

    public static void main(String[] args) {
        List<UserEntity> list = initUser();
        int userCount = 2;
        List<List<UserEntity>> splitList = ListUtil.splitList(list, userCount);
        for (int i = 0; i < splitList.size(); i++) {
            List<UserEntity> userList = splitList.get(i);
            UserSendThread userSendThread = new UserSendThread(list);
            Thread thread = new Thread(userSendThread, "线程" + i);
            thread.start();
        }
    }

    private static List<UserEntity> initUser() {
        List<UserEntity> list = new ArrayList<>();
        for (int i = 0; i <= 11; i++) {
            list.add(new UserEntity("userId" + i, "username" + i));
        }
        return list;
    }
}


