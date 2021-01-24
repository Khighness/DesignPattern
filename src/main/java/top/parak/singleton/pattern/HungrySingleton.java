package top.parak.singleton.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.singeleton.pattern </p>
 * <p> FileName: HungrySingleton <p>
 * <p> Description: 饿汉式单例<p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/16
 */

/**
 * <p> 特点：
 * 类一旦加载就创建一个单例，保证在调用getInstance()之前单例就已经存在
 * </p>
 */

public class HungrySingleton {

    /* 在类加载时就创建一个静态对象供系统使用，以后不再改变，
    所以是线程安全的，可以直接用于多线程而不会出现问题 */

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }
}
