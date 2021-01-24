package top.parak.composite.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.composite.pattern </p>
 * <p> FileName: Composite <p>
 * <p> Description: 组合模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/19
 */

import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>测试类</p>
 */
public class CompositeDemo {
    public static void main(String[] args) {
        Component component0 = new Composite();
        Component component1 = new Composite();
        Component component2 = new Leaf("1");
        Component component3 = new Leaf("2");
        Component component4 = new Leaf("3");
        component0.add(component2);
        component0.add(component1);
        component1.add(component3);
        component1.add(component4);
        component0.operation();
    }
}

/**
 * <p>
 *     抽象构件
 * </p>
 */
interface Component {
    public void add(Component c);
    public void remove(Component c);
    public Component getChild(int i);
    public void operation();
}

/**
 * <p>
 *     树叶构件
 * </p>
 */
class Leaf implements Component {
    private Logger log = Logger.getLogger(Leaf.class);
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component c) { }

    @Override
    public void remove(Component c) { }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void operation() {
        log.info("树叶" + name + "被访问");
    }
}

/**
 * <p>
 *     树枝构件
 * </p>
 */
class Composite implements Component{
    private List<Component> children = new ArrayList<>();

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return children.get(i);
    }

    @Override
    public void operation() {
        for (Object obj : children) {
            ((Component) obj).operation();
        }
    }
}
