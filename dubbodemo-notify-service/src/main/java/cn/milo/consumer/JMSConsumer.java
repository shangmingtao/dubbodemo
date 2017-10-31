package cn.milo.consumer;


import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * Created by admin on 2017/10/26.
 *
 *
 *
 * http://blog.csdn.net/w938706428/article/details/45153705
 * http://www.cnblogs.com/hapjin/p/5644402.html
 * http://blog.csdn.net/songhaifengshuaige/article/details/54176849
 * http://blog.csdn.net/joeyon1985/article/details/36886285
 *
 * http://www.zhimengzhe.com/bianchengjiaocheng/Javabiancheng/247233.html     //设置2无效
 *
 *
 *
 * 在 ActiveMQ 5.2 中添加了一个新的确认模式，这种确认模式是特定于 ActiveMQ 的，jms 规范暂时并不支持这种确认模式。
 * 这种确认模式由ora.apache.activemq.ActiveMQSession.INDIVIDUAL_ACKNOWLEDGE 表示，用来确认一个单独的消息。
 * 这中确认模式是相对于 Session.CLIENT_ACKNOWLEDGE 的，在 CLIENT_ACKNOWLEDGE 模式下，
 * 调用消息的 acknowledge() 方法会确认由此 session 消费的所有消息，而在INDIVIDUAL_ACKNOWLEDGE 模式下，
 * 仅会确认调用 acknowledge() 方法的消息。
 */
public class JMSConsumer {

    private static final String USERNAME = "admin";//默认连接用户名
    private static final String PASSWORD = "admin";//默认连接密码
    private static final String BROKEURL = "tcp://118.212.149.60:61616";//默认连接地址
    /**
     * 消息的消费者（接受者）
     * @author liang
     *
     */
    public static void main(String[] args) {
        ConnectionFactory connectionFactory;//连接工厂
        Connection connection = null;//连接

        final Session session;//会话 接受或者发送消息的线程
        Destination destination;//消息的目的地

        MessageConsumer messageConsumer;//消息的消费者

        //实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BROKEURL);

        try {
            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建session
            session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            //创建一个连接HelloWorld的消息队列
            destination = session.createQueue("HelloWorld");
            //创建消息消费者
            messageConsumer = session.createConsumer(destination);

//            while (true) {
//                TextMessage textMessage = (TextMessage) messageConsumer.receive(100000);
//                if(textMessage != null){
//                    System.out.println("收到的消息:" + textMessage.getText() + "消息id : " + textMessage.getJMSMessageID() + " testMessage = " + textMessage);
//                    if (textMessage.getText().equals("ActiveMQ 发送消息4")){
//                        System.out.println(textMessage);
//                        textMessage.acknowledge();
//                    }
////                    textMessage.acknowledge();
////                    session.commit();
//                }else {
//                    break;
//                }
//            }
            messageConsumer.setMessageListener(new MessageListener() {
                public void onMessage(Message msg){
                    TextMessage message = (TextMessage) msg;
                    try {
                        System.out.println("异步接受：" +message.getText());
                    if (message.getText().equals("ActiveMQ 发送消息7")){
                        System.out.println(message);
                        msg.acknowledge();
                    }
//                        message.acknowledge();
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            System.out.println(11111);
//            session.close();
//            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
