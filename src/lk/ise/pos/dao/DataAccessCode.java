package lk.ise.pos.dao;

import lk.ise.pos.entity.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DataAccessCode {
    //=========Customer Manage Code============
    public boolean saveCustomer(Customer c) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.cj.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos",
                "root","1234");
        String sql="INSERT INTO customer VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,c.getId());
        preparedStatement.setString(1,c.getName());
        preparedStatement.setString(1,c.getAddress());
        preparedStatement.setDouble(1,c.getSalary());
        return preparedStatement.executeUpdate()>0;
    }
    public boolean updateCustomer(Customer c){}
    public Customer findCustomer(String id){}
    public boolean deleteCustomer(String id){}
    public List<Customer> allCustomers(){}
    //=========Customer Manage Code============
}
