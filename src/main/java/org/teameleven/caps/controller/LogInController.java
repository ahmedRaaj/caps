/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teameleven.caps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.teameleven.caps.model.User;
import org.teameleven.caps.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ahmedraaj
 */
@Controller
@RequestMapping(value="/login",method = {RequestMethod.GET,RequestMethod.POST})
public class LogInController {
    @Autowired
    UserRepository userDao;
    @RequestMapping(value = "/Mainpage")
    public ModelAndView LoginCaller()
    {
        ModelAndView mv = new ModelAndView("/login");
        return mv;
    }

    @RequestMapping(value="/auth",method = RequestMethod.POST)
    public String AuthenticateAndRoute(@RequestParam("password") String password,@RequestParam("name") String name,RedirectAttributes attrb,HttpServletRequest req){

       // return getDebug(name + password); //for debuging
        String m = "redirect:/";
        User user  = userDao.getAuthenticateUser(name, password);
        if(user != null){
            req.getSession(true).setAttribute("user", user);
            if(user.getRole().equalsIgnoreCase("student")){
                m += "student/Mainpage";
            }
            else if(user.getRole().equalsIgnoreCase("lecturer")){
                m += "lecturer/Mainpage";
            }
            else if(user.getRole().equalsIgnoreCase("admin")){
                m += "admin/Mainpage";
            }
            else{
                m = "redirect:ua";
            }

        }else{
            m = "redirect:ua";
        }
        return m;


    }

    private ModelAndView getDebug(String Message){
        ModelAndView m = new ModelAndView("debug");
        m.addObject("message", Message);
        return m;
    }
    @RequestMapping("/showLogin")
    public String showLogInPage(){
      return   "redirect:/";
    }

    @RequestMapping("/logout")
    public String LogOut(HttpSession session){
        if(session != null)session.invalidate();
        return "redirect:/";
    }
     @RequestMapping("/ua")
    public ModelAndView unauthorizeAccess(){
        return new ModelAndView("unauthorize");
    }
}
