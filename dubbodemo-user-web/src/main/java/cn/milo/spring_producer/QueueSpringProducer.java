package cn.milo.spring_producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by admin on 2017/10/30.
 */

@Service
public class QueueSpringProducer {

    @Autowired
    private JmsTemplate queueJmsTemplate;


    public void SpringQueueSend(final String message){
        queueJmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
