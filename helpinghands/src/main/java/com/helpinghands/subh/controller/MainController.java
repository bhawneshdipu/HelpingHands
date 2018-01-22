package com.helpinghands.subh.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.helpinghands.subh.model.*;
import com.helpinghands.subh.repository.UserRepository;

@Controller
public class MainController {
	@Autowired
    UserRepository repository;

	@Autowired
	public MailSender mailSender;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(){
    	System.out.println("HEllo Index");
    	return "hello";
    }
    @RequestMapping(value="/signup",method = RequestMethod.GET)
    public String signup(){
        return "signup";
    }
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value="/404",method = RequestMethod.GET)
    public String page404(){
        return "404";
    }
    @RequestMapping(value="/success",method = RequestMethod.GET)
    public String pagesuccess(){
        return "success";
    }
    @RequestMapping(value="/show",method = RequestMethod.GET)
    public String pageshow(){
        return "show";
    }
    
    @RequestMapping(value="/adduser")
    public void adduser(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	System.out.println("Add User Controller");
    	User user=new User();
    	System.out.println("Dipu---------------->"+request.getParameter("name"));
    		user.setName(request.getParameter("name").toString());
    		user.setEmail(request.getParameter("email").toString());
    		user.setPassword(request.getParameter("password").toString());
    		System.out.println("Dipu--------->User:"+user.toString());
    		int x=repository.insert(user);
    		if(x>0) {
    			//send Mail
    			String from = "pati.subhankar7888@gmail.com";
    			String to = user.getEmail();
    			String subject = "JavaMailSender";
    			String body = "Just-Testing!";
    			
    			mailSender.sendMail(from, to, subject, body);
    			System.out.println("MAil Sent:");
    		}
    		System.out.println("Dipu-------->"+x);
    		response.sendRedirect("/success");
			
    		return;
  		
    }
    @RequestMapping(value="/dologin")
    public void dologin(HttpServletRequest request,HttpServletResponse response) throws IOException{
    		System.out.println("PostLogin::");
    		User user=new User();
    		user.setEmail(request.getParameter("email").toString());
    		user.setPassword(request.getParameter("password").toString());
    		user=repository.checkLogin(user);
    		if(user!=null) {  			
	    		
	    		System.out.println("User:"+user.toString());
	    		request.getSession(true).setAttribute("user", user);
	    			response.sendRedirect("/success");
			
	    		return;
	  		}else {
    			System.out.println("Error in Login");
    			response.sendRedirect("/404");
	    		return;
	    	}
    	
    }
  
    
    
    
    
}
