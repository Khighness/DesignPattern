package top.parak.prototype.example;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.prototype.example </p>
 * <p> FileName: SunWukongPrototype <p>
 * <p> Description: 原型模式孙悟空生成器 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/16
 */

import org.apache.log4j.Logger;
import javax.swing.*;
import java.awt.*;

public class SunWukongPrototype {
    public static void main(String[] args) {
        JFrame frame = new JFrame("孙悟空");
        frame.setLayout(new GridLayout(1, 2));
        Container contentPane = frame.getContentPane();
        SunWukong sunWukong1 = new SunWukong();
        contentPane.add(sunWukong1);
        SunWukong sunWukong2 = (SunWukong) sunWukong1.clone();
        contentPane.add(sunWukong2);
        // pack: 调整窗口大小，使其刚好容纳放置的组件
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("all")
class SunWukong extends JPanel implements Cloneable {
    private Logger log = Logger.getLogger(SunWukong.class);

    public SunWukong() {
        JLabel label = new JLabel(new ImageIcon("img/Wukong.jpg"));
        this.add(label);
    }

    @Override
    public Object clone() {
        SunWukong sunWukongPrototype = null;
        try {
            sunWukongPrototype = (SunWukong) super.clone();
        } catch (CloneNotSupportedException e) {
            log.error("悟空拷贝失败");
        }
        return sunWukongPrototype;
    }
}
