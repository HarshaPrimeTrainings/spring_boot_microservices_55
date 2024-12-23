package com.training.springcoredemo;

import org.learning.ExternalClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.training.springcoredemo.services.Order;

@SpringBootApplication
@ComponentScan(basePackages = {"com.training.springcoredemo","org.learning"})
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ioc = SpringApplication.run(SpringcoredemoApplication.class, args);
		
		User u = ioc.getBean(User.class);
		u.setUid(1);
		u.setName("vivek");
		u.setAddrerss("Hyd");

		Order o1 = ioc.getBean(Order.class);
		o1.setOid(1);
		o1.setOrdername("Mobile");
		o1.setStatus("Delivered");
		
		Order o2 = ioc.getBean(Order.class);
		o2.setOid(2);
		o2.setOrdername("Earbuds");
		o2.setStatus("Shipped");
		
		System.out.println(u +" :: "+ o1 + " :: "+ o2);
		
		
	}

}
