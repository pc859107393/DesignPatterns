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

