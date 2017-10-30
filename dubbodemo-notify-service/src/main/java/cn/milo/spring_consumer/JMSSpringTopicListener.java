package cn.milo.spring_consumer;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.log4j.Logger;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by mac on 2017/10/27.
 */
@Component
public class JMSSpringTopicListener implements SessionAwareMessageListener<Message> {

    Logger log = Logger.getLogger(JMSSpringTopicListener.class);

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        ActiveMQTextMessage message1 = (ActiveMQTextMessage) message;
        if (message1.getText().equals("1")){
            throw new RuntimeException("exception 1111");
        }else{
            log.info("spring topic comsumer 接到消息 = " + message1.getText());
        }
    }
}
