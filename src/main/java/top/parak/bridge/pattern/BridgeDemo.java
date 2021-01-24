package top.parak.bridge.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.bridge.pattern </p>
 * <p> FileName: Bridge <p>
 * <p> Description: 桥接模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/18
 */

import org.apache.log4j.Logger;

/**
 * <p>测试类</p>
 */
public class BridgeDemo {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementorA();
        Abstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.operation();
    }
}

/**
 * <p>
 *     实现化角色
 * </p>
 */
interface Implementor {
    public void operationImpl();
}

/**
 * <p>
 *     具体实现化角色
 * </p>
 */
class ConcreteImplementorA implements Implementor {
    private Logger log = Logger.getLogger(ConcreteImplementorA.class);
    @Override
    public void operationImpl() {
        log.info("具体实现化角色(Concrete Implementor)被访问");
    }
}

/**
 * <p>
 *     抽象化角色
 * </p>
 */
abstract class Abstraction {
    protected Implementor implementor;

    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation();
}

/**
 * <p>
 *     扩展抽象化角色
 * </p>
 */
class RefinedAbstraction extends Abstraction {
    private Logger log = Logger.getLogger(RefinedAbstraction.class);

    protected RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        log.info("扩展抽象化角色(Refined Abstraction)被访问");
        implementor.operationImpl();
    }
}