package com.hdm.cms;

import com.hdm.cms.common.util.PasswordUtil;
import com.hdm.cms.pojo.User;
import com.hdm.cms.service.IUserService;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })

public class Test {

    @Autowired
    private IUserService userService;

    @org.junit.Test
    public void testGet() {
        User user  = userService.get("36a71b0fb8ee11e89c1400acb9eea2e9");
        if(user != null){
            System.out.println(user.getUserName());
            System.out.println(user.getPassword());
        }
    }
    @org.junit.Test
    public void testSelect() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("userName","黄大明");
        List<User> userList  = userService.select(params);
        if(userList != null && !userList.isEmpty()){
            System.out.println(userList.get(0).getUserName());
            System.out.println(userList.get(0).getPassword());
        }
        Assert.assertEquals(userList.size(), 2);
    }
    @org.junit.Test
    public void testInsert() {
        User user = new User();
        user.setUserName("黄大明");
        user.setPassword("123456");
        String encryptPassword = PasswordUtil.makeMD5(user.getPassword());
        user.setPassword(encryptPassword);
        int i = userService.insert(user);
        System.out.println(i);
    }

    @org.junit.Test
    public void testUpdate() {
        User user  = userService.get("36a71b0fb8ee11e89c1400acb9eea2e9");
        user.setUserName("huangdaming");
        int i = userService.update(user);
        System.out.println(i);
    }

    @org.junit.Test
    public void testDelete() {
        int i  = userService.delete("36a71b0fb8ee11e89c1400acb9eea2e9");
        System.out.println(i);
    }

}