package lk.ise.pos.dao.custom.impl;

import lk.ise.pos.dao.custom.UserDao;
import lk.ise.pos.entity.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean save(User user) throws Exception {
        return false;
    }

    @Override
    public boolean update(User user) throws Exception {
        return false;
    }

    @Override
    public User find(String s) throws Exception {
        return null;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public List<User> findAll() throws Exception {
        return null;
    }
}
