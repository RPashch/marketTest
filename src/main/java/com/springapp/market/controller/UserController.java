package com.springapp.market.controller;

import com.springapp.market.model.security.User;
import com.springapp.market.service.security.SecurityService;
import com.springapp.market.service.security.UserService;
import com.springapp.market.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        System.out.println("registration + method = RequestMethod.GET");
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") @Validated User userForm, BindingResult bindingResult, Model model) {
    	System.out.println("registration + method = RequestMethod.POST");
    	userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }
    
/*    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(Model model,String error, String logout) {
         System.out.println("login Method=POST"); 
         if (error != null) {
             model.addAttribute("error", "Username or password is incorrect.");
         }

         if (logout != null) {
             model.addAttribute("message", "Logged out successfully.");
         }
    	return "catalog";
    }
*/
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
    	System.out.println("login + method = RequestMethod.GET");
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	System.out.println("welcome + method = RequestMethod.GET");
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
    	System.out.println("admin + method = RequestMethod.GET");
        return "admin";
    }

}
