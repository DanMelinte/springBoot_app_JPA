package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.example.springboot")
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

//        ApplicationContext context = SpringApplication.run(NewsManagementApplication.class, args);
//        NewsManagementMenu menu = context.getBean(NewsManagementMenu.class);
//        menu.setScanner(new Scanner(System.in));
//        menu.runMenu();

    }
}
