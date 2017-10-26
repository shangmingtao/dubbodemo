package cn.milo.dubbonotify;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Date;



/*

 *第二个消费者

 */

public class JMSTopicConsumer {

    public static void main(String[] args) {
        String USERNAME = "admin";//默认连接用户名
        String PASSWORD = "admin";//默认连接密码
        String BROKEURL = "tcp://118.212.149.60:61616";//默认连接地址

        String subject = "mq.topic";
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( USERNAME, PASSWORD, BROKEURL);
        Connection connection;
        try{
            connection= connectionFactory.createConnection();
            connection.start();
            final Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic(subject);
            MessageConsumer consumer = session.createConsumer(topic);
            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message msg){
                    TextMessage message = (TextMessage) msg;
                    try {
                        System.out.println("--订阅者一收到消息：" +message.getText());
//                        session.commit();
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            });
//            session.close();
//            connection.close();
        }catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
