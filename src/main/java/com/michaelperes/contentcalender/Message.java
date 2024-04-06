package com.michaelperes.contentcalender;


import org.springframework.stereotype.Component;

// Now the application context will know about this class and add it to its IoC container.
// Now it's a bean with camel case of the public class name. By default, it's a singleton of this application etc.
// There specialist versions of this annotation which we call a decorator in Python, such as Service, RestController, etc.

@Component
public class Message {

    public String getMessage() {
        return "Hello World!";
    }
}
