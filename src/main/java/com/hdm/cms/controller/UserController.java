package com.hdm.cms.controller;

import com.hdm.cms.pojo.User;
import com.hdm.cms.service.IUserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/viewUser")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("user/viewUser");
        Map<String, String> params = new HashMap<String, String>();
        params.put("userName","黄大明");
        List<User> userList = userService.select(params);
        mv.addObject("userList",userList);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value="/query")
    public String query(){
        Map<String, String> params = new HashMap<String, String>();
        params.put("userName","黄大明");
        List<User> userList = userService.select(params);
        JSONObject jobj = new JSONObject();//new一个JSON
        jobj.accumulate("total",userList.size() );//total代表一共有多少数据
        jobj.accumulate("rows", userList);//row是代表显示的页的数据
        String test = jobj.toString();
        return jobj.toString();
    }
}