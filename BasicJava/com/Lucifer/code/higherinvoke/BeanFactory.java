package higherinvoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author : wangdi
 * @Date : create in 2019-08-22 20:44
 */
public class BeanFactory {

    public static BaseService getInstance(Class classFile){

        //真实的蝉
        BaseService smallInsect = new SmallInsect();

        //真实的螳螂
        InvocationHandler bigInsect = new BigInsectInvoker(smallInsect);

        Class classArray[] = {BaseService.class};
        BaseService proxy1 = (BaseService) Proxy.newProxyInstance(classFile.getClassLoader(), classArray, bigInsect);
        return proxy1;
    }
}
