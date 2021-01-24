package top.parak.prototype.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.prototype.pattern </p>
 * <p> FileName: Prototype <p>
 * <p> Description: 原型模式浅克隆 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/16
 */

import org.apache.log4j.Logger;

/**
 * <p> 特点：
 * 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，扔指向原有属性所指向的对象的内存地址
 * 深克隆：创建一个对象，属性中引用的对象也会被克隆，不再指向原有对象地址
 * </p>
 */
public class Prototype {
    public static Logger log = Logger.getLogger(Prototype.class);
    public static void main(String[] args) throws CloneNotSupportedException {
        RealizeType realizeType1 = new RealizeType();
        RealizeType realizeType2 = (RealizeType) realizeType1.clone();
        log.info("realizeType1 == realizeType2 ? " + (realizeType1 == realizeType2));
    }
}

class RealizeType implements Cloneable {

    private Logger log = Logger.getLogger(RealizeType.class);

    RealizeType() {
        log.info("原型创建");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        log.info("原型复制");
        return super.clone();
    }
}
