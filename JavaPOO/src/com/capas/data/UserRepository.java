package com.capas.data;

import com.capas.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserRepository implements IUserRepository{

    ArrayList<User> users = new ArrayList<User>();

    public UserRepository() {
        users = new ArrayList<>();
        User u1 = new User(1,"Taz","Rad","22234F");
        User u2 = new User(2,"Toz","Rod","33441G");
        User u3 = new User(3,"Tez","Red","55663H");
        User u4 = new User(4,"Tiz","Rid","11111I");
        User u5 = new User(5,"Tuz","Rud","66356O");

        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public User getUserById(int id) {
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User user = it.next();
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    @Override
    public User updateUser(User userParam) {
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User user = it.next();
            if (user.getId() == userParam.getId()) {
                users.remove(user);
                users.add(userParam);
                return userParam;
            }
        }

        return null;
    }

    @Override
    public void deleteUser(int id) {
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User user = it.next();
            if (user.getId() == id) {
                users.remove(user);
            }
        }
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
