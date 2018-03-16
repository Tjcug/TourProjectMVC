package com.tour.controller;

import com.tour.model.Administrator;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by dell-pc on 2016/4/22.
 */

@Controller
@Transactional(propagation= Propagation.REQUIRED)
@RequestMapping("/admin")

@SessionAttributes(value = {"admin"},types = {Administrator.class})
public class AdministratorController extends BaseController{

    /**
     * 后台登录的控制器
     * @param username 用户名
     * @param password 密码
     * @param modelAndView 模型控制器
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password,
                              Map map, ModelAndView modelAndView){
        modelAndView.setViewName("manage/login");
        if(!username.equals("")&!password.equals("")) {
            Administrator admin = tAdministratorService.findadminByusernameAndPass(username, password);
            if(admin!=null) {
                map.put("admin",admin);
                modelAndView.setViewName("redirect:/manage__aindex");
            }
            else {
                modelAndView.addObject("error","用户名或者密码错误");
            }
        }
        return modelAndView;
    }

}
