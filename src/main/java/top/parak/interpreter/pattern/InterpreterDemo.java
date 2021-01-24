package top.parak.interpreter.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.interpreter.pattern </p>
 * <p> FileName: InterpreterDemo <p>
 * <p> Description: 解释器模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/8
 */

/**
 * <p>
 *     测试类
 * </p>
 */
public class InterpreterDemo {
}

/**
 * <p>
 *     抽象表达式
 * </p>
 */
interface AbstractExpression {
    Object interpret(String info);
}

/**
 * <p>
 *     终结符表达式类
 * </p>
 */
class TerminalExpression implements AbstractExpression {
    @Override
    public Object interpret(String info) {
        /* 对终结符表达式的处理 */
        return null;
    }
}

/**
 * <p>
 *     非终结符表达式类
 * </p>
 */
class NonTerminalExpression implements AbstractExpression {
    @Override
    public Object interpret(String info) {
        /* 对非终结符表达式的处理 */
        return null;
    }
}

/**
 * <p>
 *     环境类
 * </p>
 */
class Context {
    private AbstractExpression abstractExpression;
    public Context() {
        /* 数据初始化 */
    }
    public void operation(String info) {
        /* 调用相关表达式的解释方法 */
    }
}