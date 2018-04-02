/**
 * Java工厂模式
 *
 * @author cheng
 */
public class JavaFactory {
    /**
     * 没有工厂模式，自己创建汽车，自己就成了"福特大叔"
     */
    public void createCar() {
        System.out.println("自己去创建一个汽车，所以有了福特大叔");
    }


    /**
     * 现在客户量上来了，然后就有了专门的工厂来接单生产，客户只关心他们所要的
     */
    class BaoNiu extends CarFactory {
        @Override
        public void createCar() {
            System.out.println("我生产了一个宝牛汽车！");
        }
    }

    class HanNiu extends CarFactory {
        @Override
        public void createCar() {
            System.out.println("我生产了一个汗牛汽车！");
        }
    }

    public CarFactory initFactory(Class clazz) {
        if (clazz.getName().equals(BaoNiu.class.getName())) return new BaoNiu();
        else if (clazz.getName().equals(HanNiu.class.getName())) return new HanNiu();
        else return null;
    }

    public static void main(String[] args) {
        JavaFactory factory = new JavaFactory();
        factory.initFactory(BaoNiu.class);
        //因为这个工厂可能找不到你要生产的类型，所以必须判断不能为空
        factory.createCar();
    }

    /**
     * 生产汽车的人或者机构随着需求的变大，就产生了，所以我们有个进一步的工厂了<br/>
     * 我们工厂下面有一些工作车间，但是对外他们都是工厂，所以我们不管内部，只需要指明是什么汽车
     */
    abstract class CarFactory {
        public abstract void createCar();
    }
}

