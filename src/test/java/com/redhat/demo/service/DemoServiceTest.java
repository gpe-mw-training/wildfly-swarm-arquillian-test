package com.redhat.demo.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Properties;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.arquillian.CreateSwarm;

import com.redhat.demo.service.DemoService;

@RunWith(Arquillian.class)
public class DemoServiceTest {

    @Inject
    private DemoService demoService;
    
    private static String port="18081";

    @CreateSwarm
    public static Swarm newContainer() throws Exception {
    	
        Properties properties = new Properties();
        properties.put("swarm.http.port", port);
        return new Swarm(properties);
    }
    
    @Deployment
    public static Archive<?> createDeployment() {

    		return ShrinkWrap.create(WebArchive.class)
                .addPackages(true, DemoService.class.getPackage());
    }
    
    @Test
    public void sayHello() throws Exception {
    	
        assertThat(demoService, notNullValue());
        String message = demoService.sayHello();
        assertThat(message, notNullValue());
    }   
        
}
