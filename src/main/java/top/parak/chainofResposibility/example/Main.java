package top.parak.chainofResposibility.example;

import org.apache.log4j.Logger;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.chainofResposibility.example </p>
 * <p> FileName: Main <p>
 * <p> Description: 责任链Demo <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/23
 */

/**
 * <p>
 *     测试类
 * </p>
 */
public class Main {
    public static void main(String[] args) {
        Support RubbishK = new NoSupport("RubbishK");
        Support FlowerK = new LimitSupport("FlowerK", 100);
        Support EyedropK = new LimitSupport("EyedropK", 200);
        Support UnknownK = new SpecialSupport("UnknownK", 300);
        Support KHighness = new SpecialSupport("KHighness", 330);
        Support BrotherK = new OddSupport("BrotherK");
        // 制造责任链
        RubbishK.setNext(FlowerK).setNext(EyedropK).setNext(UnknownK).setNext(KHighness).setNext(BrotherK);
        // 制造问题
        for (int i = 0; i < 500; i += 30) {
            RubbishK.support(new Trouble(i));
        }
    }
}

/**
 * <p>
 *     发生的问题的类
 * </p>
 */
class Trouble {
    private int number;

    public Trouble(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "[Trouble " +
                "number=" + number +
                ']';
    }
}

/**
 * <p>
 *     用来解决问的抽象类
 * </p>
 */
abstract class Support {
    private Logger log = Logger.getLogger(Support.class);

    private String name;
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    public final void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    public abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        log.info(trouble + " is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {
        log.info(trouble + " cannot be resolved.");
    }
}

/**
 * <p>
 *     解决问题具体类：不能解决问题
 * </p>
 */
class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);
    }

    @Override
    public boolean resolve(Trouble trouble) {
        return false;
    }
}

/**
 * <p>
 *     解决问题具体类：解决问题编号小于limit值得类
 * </p>
 */
class LimitSupport extends Support {
    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    public boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < limit) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * <p>
 *     解决问题具体类：解决奇数编号得问题
 * </p>
 */
class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }

    @Override
    public boolean resolve(Trouble trouble) {
        if (trouble.getNumber() % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * <p>
 *     解决问题具体类：只解决指定编号得问题
 * </p>
 */
class SpecialSupport extends Support {
    private int number;

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    public boolean resolve(Trouble trouble) {
        if (trouble.getNumber() == this.number) {
            return true;
        } else {
            return false;
        }
    }
}