/**
 * @author : wangdi
 * @time : creat in 2019/3/26 10:24
 * 工厂模式
 */
interface Car {

    void run();
}

class Audi implements Car {
    @Override
    public void run() {
        System.out.println("我是奥迪汽车");
    }
}

class Bens implements Car {
    @Override
    public void run() {
        System.out.println("我是奔驰汽车");
    }
}

class CarFactory {

    public Car creatcar(String name) {
        Car car = null;
        switch (name) {
            case "奥迪":
                car = new Audi();
                break;
            case "奔驰":
                car = new Bens();
                break;
            default:
                break;
        }
        return car;
    }
}

class BensFactory{
    public static Car creatCar(){
        return new Bens();
    }
}

class AudiFactory{
    public static Car creatCar(){
        return new Audi();
    }
}

public class FactoryModel {
    public static void main(String[] args) {
        String name1 = "奔驰";
        String name2 = "奥迪";
        CarFactory carFactory = new CarFactory();
        Car benc = carFactory.creatcar(name1);
        Car audi = carFactory.creatcar(name2);
        benc.run();
        audi.run();
    }
}
