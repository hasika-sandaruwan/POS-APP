package lk.ise.pos.dao;

import lk.ise.pos.db.DBConnection;
import lk.ise.pos.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccessCode {
    //=========Customer Manage Code============
    public boolean saveCustomer(Customer c) throws ClassNotFoundException, SQLException {
        String sql="INSERT INTO customer VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1,c.getId());
        preparedStatement.setString(2,c.getName());
        preparedStatement.setString(3,c.getAddress());
        preparedStatement.setDouble(4,c.getSalary());
        return preparedStatement.executeUpdate()>0;
    }
    public boolean updateCustomer(Customer c) throws ClassNotFoundException, SQLException {
        String sql="UPDATE customer SET name=?, address=?, salary=? WHERE id=?";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1,c.getName());
        preparedStatement.setString(2,c.getAddress());
        preparedStatement.setDouble(3,c.getSalary());
        preparedStatement.setString(4,c.getId());
        return preparedStatement.executeUpdate()>0;
    }
    public Customer findCustomer(String id) throws ClassNotFoundException, SQLException {
        String sql="SELECT * FROM customer WHERE id=?";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            );
        }
        return null;
    }
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM customer WHERE id=?";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1,id);
        return preparedStatement.executeUpdate()>0;
    }
    public List<Customer> allCustomers() throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM customer";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Customer> customerList= new ArrayList<>();
        while (resultSet.next()){
            customerList.add(new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            ));
        }
        return customerList;
    }
    //=========Customer Manage Code============
}
