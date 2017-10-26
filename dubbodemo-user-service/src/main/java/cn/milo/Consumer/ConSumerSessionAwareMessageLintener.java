package cn.milo.Consumer;

import cn.milo.dubboserviceImpl.UserServiceImpl;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by mac on 2017/10/27.
 */
@Component
public class ConSumerSessionAwareMessageLintener implements SessionAwareMessageListener<Message> {

    Logger log = Logger.getLogger(ConSumerSessionAwareMessageLintener.class);

    @Autowired
    private JmsTemplate activeMqJmsemplate;

    @Autowired
    private Destination sessionAwareQueue;

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        ActiveMQTextMessage message1 = (ActiveMQTextMessage) message;
        log.info("接到消息 = " + message1.getText());
    }
}
