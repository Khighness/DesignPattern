package top.parak.decorator.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.decorator.pattern </p>
 * <p> FileName: Decorator <p>
 * <p> Description: 装饰模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/18
 */

import org.apache.log4j.Logger;

/**
 * <p>测试类</p>
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        Component component1 = new ConcreteComponent();
        component1.operation();
        Component component2 = new ConcreteDecorator(component1);
        component2.operation();
    }
}

/**
 * <p>
 *     抽象构件角色
 * </p>
 */
interface Component {
    public void operation();
}

/**
 * <p>
 *     具体构件角色
 * </p>
 */
class ConcreteComponent implements Component {
    private Logger log = Logger.getLogger(ConcreteComponent.class);
    public ConcreteComponent() {
        log.info("创建具体构件角色");
    }

    @Override
    public void operation() {
        log.info("调用具体构件角色的方法operation()");
    }
}

/**
 * <p>
 *     抽象装饰角色
 * </p>
 */
class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {

    }
}

/**
 * <p>
 *     具体装饰角色
 * </p>
 */
class ConcreteDecorator extends Decorator {
    private Logger log = Logger.getLogger(ConcreteComponent.class);

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addFunction();
    }

    public void addFunction() {
        log.info("为具体构件角色增加额外的功能function()");
    }
}
