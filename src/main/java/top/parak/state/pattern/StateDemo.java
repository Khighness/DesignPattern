package top.parak.state.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.state.pattern </p>
 * <p> FileName: StateDemo <p>
 * <p> Description: 状态模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/8
 */

import org.apache.log4j.Logger;

/**
 * <p>测试类</p>
 */
public class StateDemo {
    public static void main(String[] args) {
        Context context = new Context();
        context.handle();
        context.handle();
        context.handle();
        context.handle();
        context.handle();
    }
}

/**
 * <p>
 *     环境类
 * </p>
 */
class Context {
    private State state;
    /* 初始状态 */
    public Context()  {
        this.state = new ConcreteStateA();
    }
    /* 读取状态 */
    public State getState() {
        return state;
    }
    /* 设置状态 */
    public void setState(State state) {
        this.state = state;
    }
    /* 处理请求 */
    public void handle()  {
        state.handle(this);
    }
}

/**
 * <p>
 *     抽象状态类
 * </p>
 */
abstract class State {
    abstract void handle(Context context);
}

/**
 * <p>
 *     具体状态A类
 * </p>
 */
class ConcreteStateA extends State {
    private Logger log = Logger.getLogger(ConcreteStateA.class);

    @Override
    void handle(Context context) {
        log.info("当前状态：A");
        context.setState(new ConcreteStateB());
    }
}

/**
 * <p>
 *     具体状态B类
 * </p>
 */
class ConcreteStateB extends State {
    private Logger log = Logger.getLogger(ConcreteStateB.class);

    @Override
    void handle(Context context) {
        log.info("当前状态：B");
        context.setState(new ConcreteStateA());
    }
}