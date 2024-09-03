package org.restaurantapp;

import org.springframework.boot.SpringApplication;

public class TestRestaurantBackendApplication {

    public static void main(String[] args) {
        SpringApplication.from(RestaurantBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
