package top.parak.singleton.example;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.singleton.example </p>
 * <p> FileName: ZhuBajieSingleton <p>
 * <p> Description: 饿汉式单例模式模拟产生猪八戒对象 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/16
 */

import org.apache.log4j.Logger;
import javax.swing.*;
import java.awt.*;

public class ZhuBajieSingleton {
    public static Logger log = Logger.getLogger(ZhuBajieSingleton.class);
    public static void main(String[] args) {
        JFrame frame = new JFrame("猪八戒");
        frame.setLayout(new GridLayout(1, 2));
        Container contentPane = frame.getContentPane();
        ZhuBajie zhuBajie1 = ZhuBajie.getInstance();
        contentPane.add(zhuBajie1);
        ZhuBajie zhuBajie2 = ZhuBajie.getInstance();
        contentPane.add(zhuBajie2);
        if (zhuBajie1 == zhuBajie2) {
            log.info("两个猪八戒相同");
        } else {
            log.info("两个猪八戒不同");
        }
        // pack: 调整窗口大小，使其刚好容纳放置的组件
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("all")
class ZhuBajie extends JPanel {
    private static ZhuBajie instance = new ZhuBajie();
    private ZhuBajie() {
        JLabel label = new JLabel(new ImageIcon("img/Bajie.jpg"));
        this.add(label);
    }
    public static ZhuBajie getInstance() {
        return instance;
    }
}
