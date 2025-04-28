package com.lists.examples.two;

import java.util.ArrayList;
import java.util.Iterator;

public class UsuarioList {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User("Alejandro", "Perez", "alejandro@example.com");
        User user2 = new User("Roberto","Opez","roberto@example.com");
        User user3 = new User("Maria","Garcia","maria@example.com");
        User user4 = new User("Juan","Garcia","juan@example.com");
        User user5 = new User("Jose","Garcia","jose@example.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        System.out.println(users);

        for(int i = 0; i < users.size(); i++){
            System.out.println(users.get(i));
        }

        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        User user = findUserByEmail(users, "roberto@example.com");
        System.out.println(user + "Encontrado");
    }

    public static User findUserByEmail(ArrayList<User> users, String email){
        for(User user : users){
            if(user.email.equals(email)){
                return user;
            }
        }

        return null;
    }
}
