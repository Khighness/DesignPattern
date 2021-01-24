package top.parak.memento.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.memento.pattern </p>
 * <p> FileName: MementoDemo <p>
 * <p> Description: 备忘录模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/8
 */

import org.apache.log4j.Logger;

/**
 * <p>测试类</p>
 */
public class MementoDemo {
    public static Logger log = Logger.getLogger(MementoDemo.class);
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("State1");
        log.info("初始状态：" + originator.getState());
        // 保存状态
        caretaker.setMemento(originator.createMemento());
        originator.setState("State2");
        log.info("新的状态：" + originator.getState());
        // 恢复状态
        originator.restoreMemento(caretaker.getMemento());
        log.info("恢复状态：" + originator.getState());
    }
}

/**
 * <p>
 *     备忘录
 * </p>
 */
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

/**
 * <p>
 *     发起人
 * </p>
 */
class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento memento) {
        this.setState(memento.getState());
    }
}

/**
 * <p>
 *     管理者
 * </p>
 */
class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}