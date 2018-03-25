/**
 * Java的单例
 *
 * @author cheng
 */
public class JavaSingleton {

    //私有化对象，赋值为null实现延迟加载，对标kotlin中的 lateinit var
    //一个变量如果用volatile修饰了，则Java可以确保所有线程看到这个变量的值是一致的，
    // 如果某个线程对volatile修饰的共享变量进行更新，那么其他线程可以立马看到这个更新，这就是所谓的线程可见性。
    private static volatile JavaSingleton instance = null;

    //私有化类，防止被实例化( new )
    private JavaSingleton() {

    }

    //实例化，加锁保证线程安全,如果不考虑线程安全则去掉 synchronized
    //1.改进：并不需要每次都加锁来判断，我们可以确认没有实例化再加锁
    //2.改进：当我们程序同时需要实例化这个对象的时候，A->Syn-> new且B-> syn -> new，所以需要双重检查
    public static JavaSingleton getInstance() {
        if (instance == null)
            synchronized (JavaSingleton.class) {
                if (instance == null)
                    instance = new JavaSingleton();
            }

        return instance;
    }
}