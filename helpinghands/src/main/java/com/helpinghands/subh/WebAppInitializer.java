package com.helpinghands.subh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;

import com.helpinghands.subh.repository.UserRepository;

import com.helpinghands.subh.controller.MailSender;
@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("com.helpinghands.subh")
public class WebAppInitializer {

	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	    @Autowired
	    UserRepository repository;
		@Autowired
		MailSender mailSender;
    public static void main(String[] args) throws Exception{
        SpringApplication.run(WebAppInitializer.class, args);
    }

	
}

