package com.capas.services;

import com.capas.data.IUserRepository;
import com.capas.data.UserRepository;
import com.capas.model.User;

import java.util.List;

public class UserService implements IUserService{

    IUserRepository userRepo;

    public UserService(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepo.getUserById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepo.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.getUsers();
    }

    @Override
    public String getCompleteName(int id) {
        User userByID = userRepo.getUserById(id);
        if (userByID != null) {
            return userByID.getName() + " " + userByID.getLastName();
        }
        else
        {
         return "El usuario no existe";
        }
    }

    @Override
    public String getReverseCompleteName(int id) {
        User userByID = userRepo.getUserById(id);
        String name = userByID.getName();
        String lastName = userByID.getLastName();

        return reverseString(name) + " " + reverseString(lastName);
    }

    private String reverseString(String str) {
        char[] chars = str.toCharArray();
        char[] reverseChars = new char[chars.length];
        int index = 0;

        for (int i = chars.length - 1; i >= 0; i--) {
            reverseChars[index] = chars[i];
            index++;
        }

        return new String(reverseChars);
    }
}
