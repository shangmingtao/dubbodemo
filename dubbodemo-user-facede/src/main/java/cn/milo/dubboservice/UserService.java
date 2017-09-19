package cn.milo.dubboservice;

import cn.milo.dao.tUser;

/**
 * Created by mac on 2017/9/17.
 */
public interface UserService {

    public tUser getUser(String username);
}
