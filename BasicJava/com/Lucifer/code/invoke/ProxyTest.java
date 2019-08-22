package invoke;

/**
 * @Author : wangdi
 * @Date : create in 2019-08-22 16:03
 */
public class ProxyTest {

    public static void main(String[] args) {
        DriveCar driveCar = ProxyFactory.newInstance();
        driveCar.drive("浦项中心");
    }
}
