package top.parak.proxy.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.proxy.pattern </p>
 * <p> FileName: Proxy <p>
 * <p> Description: 代理模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/18
 */

import org.apache.log4j.Logger;

/**
 * <p>测试类</p>
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}

/**
 * <p>
 *     抽象主题
 * </p>
 */
interface Subject {
    void request();
}

/**
 * <p>
 *     真实主题
 * </p>
 */
class RealSubject implements Subject {
    private Logger log = Logger.getLogger(RealSubject.class);
    @Override
    public void request() {
        log.info("访问真实主题...");
    }
}

/**
 * <p>
 *     代理
 * </p>
 */
class Proxy implements Subject {
    private Logger log = Logger.getLogger(Proxy.class);
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
            preHandler();
            realSubject.request();
            postHandler();
        }
    }

    public void preHandler() {
        log.info("访问真实主题之前的预处理");
    }

    public void postHandler() {
        log.info("访问真实主题之后的后续处理");
    }
}
