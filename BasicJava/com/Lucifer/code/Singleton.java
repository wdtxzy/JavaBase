/**
 * @author : wangdi
 * @time : creat in 2019/3/26 10:13
 * 单例模式
 */
//懒汉式 需要调用的时候才会创建对象
class SingletonFotTest{
    private static SingletonFotTest singletonFotTest;
    private SingletonFotTest(){

    }

     public static SingletonFotTest getInstance() {
        if(singletonFotTest == null){
            synchronized (SingletonFotTest.class){
                if(singletonFotTest == null){
                    singletonFotTest = new SingletonFotTest();
                }
            }
        }
        return singletonFotTest;
    }
}

//饿汉式
class SingletonForTest02{
    private static SingletonForTest02 singleton = new SingletonForTest02();
    private SingletonForTest02(){

    }
    public static SingletonForTest02 getInstance() {
        return singleton;
    }
}
public class Singleton {
}
