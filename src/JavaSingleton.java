/**
 * Java的单例
 * @author cheng
 */
public class JavaSingleton {

    //私有化对象，赋值为null实现延迟加载，对标kotlin中的 lateinit var
    private static JavaSingleton instance = null;

    //私有化类，防止被实例化( new )
    private JavaSingleton(){

    }

    //实例化，加锁保证线程安全,如果不考虑线程安全则去掉 synchronized
    public synchronized static JavaSingleton getInstance() {
        if (instance == null) {
                instance = new JavaSingleton();
        }
        return instance;
    }
}