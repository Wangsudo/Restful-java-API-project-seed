package com.walker.restfulapiprojectseed.pojo;

/**
 * Created by wangshun on 2018/3/18
 **/
public class UserVo {
    private Integer id;

    private String name;

    private String sex;

    public UserVo() {
    }

    public UserVo(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.sex = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String password) {
        this.sex = password;
    }
}
