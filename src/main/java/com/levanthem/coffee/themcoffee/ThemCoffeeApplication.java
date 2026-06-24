package com.levanthem.coffee.themcoffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Class nay la class trung tam , noi chua khai bao ve cac loai bean co trong app nay, bean la nhung object dependency
//duoc IoC container tuwj new , hay minh tu new va gui cho container giu giup.
// Dependency object la nhung class cos @Component, @Service , @Repository, @Controller, @RestController
//@Spring boot Application gop san 3@ khac,
//@Configuration, @ComponentScan, @EnableAutoConfiguration
// Khoi dong tomcat, hibenat JPA.


public class ThemCoffeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThemCoffeeApplication.class, args);
    }

}
