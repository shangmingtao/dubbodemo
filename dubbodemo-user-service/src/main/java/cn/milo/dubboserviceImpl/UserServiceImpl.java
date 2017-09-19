package cn.milo.dubboserviceImpl;

import cn.milo.dubboservice.UserService;
import cn.milo.dao.tUser;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by mac on 2017/9/17.
 */

@Service("userFacede")
public class UserServiceImpl implements UserService{

    Logger log = Logger.getLogger(UserServiceImpl.class);

    public tUser getUser(String username) {
        log.info("UserService Be Visited");
        tUser user = new tUser();
        user.setUsernama(username);
        if (username.equals("milo")){
            user.setName("hello milo");
        }else{
            user.setName("hello guest");
        }
        return user;
    }
}
