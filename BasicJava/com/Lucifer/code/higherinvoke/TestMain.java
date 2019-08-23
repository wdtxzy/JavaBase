package higherinvoke;

/**
 * @Author : wangdi
 * @Date : create in 2019-08-22 21:26
 */
public class TestMain {

    public static void main(String[] args) {
        BaseService baseService = BeanFactory.getInstance(SmallInsect.class);
        baseService.eat();
    }
}
