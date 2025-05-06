package org.example.dao;

import org.example.db.DBConnection;
import org.example.mapper.CustomerMapper;
import org.example.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CustomerDao implements CrudDao<Customer, Long> {


    private Connection connection;
    private CustomerMapper customerMapper;

    public CustomerDao() {
        this.connection = DBConnection.getConnection();
        this.customerMapper = new CustomerMapper();
    }


    @Override
    public void save(Customer entity) {
        String sql = "INSERT INTO CUSTOMERS (FIRST_NAME, LAST_NAME, EMAIL) VALUES (?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2,entity.getLastName());
            preparedStatement.setString(3,entity.getEmail());
            preparedStatement.execute();
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }

    }

    @Override
    public Customer update(Customer entity) {
        String sql = "UPDATE CUSTOMERS SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ? WHERE ID_CUSTOMER = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2,entity.getLastName());
            preparedStatement.setString(3,entity.getEmail());
            preparedStatement.setLong(4,entity.getId());
            preparedStatement.executeUpdate();
            return entity;
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }

        return null;

    }

    @Override
    public Optional<Customer> findById(Long id) {

        Customer customer = null;
        String sql = "SELECT * FROM CUSTOMERS WHERE ID_CUSTOMER = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                customer = customerMapper.toModel(resultSet);
            }
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }

        return Optional.ofNullable(customer);
        //return Objects.nonNull(customer) ? Optional.of(customer) : Optional.empty();

    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM CUSTOMERS";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                customers.add(customerMapper.toModel(resultSet));
            }
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return customers;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM CUSTOMERS WHERE ID_CUSTOMER = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {

        String sql = "DELETE FROM CUSTOMERS";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.execute();
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }

    }
}
