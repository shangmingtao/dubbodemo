package cn.milo.producer;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;

import org.apache.activemq.ActiveMQConnectionFactory;

class JMSTopicProducer {

    public static void main(String[] arg){
        String user = ActiveMQConnection.DEFAULT_USER;
        String password = ActiveMQConnection.DEFAULT_PASSWORD;
        String url = "tcp://118.212.149.60:61616";
        String subject = "mq.topic";
        ActiveMQConnectionFactory amcf = new ActiveMQConnectionFactory(user, password, url);
        try {
            Connection conn = amcf.createConnection();
            conn.start();
            Session session = conn.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
            Destination d = session.createTopic(subject);
            MessageProducer producer = session.createProducer(d);
            for (int i = 0; i <= 20; i++){
                TextMessage message = session.createTextMessage(i+"");
//                Date date = new Date();
//                message.setLong("count" + "     " + i,date.getTime());
//                Thread.sleep(1000);
                producer.send(message);
                System.out.println("--发送消息："  + i);
            }
            session.commit();
            session.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
