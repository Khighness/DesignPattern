package top.parak.iterator.pattern;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.iterator.pattern </p>
 * <p> FileName: IteratorDemo <p>
 * <p> Description: 迭代器模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/27
 */

/**
 * <p>测试类</p>
 */
public class IteratorDemo {
    public static Logger log = Logger.getLogger(IteratorDemo.class);

    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("KHighness");
        aggregate.add("ParaK");
        aggregate.add("FlowerK");
        log.info("聚合的内容");
        Iterator iterator = aggregate.getIterator();
        log.info(iterator.first().toString());
        while (iterator.hasNext()) {
            log.info(iterator.next().toString());
        }
    }
}

/**
 * <p>
 *     抽象聚合
 * </p>
 */
interface Aggregate {
    public void add(Object o);
    public void del(Object o);
    public Iterator getIterator();
}

/**
 * <p>
 *     具体聚合
 * </p>
 */
class ConcreteAggregate implements Aggregate {
    private List<Object> list = new ArrayList<>();

    @Override
    public void add(Object o) {
        list.add(o);
    }

    @Override
    public void del(Object o) {
        list.remove(o);
    }

    @Override
    public Iterator getIterator() {
            return (new ConcreteIterator(list));
    }
}

/**
 * <p>
 *     抽象迭代器
 * </p>
 */
interface Iterator {
    Object first();
    Object next();
    boolean hasNext();
}

/**
 * <p>
 *     具体迭代器
 * </p>
 */
class ConcreteIterator implements Iterator {

    private List<Object> list = null;
    private int index = 1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Object first() {
        index = 0;
        Object object = list.get(index);
        return object;
    }

    @Override
    public Object next() {
        Object object = null;
        if (this.hasNext()) {
            object = list.get(++index);
        }
        return object;
    }

    @Override
    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        } else {
            return false;
        }
    }
}