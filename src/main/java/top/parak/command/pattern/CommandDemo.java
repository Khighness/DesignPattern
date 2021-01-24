package top.parak.command.pattern;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.command.pattern </p>
 * <p> FileName: CommandDemo <p>
 * <p> Description: 命令模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/7
 */

import org.apache.log4j.Logger;

/**
 * <p>测试类</p>
 */
public class CommandDemo {
    public static Logger log = Logger.getLogger(CommandDemo.class);
    public static void main(String[] args) {
        Command command = new ConcreteCommand();
        Invoker invoker = new Invoker(command);
        log.info("客户访问调用者的call方法");
        invoker.call();
    }
}

/**
 * <p>
 *     调用者
 * </p>
 */
class Invoker {
    private Logger log = Logger.getLogger(Invoker.class);
    private Command command;
    public Invoker(Command command)  {
        this.command = command;
    }
    public void setCommand(Command command) {
        this.command = command;
    }
    public void call() {
        log.info("调用者执行命令command");
        command.execute();
    }
}

/**
 * <p>
 *     抽象命令
 * </p>
 */
interface Command {
    abstract void execute();
}

/**
 * <p>
 *     具体命令
 * </p>
 */
class ConcreteCommand implements Command {
    private Receiver receiver;
    public ConcreteCommand() {
        this.receiver = new Receiver();
    }
    @Override
    public void execute() {
        receiver.action();
    }
}

/**
 * <p>
 *     接收者
 * </p>
 */
class Receiver {
    private Logger log = Logger.getLogger(Receiver.class);
    public void action() {
        log.info("接收者的action方法被调用");
    }
}
