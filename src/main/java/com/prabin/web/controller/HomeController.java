/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.web.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Prasbin
 */
@Controller
@RequestMapping(value = {"/","/home"})
public class HomeController {
    
    @GetMapping
    public String index(Model model){
        model.addAttribute("name", "Prabin Spring Project");
        return "index";
    }
    
    @GetMapping(value = "/about")
    public ModelAndView about(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("about");
        mv.addObject("name", "Prabin");
        mv.addObject("colors", new String[]{"red","green","blue","yellow"});
        mv.addObject("date", new Date());
        return mv;
    }
    
    @GetMapping(value = "/contact")
    @ResponseBody
    public String contact(){
        return "<h1>Contact US page</h1>";
    }
}
