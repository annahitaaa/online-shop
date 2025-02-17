package org.example.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static void main(String[] args) {
//        String username = "admin";
//        String password = "123";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode("admin");
        if(encoder.matches("admin", "$2a$10$V22RSt8u7uhFw504jO8NUOcRfWoaR4G8bFBApShGkjFZUc4BbjD/G")) {
            System.out.println(true);
        }
        System.out.println(encodedPassword);
    }
}
