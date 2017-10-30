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
public class JMSSpringQueueListener implements SessionAwareMessageListener<Message> {

    Logger log = Logger.getLogger(JMSSpringQueueListener.class);

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        ActiveMQTextMessage message1 = (ActiveMQTextMessage) message;
        log.info("spring queue comsumer 接到消息 = " + message1.getText());
    }
}
