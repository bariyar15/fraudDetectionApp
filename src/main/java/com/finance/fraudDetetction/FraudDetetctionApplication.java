package com.finance.fraudDetetction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FraudDetetctionApplication {

	public static void main(String[] args) {
	ApplicationContext context= SpringApplication.run(FraudDetetctionApplication.class, args);
    //context is that IoC container for keeping beans

//        System.out.println("=========== Spring Beans in the application context ========");
//        String[] beanNames= context.getBeanDefinitionNames();
//
//        for(String beanName:beanNames){
//            System.out.println(beanName);
//        }
//        System.out.println("Total Beans:" +beanNames.length);




	}

}
//request pipeLine
//dispatcher servlet-- 1st one to receive req----------> controller(then to the application logic)
//controller-  to the endpoint---> to the service(business logic)---> repository(data access logic layer part)-{pointing to data}

//MOdel--Structure of data, the actual data is in data part