package cn.milo.dubboserviceImpl;

import cn.milo.dubboservice.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by mac on 2017/9/17.
 */

@Service("userFacede")
public class UserServiceImpl implements UserService{

    Logger log = Logger.getLogger(UserServiceImpl.class);

    public String getUser(String username) {
        log.info("UserService Be Visited");
        if (username.equals("milo")){
            return "hello milo";
        }else{
            return "hello guest";
        }
    }
}
