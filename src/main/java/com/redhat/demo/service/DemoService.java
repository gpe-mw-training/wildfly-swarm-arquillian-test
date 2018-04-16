package com.redhat.demo.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DemoService {
    
    public String sayHello() {

    		return "Hello World!";

    	}    
}
