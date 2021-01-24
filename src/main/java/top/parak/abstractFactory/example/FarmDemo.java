package top.parak.abstractFactory.example;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.abstractFactory.example </p>
 * <p> FileName: Farm <p>
 * <p> Description: 抽象工厂模式模拟农场 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/17
 */

import org.apache.log4j.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *     农场测试类
 * </p>
 */
public class FarmDemo {
    private JFrame frame = new JFrame("FarmDemo");
    private JDesktopPane desktopPane = new JDesktopPane();
    private JPanel contentPane = (JPanel) frame.getContentPane();
    private JPanel leftPanel = new JPanel();
    private final ImageIcon backIcon = new ImageIcon("img/Farm.jpg");
    private final JLabel rightLabel = new JLabel(backIcon);
    private final JLabel tipLabel = new JLabel("选择产品");
    private final JButton produceButton = new JButton("开始生产");
    private final Font font = new Font("微软雅黑", Font.PLAIN, 20);
    private JComboBox<String> productComboBox = new JComboBox<>();
    private JTextArea textArea = new JTextArea();

    private AbstractFarm baoXingFarm = new BaoXingFarm();
    private AbstractFarm zhouQiaoFarm = new ZhouQiaoFarm();

    public FarmDemo() {
        contentPane.setOpaque(false);
        contentPane.setLayout(null);
        rightLabel.setBounds(300, 0, backIcon.getIconWidth(), backIcon.getIconHeight());
        desktopPane.setLayout(null);
        desktopPane.add(rightLabel, new Integer(Integer.MIN_VALUE));
        leftPanel.setBackground(Color.CYAN);
        leftPanel.setBounds(0, 0, 300, 420);
        desktopPane.add(leftPanel);

        leftPanel.setLayout(null);
        tipLabel.setFont(font);
        tipLabel.setBounds(5, 10, 90, 30);
        leftPanel.add(tipLabel);
        String[] products = new String[]{"马", "牛", "青菜", "白菜"};
        for (String product : products) {
            productComboBox.addItem(product);
        }
        productComboBox.setFont(font);
        produceButton.setFont(font);
        productComboBox.setBounds(90, 10, 80, 30);
        leftPanel.add(productComboBox);
        produceButton.setBounds(180, 10, 115, 30);
        leftPanel.add(produceButton);
        produceButton.addActionListener(new ProductAction());

        textArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 50, 280, 360);
        scrollPane.setBorder(new TitledBorder("生产日志"));
        scrollPane.getViewport().setOpaque(false);
        leftPanel.add(scrollPane);

        frame.setContentPane(desktopPane);
        frame.setBounds(300,300,1500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private int index = 0;
    class ProductAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JInternalFrame internalFrame = null;
            switch (productComboBox.getSelectedItem().toString()) {
                case "马":
                    internalFrame = zhouQiaoFarm.produceAnimalProduct().showImage();
                    textArea.append(getTime() + " 周桥农场：新马出生\n");
                    break;
                case "牛":
                    internalFrame = baoXingFarm.produceAnimalProduct().showImage();
                    textArea.append(getTime() + " 宝兴农场：新牛出生\n");
                    break;
                case "青菜":
                    internalFrame = baoXingFarm.producePlantProduct().showImage();
                    textArea.append(getTime() + " 宝兴农场：青菜出生\n");
                    break;
                case "白菜":
                    internalFrame = zhouQiaoFarm.producePlantProduct().showImage();
                    textArea.append(getTime() + " 周桥农场：白菜出生\n");
                    break;
                default:
                    throw new IllegalArgumentException("Error");
            }
            internalFrame.setBounds(index + 300, 100, 300, 350);
            desktopPane.add(internalFrame);
            index = (index + 300) % 1200;
        }

        private String getTime() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
    }

    public static void main(String[] args) {
        new FarmDemo();
    }
}

/**
 * <p>
 *     抽象产品：动物类
 * </p>
 */
interface AnimalProduct {
    public JInternalFrame showImage();
}

/**
 * <p>
 *     抽象产品：植物类
 * </p>
 */
interface PlantProduct {
    public JInternalFrame showImage();
}

/**
 * <p>
 *     动物产品展示窗口
 * </p>
 */
class AnimalFrame extends JInternalFrame implements AnimalProduct {
    public AnimalFrame(String animalName, String imagePath) {
        Container contentPane = getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setBorder(BorderFactory.createTitledBorder("动物：" + animalName));
        JScrollPane scrollPane = new JScrollPane(panel);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        JLabel label = new JLabel(new ImageIcon(imagePath));
        panel.add(label);
        pack();
        setTitle(animalName);
        setVisible(false);
        setClosable(true);
        setIconifiable(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public JInternalFrame showImage() {
        this.setVisible(true);
        return this;
    }
}

/**
 * <p>
 *     植物产品展示窗口
 * </p>
 */
class PlantFrame extends JInternalFrame implements PlantProduct{
    public PlantFrame(String plantName, String imagePath) {
        Container contentPane = getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setBorder(BorderFactory.createTitledBorder("植物：" + plantName));
        JScrollPane scrollPane = new JScrollPane(panel);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        JLabel label = new JLabel(new ImageIcon(imagePath));
        panel.add(label);
        pack();
        setTitle(plantName);
        setVisible(false);
        setClosable(true);
        setIconifiable(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public JInternalFrame showImage() {
        this.setVisible(true);
        return this;
    }
}

/**
 * <p>
 *     具体动物产品：马类
 * </p>
 */
class Horse extends AnimalFrame  {
    public Horse() {
        super("马-🐴", "img/Horse.jpg");
    }
}

/**
 * <p>
 *     具体动物产品：牛类
 * </p>
 */
class Cattle extends AnimalFrame {
    public Cattle() {
        super("牛-🐮", "img/Cattle.jpg");
    }
}

/**
 * <p>
 *     具体植物产品：青菜
 * </p>
 */
class Vegetable extends PlantFrame {
    public Vegetable() {
        super("青菜", "img/Vegetable.jpg");
    }
}

/**
 * <p>
 *     具体植物产品：白菜
 * </p>
 */
class Cabbage extends PlantFrame {
    public Cabbage() {
        super("白菜", "img/Cabbage.jpg");
    }
}

/**
 * <p>
 *     抽象工厂：农场类
 * </p>
 */
interface AbstractFarm {
    public AnimalProduct produceAnimalProduct();
    public PlantProduct producePlantProduct();
}

/**
 * <p>
 *     具体工厂：宝兴农场
 *     生产产品：牛、青菜
 * </p>
 */
class BaoXingFarm implements AbstractFarm {
    private Logger log = Logger.getLogger(BaoXingFarm.class);
    @Override
    public AnimalProduct produceAnimalProduct() {
        log.info("宝兴农场===>新牛出生");
        return new Cattle();
    }

    @Override
    public PlantProduct producePlantProduct() {
        log.info("宝兴农场===>青菜长成");
        return new Vegetable();
    }
}

/**
 * <p>
 *     具体农场：周桥农场
 *     生产产品：马、白菜
 * </p>
 */
class ZhouQiaoFarm implements AbstractFarm {
    private Logger log = Logger.getLogger(ZhouQiaoFarm.class);
    @Override
    public AnimalProduct produceAnimalProduct() {
        log.info("周桥农场===>新马出生");
        return new Horse();
    }

    @Override
    public PlantProduct producePlantProduct() {
        log.info("周桥农场===>白菜长成");
        return new Cabbage();
    }
}