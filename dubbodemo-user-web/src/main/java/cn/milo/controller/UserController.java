package cn.milo.controller;

import cn.milo.dubboservice.UserService;
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

    @RequestMapping("/user")
    public String User(String username, HttpServletRequest request, HttpServletResponse response){
        log.info("userController Be Visited");
        request.setAttribute("username",userService.getUser(username).getName());
        return "user";
    }
}
