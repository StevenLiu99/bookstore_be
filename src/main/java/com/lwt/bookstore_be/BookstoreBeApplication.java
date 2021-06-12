package com.lwt.bookstore_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class BookstoreBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreBeApplication.class, args);
    }

}
