package cn.milo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mac on 2017/10/27.
 */
public class App {

    public static void main(String[] args) {
        String paths[] = {"spring/applicationContext.xml"};
//这个xml文件是Spring配置beans的文件，顺带一提，路径 在整个应用的根目录
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
    }
}
