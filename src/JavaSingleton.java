public class JavaSingleton {
 
    private static JavaSingleton instance = null;
 
    private JavaSingleton(){

    }
 
    public synchronized static JavaSingleton getInstance() {
        if (instance == null) {
                instance = new JavaSingleton();
        }
        return instance;
    }
}