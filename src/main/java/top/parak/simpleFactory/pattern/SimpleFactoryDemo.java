package top.parak.simpleFactory.pattern;

import org.apache.log4j.Logger;
import java.util.Scanner;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.simpleactory.pattern </p>
 * <p> FileName: Client <p>
 * <p> Description: 简单工厂模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/17
 */

/**
 * <p>测试类</p>
 */
public class SimpleFactoryDemo {
    private static Logger log = Logger.getLogger(SimpleFactoryDemo.class);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("输入产品型号：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0: log.info("成功退出"); return;
                case 1: SimpleFactory.makeProduct(Constant.PRODUCT_1).show(); break;
                case 2: SimpleFactory.makeProduct(Constant.PRODUCT_2).show(); break;
                case 3: SimpleFactory.makeProduct(Constant.PRODUCT_3).show(); break;
                default: log.info("该产品不存在，请重新输入！"); break;
            }
        }
    }
}

/**
 * <p>
 *     抽象产品
 * </p>
 */
interface product {
    void show();
}

/**
 * <p>
 *     枚举所有产品
 * </p>
 */
enum Constant {
    PRODUCT_1,
    PRODUCT_2,
    PRODUCT_3;
}

/**
 * <p>
 *     具体产品1
 * </p>
 */
class ConcreteProduct1 implements product {
    private Logger log = Logger.getLogger(ConcreteProduct1.class);
    public void show() {
        log.info("具体产品1显示...");
    }
}

/**
 * <p>
 *     具体产品2
 * </p>
 */
class ConcreteProduct2 implements product {
    private Logger log = Logger.getLogger(ConcreteProduct2.class);
    public void show() {
        log.info("具体产品2显示...");
    }
}

/**
 * <p>
 *     具体产品3
 * </p>
 */
class ConcreteProduct3 implements product {
    private Logger log = Logger.getLogger(ConcreteProduct3.class);
    public void show() {
        log.info("具体产品3显示...");
    }
}

/**
 * <p>
 *     简单工厂
 * </p>
 */
class SimpleFactory {
    public static product makeProduct(Constant c) {
        switch (c) {
            case PRODUCT_1:
                return new ConcreteProduct1();
            case PRODUCT_2:
                return new ConcreteProduct2();
            case PRODUCT_3:
                return new ConcreteProduct3();
        }
        return null;
    }
}