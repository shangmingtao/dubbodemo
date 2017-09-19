package cn.milo.dao;

import java.io.Serializable;

/**
 * Created by mac on 2017/9/19.
 */
public class tUser implements Serializable {

    private String usernama;

    private String name;

    public String getUsernama() {
        return usernama;
    }

    public void setUsernama(String usernama) {
        this.usernama = usernama;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
