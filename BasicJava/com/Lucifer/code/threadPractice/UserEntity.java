package threadPractice;

/**
 * @author : wangdi
 * @time : creat in 2019/3/22 23:41
 */
public class UserEntity {

    private String userid;
    private String username;

    public String getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    UserEntity(String userid,String username){
        this.userid = userid;
        this.username = username;
    }

}
