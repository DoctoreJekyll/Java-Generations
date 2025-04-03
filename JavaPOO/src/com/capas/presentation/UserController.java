package com.capas.presentation;

import com.capas.model.User;
import com.capas.services.IUserService;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserController {

    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    public void showUser(int id)
    {
        User user = userService.getUserById(id);
        if (user != null) {
            p(user.toString());
        }else
        {
            p("User not found");
        }
    }

    public void listOfUsers()
    {
        List<User> users = userService.getUsers();
        for (User user : users) {
            p(user.toString());
        }
    }

    public void saveUser(User user)
    {
        userService.save(user);
    }

    public void updateUser(User user)
    {
        userService.updateUser(user);
    }

    public void deleteUser(User user)
    {
        userService.deleteUser(user.getId());
    }


    public void getDNIById(int id)
    {
        User user = userService.getUserById(id);
        if (user != null) {
            p(user.getDni());
        }
        else
        {
            p("User not found");
        }
    }

    public void usersSortedById()
    {
        List<User> usersSorted = userService.getUsers();
        usersSorted.sort(Comparator.comparing(User::getDni));

        for (User user : usersSorted) {
            p(user.toString());
        }
    }

    private void p(String msg) {
        System.out.println(msg);
    }
}
