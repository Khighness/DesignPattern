package top.parak.builder.pattern;

import lombok.Data;
import org.apache.log4j.Logger;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.builder.pattern </p>
 * <p> FileName: Builder <p>
 * <p> Description: 建造者模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/17
 */

/**
 * <p>测试类</p>
 */
public class BuilderDemo {
    private static Logger log = Logger.getLogger(BuilderDemo.class);
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        log.info(product.toString());
    }
}

/**
 * <p>
 *     抽象产品类
 * </p>
 */
@Data
class Product {
    private String componentA;
    private String componentB;
    private String componentC;
}

/**
 * <p>
 *     抽象建造者
 * </p>
 */
abstract class Builder {
    protected Product product = new Product();
    public abstract void buildComponentA();
    public abstract void buildComponentB();
    public abstract void buildComponentC();
    public Product getProduct() {
        return product;
    }
}

/**
 * <p>
 *     具体建造者
 * </p>
 */
class ConcreteBuilder extends Builder {

    @Override
    public void buildComponentA() {
        product.setComponentA("建造零件A");
    }

    @Override
    public void buildComponentB() {
        product.setComponentB("建造零件B");
    }

    @Override
    public void buildComponentC() {
        product.setComponentC("建造零件C");
    }
}

/**
 * <P>
 *     指挥者
 * </P>
 */
class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }
    public Product construct() {
        builder.buildComponentA();
        builder.buildComponentB();
        builder.buildComponentC();
        return builder.getProduct();
    }
}