package top.parak.singleton.example;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.singeleton.example </p>
 * <p> FileName: PresidentSingleton <p>
 * <p> Description: 懒汉式单例模式模拟产生美国当今总统对象 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/16
 */

import org.apache.log4j.Logger;

/**
 * <p> 分析：
 * 在每一届任期内，美国的总统只有一人，所以适合用单例模式实现
 * </p>
 */
public class PresidentSingleton {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(PresidentSingleton.class);
        President zt1 = President.getInstance();
        zt1.getName();
        President zt2 = President.getInstance();
        zt2.getName();
        if (zt1 == zt2) {
            log.info("他们是同一个人");
        } else {
            log.info("他们不是同一人");
        }
    }
}

@SuppressWarnings("all")
class President {
    private static Logger log = Logger.getLogger(President.class);
    private static String name;
    private static volatile President instance = null;
    private President(String name) {
        this.setName(name);
        log.info("产生一个总统！");
    }
    public void setName(String name) {
        this.name = name;
    }
    public void getName() {
        log.info("美国总统：" + this.name);
    }
    public static synchronized President getInstance() {
        if (instance == null) {
            instance = new President("特朗普");
        } else {
            log.info("已经存在一个总统，不能产生新总统！");
        }
        return instance;
    }
}
