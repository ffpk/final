package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
@Controller
public class AdminController {
    @Autowired
   private AdminService adminService;
    @RequestMapping("/login")
    public String login(HttpSession session, Admin admin,String enCode){
        System.out.println(admin.getName()+""+admin.getPassword());
        Admin login = adminService.login(admin);
        if(login!=null){
            session.setAttribute("login",login);
            String code = (String) session.getAttribute("vrifyCode");
            if(code.equals(enCode)){
                return"redirect:/main/main.jsp";
            }
        }
        return "redirect:/login.jsp";
    }


}