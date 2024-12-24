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
		
		ApplicationContext ioc =  SpringApplication.run(SpringcoredemoApplication.class, args);
		
		 Order o = ioc.getBean(Order.class);
		 o.setOid(1);
		 o.setOrdername("mobile");
		 o.setStatus("delivered");
		 o.setPrice(100);
		 
		 User u = ioc.getBean(User.class);
		 u.setUid(1);
		 u.setName("vivek");
		 u.setAddrerss("Hyd");
		 
		 System.out.println(u);



		
	}

}
