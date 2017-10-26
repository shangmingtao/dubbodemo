package cn.milo.controller;

import cn.milo.dubboservice.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by mac on 2017/9/17.
 */

@Controller
public class UserController {

    Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private JmsTemplate notifyJmsTemplate;

    @RequestMapping("/user")
    public String User(final String username, HttpServletRequest request, HttpServletResponse response){
        log.info("userController Be Visited");


        notifyJmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(username);
            }
        });

        System.out.println(username);

        request.setAttribute("username",userService.getUser(username).getName());

        return "user";
    }

    /**
     * 成本订单保存
     *
     * @return
     */
    public static void caculate(final String name ) {

    }

}
