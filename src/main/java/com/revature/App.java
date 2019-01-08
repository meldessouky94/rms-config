package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The Class App.
 * Spring boot application that enables 
 * the configuration server.bSpring Cloud 
 * Config provides server and client-side 
 * support for externalized configuration 
 * in a distributed system. With the Config 
 * Server you have a central place to manage 
 * external properties for applications 
 * across all environments.
 * 
 * @author 1811-Java-Nick | 12/27/2018
 */
@SpringBootApplication
@EnableConfigServer
public class App {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

}
