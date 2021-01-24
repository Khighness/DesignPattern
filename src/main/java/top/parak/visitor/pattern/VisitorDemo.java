package top.parak.visitor.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.visitor.pattern </p>
 * <p> FileName: VisitorDemo <p>
 * <p> Description: 访问者模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/8
 */

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>测试类</p>
 */
public class VisitorDemo {
    public static void main(String[] args) {
        ObjectStructure structure = new ObjectStructure();
        structure.add(new ConcreteElementA());
        structure.add(new ConcreteElementB());
        structure.add(new ConcreteElementC());

        Visitor visitorA = new ConcreteVisitorA();
        Visitor visitorB = new ConcreteVisitorB();
        structure.accept(visitorA);
        structure.accept(visitorB);
    }
}

/**
 * <p>
 *     抽象访问者
 * </p>
 */
interface Visitor {
    void visit(ConcreteElementA elementA);
    void visit(ConcreteElementB elementB);
    void visit(ConcreteElementC elementC);
}

/**
 * <p>
 *     具体访问者A
 * </p>
 */
class ConcreteVisitorA implements Visitor {
    private Logger log = Logger.getLogger(ConcreteVisitorA.class);

    @Override
    public void visit(ConcreteElementA elementA) {
        log.info("具体访问者A访问=>具体元素A");
        elementA.operaA();
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        log.info("具体访问者A访问=>具体元素B");
        elementB.operaB();
    }

    @Override
    public void visit(ConcreteElementC elementC) {
        log.info("具体访问者A访问=>具体元素C");
        elementC.operaC();
    }
}

/**
 * <p>
 *     具体访问者B
 * </p>
 */
class ConcreteVisitorB implements Visitor {
    private Logger log = Logger.getLogger(ConcreteVisitorB.class);

    @Override
    public void visit(ConcreteElementA elementA) {
        log.info("具体访问者B访问=>具体元素A");
        elementA.operaA();
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        log.info("具体访问者B访问=>具体元素B");
        elementB.operaB();
    }

    @Override
    public void visit(ConcreteElementC elementC) {
        log.info("具体访问者B访问=>具体元素C");
        elementC.operaC();
    }
}

/**
 * <p>
 *     抽象元素类
 * </p>
 */
interface Element {
    void accept(Visitor visitor);
}

/**
 * <p>
 *     具体元素A
 * </p>
 */
class ConcreteElementA implements Element {
    private Logger log = Logger.getLogger(ConcreteElementA.class);

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operaA()  {
        log.info("具体元素A操作...");
    }
}

/**
 * <p>
 *     具体元素B
 * </p>
 */
class ConcreteElementB implements Element {
    private Logger log = Logger.getLogger(ConcreteElementB.class);

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operaB()  {
        log.info("具体元素B操作...");
    }
}

/**
 * <p>
 *     具体元素C
 * </p>
 */
class ConcreteElementC implements Element {
    private Logger log = Logger.getLogger(ConcreteElementC.class);

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operaC()  {
        log.info("具体元素C操作...");
    }
}

/**
 * <p>
 *     对象结构角色
 * </p>
 */
class ObjectStructure {
    private List<Element> list = new ArrayList<Element>();

    public void accept(Visitor visitor) {
        Iterator<Element> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(visitor);
        }
    }

    public void add(Element element) {
        list.add(element);
    }

    public void remove(Element element) {
        list.remove(element);
    }
}