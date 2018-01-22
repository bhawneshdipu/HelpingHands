package com.helpinghands.subh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.helpinghands.subh.model.User;
import com.helpinghands.subh.repository.UserRepository;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
@RestController
public class MyRestController {

	@Autowired
    UserRepository repository;

	@Autowired
	public MailSender mailSender;

	  @RequestMapping(value="/showusers",method=RequestMethod.GET)
	    public String showUsers() {
	    	List<User> listuser=repository.findAll();
	    	JsonArray json=new JsonArray();
	    	for(User u :listuser) {
	    		JsonObject temp=new JsonObject();
	    		
	    		temp.addProperty("id", u.getId());
	    		temp.addProperty("name", u.getName());
	    		temp.addProperty("email", u.getEmail());
	    	//	temp.addProperty("password", u.getPassword());
	    		
	    		json.add(temp);
	    		
	    	}
	    	System.out.println("Json Data:"+json.toString());
	    	return json.toString();
	    }
}
