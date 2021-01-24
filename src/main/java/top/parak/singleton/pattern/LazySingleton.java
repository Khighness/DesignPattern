package top.parak.singleton.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.singeleton.pattern </p>
 * <p> FileName: LazySingleton <p>
 * <p> Description: 懒汉式单例 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/16
 */

/**
 * <p> 特点：
 * 类加载时没有生成单例，只有第一次调用getInstance方法时才会创建这个单例
 * </P>
 */
public class LazySingleton {

    /* volatile: 具有可见性、有序性，不具备原子性
    volatile声明变量的值可能随时会被其他线程修改，
    使用volatile修饰的变量会强制将修改的值立即写入主存，
    主存中值的更新会使缓存中的值失效。
    volatile不会让线程阻塞，响应速度比synchronized快 */

    // volatile保证instance在所有线程中同步可见
    private static volatile LazySingleton instance = null;

    // private避免类在外部被实例化
    private LazySingleton() {}

    // 加锁同步，保证getInstance()只能被一个线程调用
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
