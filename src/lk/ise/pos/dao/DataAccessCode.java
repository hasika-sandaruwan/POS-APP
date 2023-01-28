package lk.ise.pos.dao;

import lk.ise.pos.dao.util.PasswordConfig;
import lk.ise.pos.db.DBConnection;
import lk.ise.pos.entity.Customer;
import lk.ise.pos.entity.Item;
import lk.ise.pos.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccessCode {
    //=========Customer Manage Code============
    public boolean saveCustomer(Customer c) throws ClassNotFoundException, SQLException {
        return CrudUtil.execute("INSERT INTO customer VALUES(?,?,?,?)",
                c.getId(), c.getName(), c.getAddress(), c.getSalary());
    }

    public boolean updateCustomer(Customer c) throws ClassNotFoundException, SQLException {
        return CrudUtil.execute("UPDATE customer SET name=?, address=?, salary=? WHERE id=?",
                c.getName(), c.getAddress(), c.getSalary(), c.getId());
    }

    public Customer findCustomer(String id) throws ClassNotFoundException, SQLException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM customer WHERE id=?", id);
        if (resultSet.next()) {
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
        return CrudUtil.execute("DELETE FROM customer WHERE id=?", id);
    }

    public List<Customer> allCustomers() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM customer");
        List<Customer> customerList = new ArrayList<>();
        while (resultSet.next()) {
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
    //=========User Manage Code============

    //if data table is empty , then we must trigger the save method.
    public void saveUser() throws SQLException, ClassNotFoundException {
        ResultSet countSet = CrudUtil.execute("SELECT COUNT(*) FROM user");
        if (countSet.next()) {
            int count = countSet.getInt(1);
            if (count == 0) {
                User user1 = new User("linda", new PasswordConfig().encryptPassword("1234"));
                CrudUtil.execute("INSERT INTO user VALUES(?,?)", user1.getUsername(), user1.getPassword());
                User user2 = new User("anna", new PasswordConfig().encryptPassword("1234"));
                CrudUtil.execute("INSERT INTO user VALUES(?,?)", user2.getUsername(), user2.getPassword());
                User user3 = new User("tom", new PasswordConfig().encryptPassword("1234"));
                CrudUtil.execute("INSERT INTO user VALUES(?,?)", user3.getUsername(), user3.getPassword());
            }
        }
    }

    public User findUser(String username) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM user WHERE username=?", username);
        if (resultSet.next()) {
            return new User(resultSet.getString(1), resultSet.getString(2));
        }
        return null;
    }

    //=========User Manage Code============
    //=========Items Manage Code============
    public boolean saveItem(Item i) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "INSERT INTO item VALUES(?,?,?,?)",
                i.getCode(), i.getDescription(), i.getQtyOnHand(), i.getUnitPrice()
        );
    }

    public boolean updateItem(Item i) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "UPDATE item SET description=?, qty_on_hand=?, unit_price=? WHERE code=?",
                i.getDescription(), i.getQtyOnHand(), i.getUnitPrice(), i.getCode()
        );
    }

    public Item findItem(String code) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT * FROM item WHERE code=?", code);
        if (set.next()) {
            return new Item(
                    set.getString(1),
                    set.getString(2),
                    set.getInt(3),
                    set.getDouble(4)
            );
        }
        return null;
    }

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM item WHERE code=?", code);
    }

    public List<Item> allItems() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT * FROM item");
        List<Item> items = new ArrayList<>();
        while (set.next()) {
            items.add(new Item(
                    set.getString(1),
                    set.getString(2),
                    set.getInt(3),
                    set.getDouble(4)
            ));
        }
        return items;
    }
    //=========Items Manage Code============
}
