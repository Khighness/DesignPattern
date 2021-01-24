package top.parak.prototype.example;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.prototype.example </p>
 * <p> FileName: CitationPrototype <p>
 * <p> Description: 原型模式生成三差学生奖状 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/16
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.log4j.Logger;
import sun.awt.AWTAccessor;

import javax.crypto.Cipher;

/**
 * <p> 分析:
 * 同一学校的“三差学生”奖状除了获奖人姓名不同，其他都相同，属于相似对象的复制，
 * 同样可以用原型模式创建，然后再做简单修改就可以了。
 * </p>
 */
public class CitationPrototype {
    private static Logger log = Logger.getLogger(CitationPrototype.class);
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation citation1 = new Citation("陈子康",
                "同学在2020年第一学期德智体三方面都表现极差，被评为三差学生", "软件学院");
        Citation citation2 = (Citation) citation1.clone();
        citation2.setInfo("同学在2020年第二学期各个方面都表现极差，被评为问题学生");
        log.info(citation1.toString());
        log.info(citation2.toString());
    }
}

class Citation implements Cloneable{

    private Logger log = Logger.getLogger(Citation.class);

    @Getter@Setter
    String name;

    @Getter@Setter
    String info;

    @Getter@Setter
    String college;

    public Citation(String name, String info, String college) {
        this.setName(name);
        this.setInfo(info);
        this.setCollege(college);
    }

    @Override
    public String toString() {
        return "学生信息[" +
                "姓名：" + getName() +
                ", 获奖信息：" + getInfo() +
                ", 学院：" + getCollege() +
                "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        log.info("奖状拷贝成功");
        return super.clone();
    }
}
