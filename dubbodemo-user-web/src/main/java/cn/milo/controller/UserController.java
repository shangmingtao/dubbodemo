package cn.milo.controller;

import cn.milo.dubboservice.UserService;
import cn.milo.spring_producer.QueueSpringProducer;
import cn.milo.spring_producer.TopicSpringProducer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mac on 2017/9/17.
 */

@Controller
public class UserController {

    Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private QueueSpringProducer queueSpringProducer;


    @Autowired
    private TopicSpringProducer topicSpringProducer;

    @RequestMapping("/user")
    public String User(String username, String model , HttpServletRequest request, HttpServletResponse response){
        log.info("userController Be Visited");

        if (model.equals("queue")){
            queueSpringProducer.SpringQueueSend(username);
        }else if (model.equals("topic")){
            topicSpringProducer.SpringTopicSend(username);
        }else {
            log.info("activemq 消息发送模式不能识别");
        }


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
