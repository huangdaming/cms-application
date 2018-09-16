package com.hdm.cms.service.impl;

import com.hdm.cms.mapper.SuperMapper;
import com.hdm.cms.mapper.UserMapper;
import com.hdm.cms.pojo.User;
import com.hdm.cms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends BasicServiceImpl<User, String> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SuperMapper<User, String> getSuperMapper() {
        return userMapper;
    }

    @Override
    public User get(String id) {
        User user = userMapper.get(id);
        return user;
    }

    @Override
    public List<User> select(Map params) {
        List<User> userList = userMapper.query(params);
        return userList;
    }

    @Override
    public int update(User user) {
        int i = userMapper.update(user);
        return i;
    }

    @Override
    public int insert(User user) {
        int i = userMapper.insert(user);
        return i;
    }

    @Override
    public int delete(String id) {
        int i = userMapper.delete(id);
        return i;
    }


}