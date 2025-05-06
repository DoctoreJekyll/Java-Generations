package org.example;

import org.example.bootsraps.InitDataBase;
import org.example.dao.CustomerDao;
import org.example.model.Customer;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        InitDataBase.init();
        CustomerDao dao = new CustomerDao();
        Customer customer  = new Customer();

        customer.setFirstName("Jarma");
        customer.setLastName("Mahmoud");
        customer.setEmail("<EMAIL>");

        dao.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Jarma2");
        customer2.setLastName("Mahmoud2");
        customer2.setEmail("<EMAIL>");

        dao.save(customer2);

        List<Customer> customers = dao.findAll();
        customers.forEach(System.out::println);
    }
}
