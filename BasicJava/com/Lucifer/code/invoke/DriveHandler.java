package invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author : wangdi
 * @Date : create in 2019-08-22 15:28
 */
public class DriveHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();
        if (methodName.equals("drive")){
            startCar();
            System.out.println("method");
            stopCar();
        }

        return null;
    }

    private void startCar(){
        System.out.println("car start");
    }

    private void stopCar(){
        System.out.println("car stop");
    }


}
