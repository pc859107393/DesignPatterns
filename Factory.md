在没有工厂以前，我们想要个什么东西都要自己去创建，如下：
```java
    public void createCar(){
        System.out.println("自己去创建一个汽车，所以有了福特大叔");
    }
```

当然，如果人人都是福特大叔的话，世界上的汽车就会变得廉价，但是其他的东西就会变的昂贵，所以注定很多人需要做其他的事情，他们需要汽车只能找这些“福特大叔”制造，就产生了简单的工厂模式。

```java
    /**
     * 在有个一些"福特大叔"后，我们做其他事情的人，只有找这些"福特大叔"造车车。
     */
    class BaoNiu {
        public BaoNiu() {
            System.out.println("我生产了一个宝牛汽车！");
        }
    }

    class HanNiu {
        public HanNiu() {
            System.out.println("我生产了一个汗牛汽车！");
        }
    }

    public Object createCar(Class clazz) {
        if (clazz.getName().equals(BaoNiu.class.getName())) return new BaoNiu();
        else if (clazz.getName().equals(HanNiu.class.getName())) return new HanNiu();
        else return null;
    }

    public static void main(String[] args) {
        //这样我们就能定制到一台宝牛汽车了
        JavaFactory factory = new JavaFactory();
        factory.createCar(BaoNiu.class);
    }
```

但是我们需求是在不断增加的时候，客户也不关心是什么工厂了，客户只知道他们要什么汽车，然后统一交给工厂处理，所以有了下面的工厂方法模式：

```java

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
        factory.createCar();
    }

    /**
     * 生产汽车的人或者机构随着需求的变大，就产生了，所以我们有个进一步的工厂了<br/>
     * 我们工厂下面有一些工作车间，但是对外他们都是工厂，所以我们不管内部，只需要指明是什么汽车
     */
    abstract class CarFactory {
        public abstract void createCar();
    }
```

紧接着可能某个工厂经营不善，被另一个工厂吞并了，所以就产生了不同的工作车间，也就有个抽象工厂模式。

但是不同的工作车间都是生产汽车的，甚至同样的汽车车间生产的汽车也有不同型号的，所以这里我们需要对工厂和汽车都进行抽象。

```java
/**
 * Java工厂模式
 *
 * @author cheng
 */
public class JavaFactory {

    /**
     * 这个宝牛汽车有自己的特性
     */
    static class BaoNiu implements CarModel {
        private String model;

        @Override
        public void say() {
            System.out.println(this.model);
        }

        @Override
        public void setModel(String model) {
            this.model = model;
        }
    }

    /**
     * 汗牛汽车跟其他的汽车也是不一样
     */
    static class HanNiu implements CarModel {
        private String model;

        @Override
        public void say() {
            System.out.println(this.model);
        }

        @Override
        public void setModel(String model) {
            this.model = model;
        }
    }

    /**
     * 则是抽象的汽车模型
     */
    interface CarModel {
        public void say();

        public void setModel(String model);
    }

    /**
     * 产生了大规模的工厂，面很有不同的车间，生产不同的汽车
     */
    public abstract static class AbstractFactory {
        /**
         * 宝牛车间
         *
         * @return
         */
        public abstract CarModel createBaoNiuCar();

        /**
         * 汗牛车间
         *
         * @return
         */
        public abstract CarModel createHanNiuCar();
    }

    /**
     * 工厂生产不同的汽车，同样的汽车也有不同的属性
     */
    public static class CarFactory extends AbstractFactory {

        @Override
        public BaoNiu createBaoNiuCar() {
            return new BaoNiu();
        }

        @Override
        public HanNiu createHanNiuCar() {
            return new HanNiu();
        }
    }

    public static void main(String[] args) {
        AbstractFactory factory = new CarFactory();
        CarModel car1 = factory.createBaoNiuCar();
        car1.setModel("我是宝牛品牌汽车，产自CarFactory，实现了自己的特性");
        car1.say();

        CarModel car2 = factory.createHanNiuCar();
        car2.setModel("我是汗牛汽车，我和上面的不一样");
        car2.say();
    }
}
```

就这样，我们就实现了一个工厂下面不同的车间生产了不同的汽车，同时同样的车间生产的同一个牌子的汽车也不一样。