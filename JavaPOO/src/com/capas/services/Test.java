package com.capas.services;

import com.capas.data.IUserRepository;
import com.capas.data.UserRepository;

public class Test {
    public static void main(String[] args) {
        IUserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        System.out.println(userService.getReverseCompleteName(2));
    }
}
