package com.michaelperes.contentcalender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication   // decorators/annotations will remove the need of XML, but does something's to the class.
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);  // This runs and gives us a application context.

		// Now we can also get all the beans running on our project, which is done by using the command:

		System.out.println("All Bean Definitions for Project");
		// Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);  // Stream is so we can use it sequentially like for each, like making an iterator, which is built in to each array, duck typing.

		// To experiment with this, now that I have a bean and its name we can use it.
		RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
		System.out.println(restTemplate);





	}

	// More functionality of the application.


}


// https://www.youtube.com/watch?v=HvPlEJ3LHgE  Abstract Classes and Methods in Java Explained.
// In abstract classes you can't instantiate classes, you can only use them as blueprints for other classes.

// Abstract and Interface,
// Interface Animal, every method in interface is assumed abstract, class implements Interface Class.
// The differences are classes can implement many interfaces but only extend one abstract class.
// Every attribute defined in an interface will be static and final, so must be instantiated. Same value applies to every class.

// So why do abstract classes, so in abstract is can have a specific variable that isn't static and final.
// Abstract is you have a lot of related classes, a interface is you have a lot of unrelated classes.

// Spring-boot using Tomcat initialized with port 8080 (http) to run the webserver.

