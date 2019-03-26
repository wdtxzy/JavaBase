import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : wangdi
 * @time : creat in 2019/3/26 10:47
 * 代理模式
 */
interface House{
    void buy();
}

class Buyer implements House{
    @Override
    public void buy(){
        System.out.println("buy a house");
    }
}

//jdk动态代理
class JdkProxy implements InvocationHandler{
    private Object target;
    public JdkProxy(Object oj){
        this.target = oj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是中介，买房交给我");
        Object invoke = method.invoke(target,args);
        System.out.println("我是中介，买房结束了");
        return invoke;
    }
}

//静态代理
class Proxy implements House{
    private Buyer buyer;
    public Proxy(Buyer buyer){
        this.buyer = buyer;
    }

    @Override
    public void buy(){
        System.out.println("我是中介，你买房开始交给我了");
         buyer.buy();
        System.out.println("我是中介，买房结束了");
    }
}
public class StaticProxy {

    public static void main(String[] args) {
        House house = new Proxy(new Buyer());
        house.buy();
        JdkProxy jdkProxy = new JdkProxy(new Buyer());
        House house2 = (House) java.lang.reflect.Proxy.newProxyInstance(Buyer.class.getClassLoader(),Buyer.class.getInterfaces(),jdkProxy);
        house2.buy();
    }
}
