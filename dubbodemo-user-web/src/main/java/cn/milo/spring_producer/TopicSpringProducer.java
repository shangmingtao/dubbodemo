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
public class TopicSpringProducer {

    @Autowired
    private JmsTemplate topicJmsTemplate;

    public void SpringTopicSend(final String message){
        topicJmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

}
