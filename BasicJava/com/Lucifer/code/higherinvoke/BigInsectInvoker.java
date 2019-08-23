package higherinvoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author : wangdi
 * @Date : create in 2019-08-22 20:22
 */
public class BigInsectInvoker implements InvocationHandler {

    private BaseService smallInsect;

    public  BigInsectInvoker(BaseService smallInsect){
        this.smallInsect = smallInsect;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(smallInsect, args);
        bigInsectEat();
        return null;
    }

    private void bigInsectEat(){
        System.out.println("螳螂捕蝉");
    }
}
