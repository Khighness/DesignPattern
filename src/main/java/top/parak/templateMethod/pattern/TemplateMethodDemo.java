package top.parak.templateMethod.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.templateMethod.pattern </p>
 * <p> FileName: TemplateMethodDemo <p>
 * <p> Description: 模板方法 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/7
 */

import org.apache.log4j.Logger;

/**
 * <p>测试类</p>
 */
public class TemplateMethodDemo {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }
}

/**
 * <P>
 *     抽象类
 * </P>
 */
abstract class AbstractClass {
    private Logger log = Logger.getLogger(AbstractClass.class);

    /* 模板方法 */
    public void templateMethod() {
        specificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    /* 具体方法 */
    public void specificMethod() {
        log.info("具体方法被调用");
    }

    /* 抽象方法1 */
    public abstract void abstractMethod1();
    /* 抽象方法2 */
    public abstract void abstractMethod2();
}

class ConcreteClass extends AbstractClass {
    private Logger log = Logger.getLogger(ConcreteClass.class);

    @Override
    public void abstractMethod1() {
        log.info("抽象方法1的实现被调用");
    }

    @Override
    public void abstractMethod2() {
        log.info("抽象方法2的实现被调用");
    }
}