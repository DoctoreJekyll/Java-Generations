package org.example.mapper;

import org.example.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements BaseMapper<Customer> {
    @Override
    public Customer toModel(ResultSet rs) {
        Customer customer = new Customer();

        try {
            customer.setId(rs.getLong("ID_CUSTOMER"));
            customer.setFirstName(rs.getString("FIRST_NAME"));
            customer.setLastName(rs.getString("LAST_NAME"));
            customer.setEmail(rs.getString("EMAIL"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }
}
