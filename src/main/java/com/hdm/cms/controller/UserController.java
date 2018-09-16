package com.hdm.cms.controller;

import com.hdm.cms.common.util.StringUtil;
import com.hdm.cms.pojo.User;
import com.hdm.cms.service.IUserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/viewUser")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("user/viewUser");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value="/query")
    public String query(){
        Map<String, String> params = new HashMap<String, String>();
        List<User> userList = iUserService.select(params);
        JSONObject json = new JSONObject();//new一个JSON
        json.accumulate("total",userList.size() );//total代表一共有多少数据
        json.accumulate("rows", userList);//row是代表显示的页的数据
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public Map<String, Object> save(User user) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            int flag;
            if (StringUtil.isEmpty(user.getId())){
                //user.setCreator(UserUtil.getCurrentUser().getId());
                //user.setCreateTime(new Date());
                //user.setDeleteflag(0);
                flag = iUserService.insert(user);
            }else
                flag = iUserService.update(user);
            String msg;
            boolean success = false;
            if (flag>0) {
                success = true;
                msg = "保存成功!";
            } else {
                success = false;
                msg = "保存失败!";
            }
            result.put("success", success);
            result.put("msg", msg);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/delete")
    public Map<String,Object> delete(@RequestParam("id") String id) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            this.iUserService.delete(id);
            result.put("success", true);
            result.put("msg", "删除成功！");
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", "删除失败！");
        }
        return result;
    }
}