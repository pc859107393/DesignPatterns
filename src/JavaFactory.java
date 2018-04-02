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
        JavaFactory factory = new JavaFactory();
        factory.createCar(BaoNiu.class);
    }
}
