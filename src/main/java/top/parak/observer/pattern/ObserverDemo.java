package top.parak.observer.pattern;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.observer.pattern </p>
 * <p> FileName: ObserverDemo <p>
 * <p> Description: 观察者模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/27
 */

/**
 * <p>测试类</p>
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer[] observers = new Observer[20];
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 1) {
                observers[i] = new ConcreteObserver1();
            } else {
                observers[i] = new ConcreteObserver2();
            }
            subject.add(observers[i]);
        }
        subject.notifyObserver();
    }
}

/**
 * <p>
 *     抽象目标
 * </p>
 */
abstract class Subject {
    protected List<Observer> observers = new ArrayList<Observer>();
    /* 增加观察者 */
    public void add(Observer observer) {
        observers.add(observer);
    }
    /* 删除观察者 */
    public void del(Observer observer) {
        observers.remove(observer);
    }
    /* 通知观察者 */
    public abstract void notifyObserver();
}

/**
 * <p>
 *     具体目标
 * </p>
 */
class ConcreteSubject extends Subject {
    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生改变");
        System.out.println("——————————————");
        for (Observer observer : observers) {
            observer.response();
        }
    }
}

/**
 * <p>
 *     抽象观察者
 * </p>
 */
interface Observer {
    /* 作出反应 */
    void response();
}

/**
 * <p>
 *     具体观察者1
 * </p>
 */
class ConcreteObserver1 implements Observer {
    private Logger log = Logger.getLogger(ConcreteObserver1.class);
    @Override
    public void response() {
        log.info("具体观察者1作出反应");
    }
}

/**
 * <P>
 *     具体观察者2
 * </P>
 */
class ConcreteObserver2 implements Observer {
    private Logger log = Logger.getLogger(ConcreteObserver2.class);
    @Override
    public void response() {
        log.info("具体观察者2作出反应");
    }
}
