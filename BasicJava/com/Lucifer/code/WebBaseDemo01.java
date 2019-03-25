import java.lang.reflect.Field;

/**
 * @author : wangdi
 * @time : creat in 2019/3/25 22:40
 * Java反射机制
 */
public class WebBaseDemo01 {
    public static void main(String[] args)throws Exception {
        User user = new User();
        Class<?> forName = Class.forName("User");
        User classUser = (User) forName.newInstance();
        classUser.setId(1);
        System.out.println(classUser);
        Field[] declaredField = forName.getDeclaredFields();
        for(Field field : declaredField){
            System.out.println(field);
        }
    }
}
