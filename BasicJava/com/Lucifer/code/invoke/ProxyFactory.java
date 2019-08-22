package invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author : wangdi
 * @Date : create in 2019-08-22 15:34
 */
public class ProxyFactory {

    public static DriveCar newInstance(){
        InvocationHandler driveHandler = new DriveHandler();
        Class clazs[] = {DriveCar.class};
        DriveCar driveCar = (DriveCar) Proxy.newProxyInstance(DriveCar.class.getClassLoader(),clazs,driveHandler);
        return driveCar;
    }
}
