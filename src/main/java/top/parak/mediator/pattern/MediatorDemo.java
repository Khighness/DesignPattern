package top.parak.mediator.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.mediator.pattern </p>
 * <p> FileName: MediatorDemo <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/8
 */

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     中介者
 * </p>
 */
public class MediatorDemo {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague colleague1, colleague2;
        colleague1 = new ConcreteColleague1();
        colleague2 = new ConcreteColleague2();
        mediator.register(colleague1);
        mediator.register(colleague2);
        colleague1.send();
        colleague2.send();
    }
}

/**
 * <p>
 *     中介者
 * </p>
 */
abstract class Mediator {
    /* 注册 */
    public abstract void register(Colleague colleague);
    /* 转发 */
    public abstract void relay(Colleague colleague);
}

/**
 * <p>
 *     具体中介者
 * </p>
 */
class ConcreteMediator extends Mediator {
    private List<Colleague> colleagues = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        colleagues.add(colleague);
        colleague.setMediator(this);
    }

    @Override
    public void relay(Colleague colleague) {
        for (Colleague colleague1 : colleagues) {
            if (!colleague1.equals(colleague)) {
                colleague1.receive();
            }
        }
    }
}

/**
 * <p>
 *     抽象同事类
 * </p>
 */
abstract class Colleague {
    private Logger log = Logger.getLogger(Colleague.class);
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();
    public abstract void send();
}

/**
 * <p>
 *     具体同事类1
 * </p>
 */
class ConcreteColleague1 extends Colleague {
    private Logger log = Logger.getLogger(ConcreteColleague1.class);

    @Override
    public void receive() {
        log.info("具体同事类1收到请求");
    }

    @Override
    public void send() {
        log.info("具体同事1发出请求");
        mediator.relay(this);
    }
}

/**
 * <p>
 *     具体同事类2
 * </p>
 */
class ConcreteColleague2 extends Colleague {
    private Logger log = Logger.getLogger(ConcreteColleague2.class);

    @Override
    public void receive() {
        log.info("具体同事类2收到请求");
    }

    @Override
    public void send() {
        log.info("具体同事2发出请求");
        mediator.relay(this);
    }
}