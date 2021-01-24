package top.parak.adapter.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.adapter.pattern </p>
 * <p> FileName: Adapter <p>
 * <p> Description: 适配器模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/18
 */

import org.apache.log4j.Logger;

/**
 * <P>测试类</P>
 */
public class AdapterDemo {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}

/**
 * <p>
 *     目标接口
 * </p>
 */
interface Target {
    public void request();
}

/**
 * <p>
 *     适配者接口
 * </p>
 */
class Adaptee {
    private Logger log = Logger.getLogger(Adaptee.class);
    public void specificRequest() {
        log.info("适配者中的业务代码被调用");
    }
}

/**
 * <p>
 *     适配器类
 * </p>
 */
class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        specificRequest();
    }
}
