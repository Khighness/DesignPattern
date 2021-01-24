package top.parak.factoryMethod.pattern;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.factoryMethod.pattern </p>
 * <p> FileName: FactoryMethod <p>
 * <p> Description: 工厂方法模式 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/17
 */

/**
 * <p>测试类</p>
 */
public class FactoryMethodDemo {
    private static Logger log = Logger.getLogger(FactoryMethodDemo.class);

    /**
     * <p>
     * 读取XML配置文件，提取具体类名，返回实例对象集合
     * </p>
     * @return List<Object>
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static List<Object> getObjects(String filePath) throws IOException, SAXException, ParserConfigurationException,  ClassNotFoundException, IllegalAccessException, InstantiationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File(filePath));
        NodeList nodeList = document.getElementsByTagName("className");
        List<Object> objects = new LinkedList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            String packageName = FactoryMethodDemo.class.getPackage().getName();
            String className = nodeList.item(i).getTextContent();
            Class<?> c = Class.forName(packageName + "." + className);
            objects.add(c.newInstance());
        }
        return objects;
    }

    public static void main(String[] args) {
        try {
            List<Object> objects = getObjects("src/main/java/top/parak/factoryMethod/pattern/config.xml");
            objects.stream().forEach( o -> {
                AbstractFactory factory = (AbstractFactory) o;
                try {
                    factory.produce().show();
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                };
            });
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}

/**
 * <P>
 *     抽象产品
 * </P>
 */
interface product {
    void show();
}

/**
 * <p>
 *     具体产品1
 * </p>
 */
class ConcreteProduct1 implements product {
    private Logger log = Logger.getLogger(ConcreteProduct1.class);
    public void show() {
        log.info("具体产品1展示...");
    }
}

/**
 * <p>
 *     具体产品2
 * </p>
 */
class ConcreteProduct2 implements product {
    private Logger log = Logger.getLogger(ConcreteProduct2.class);
    public void show() {
        log.info("具体产品2展示...");
    }
}

/**
 * <p>
 *     具体产品3
 * </p>
 */
class ConcreteProduct3 implements product {
    private Logger log = Logger.getLogger(ConcreteProduct3.class);
    public void show() {
        log.info("具体产品3展示...");
    }
}

/**
 * <p>
 *     抽象工厂
 * </p>
 */
interface AbstractFactory {
    public product produce() throws InterruptedException;
}

/**
 * <p>
 *     具体工厂1
 * </p>
 */
class ConcreteFactory1 implements AbstractFactory {
    private Logger log = Logger.getLogger(ConcreteFactory1.class);
    public product produce() {
        log.info("具体工厂1生产中...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("===>产品1生产完成");
        return new ConcreteProduct1();
    }
}

/**
 * <p>
 *     具体工厂2
 * </p>
 */
class ConcreteFactory2 implements AbstractFactory {
    private Logger log = Logger.getLogger(ConcreteFactory2.class);
    public product produce() {
        log.info("具体工厂2生产中...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("===>产品2生产完成");
        return new ConcreteProduct2();
    }
}

/**
 * <p>
 *     具体工厂3
 * </p>
 */
class ConcreteFactory3 implements AbstractFactory {
    private Logger log = Logger.getLogger(ConcreteFactory3.class);
    public product produce() {
        log.info("具体工厂3生产中...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("===>产品3生产完成");
        return new ConcreteProduct3();
    }
}


