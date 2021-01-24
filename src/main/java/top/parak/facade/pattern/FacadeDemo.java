package top.parak.facade.pattern;

import org.apache.log4j.Logger;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.facade.pattern </p>
 * <p> FileName: Facade <p>
 * <p> Description: 外观模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/19
 */

/**
 * <p>测试类</p>
 */
public class FacadeDemo {
    public static void main(String[] args) {

    }
}

class Facade {
    private SubSys1 subSys1 = new SubSys1();
    private SubSys2 subSys2 = new SubSys2();
    private SubSys3 subSys3 = new SubSys3();
    public void method() {
        subSys1.method1();
        subSys2.method2();
        subSys3.method3();
    }
}

class SubSys1 {
    private Logger log = Logger.getLogger(SubSys1.class);
    public void method1() {
        log.info("子系统1的method1被调用");
    }
}

class SubSys2 {
    private Logger log = Logger.getLogger(SubSys2.class);
    public void method2() {
        log.info("子系统2的method2被调用");
    }
}


class SubSys3 {
    private Logger log = Logger.getLogger(SubSys3.class);
    public void method3() {
        log.info("子系统3的method3被调用");
    }
}

