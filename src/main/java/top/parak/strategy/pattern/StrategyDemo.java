package top.parak.strategy.pattern;

import org.apache.log4j.Logger;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.strategy.pattern </p>
 * <p> FileName: StrategyDemo <p>
 * <p> Description: 策略模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/7
 */

/**
 * <p>测试类</p>
 */
public class StrategyDemo {
    public static void main(String[] args) {
        Context context = new Context();
        Strategy strategy1 = new ConcreteStrategyA();
        Strategy strategy2 = new ConcreteStrategyB();
        context.setStrategy(strategy1);
        context.strategyMethod();
        context.setStrategy(strategy2);
        context.strategyMethod();
    }
}

/**
 * <p>
 *     抽象策略类
 * </p>
 */
interface Strategy {
    void strategyMethod();
}

/**
 * <p>
 *     具体策略类A
 * </p>
 */
class ConcreteStrategyA implements Strategy {
    private Logger log = Logger.getLogger(ConcreteStrategyA.class);
    @Override
    public void strategyMethod() {
        log.info("具体策略A的策略方法被访问");
    }
}

/**
 * <p>
 *     具体策略类B
 * </p>
 */
class ConcreteStrategyB implements Strategy {
    private Logger log = Logger.getLogger(ConcreteStrategyB.class);
    @Override
    public void strategyMethod() {
        log.info("具体策略B的策略方法被访问");
    }
}

/**
 * <p>
 *     环境类
 * </p>
 */
class Context {
    private Strategy strategy;
    public Strategy getStrategy() {
        return strategy;
    }
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public void strategyMethod() {
        strategy.strategyMethod();
    }
}