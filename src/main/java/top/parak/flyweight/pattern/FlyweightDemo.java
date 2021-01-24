package top.parak.flyweight.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.flyweight.pattern </p>
 * <p> FileName: Flyweight <p>
 * <p> Description: 享元模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/19
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

import java.util.HashMap;

/**
 * <P>测试类</P>
 */
public class FlyweightDemo {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight f1 = factory.getFlyweight("K");
        Flyweight f2 = factory.getFlyweight("H");
        Flyweight f3 = factory.getFlyweight("I");
        Flyweight f4 = factory.getFlyweight("G");
        Flyweight f5 = factory.getFlyweight("H");
        f1.operation(new UnsharedConcreteFlyweight("第一次调用K"));
        f2.operation(new UnsharedConcreteFlyweight("第一次调用H"));
        f3.operation(new UnsharedConcreteFlyweight("第一次调用I"));
        f4.operation(new UnsharedConcreteFlyweight("第一次调用G"));
        f5.operation(new UnsharedConcreteFlyweight("第二次调用H"));
    }
}

/**
 * <p>
 *     非享元角色
 * </p>
 */
@AllArgsConstructor
@Setter
@Getter
class UnsharedConcreteFlyweight {
    private String info;
}

/**
 * <p>
 *     抽象享元角色
 * </p>
 */
interface Flyweight {
    public void operation(UnsharedConcreteFlyweight concreteFlyweight);
}

/**
 * <p>
 *     具体享元角色
 * </p>
 */
class ConcreteFlyweight implements Flyweight {
    private Logger log = Logger.getLogger(ConcreteFlyweight.class);
    private String key;
    public ConcreteFlyweight(String key) {
        this.key = key;
        log.info("具体享元" + key + "被创建");
    }

    @Override
    public void operation(UnsharedConcreteFlyweight concreteFlyweight) {
        log.info("具体享元" + key + "被调用");
        log.info("非享元信息是：" + concreteFlyweight.getInfo());
    }
}

/**
 * <p>
 *     享元工厂角色
 * </p>
 */
class FlyweightFactory {
    private Logger log = Logger.getLogger(FlyweightFactory.class);
    private HashMap<String, Flyweight> flyweightMap = new HashMap<String, Flyweight>();
    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = (Flyweight) flyweightMap.get(key);
        if (flyweight != null) {
            log.info("具体享元" + key + "已经存在，被成功获取！");
        } else {
            flyweight = new ConcreteFlyweight(key);
            flyweightMap.put(key, flyweight);
        }
        return flyweight;
    }
}