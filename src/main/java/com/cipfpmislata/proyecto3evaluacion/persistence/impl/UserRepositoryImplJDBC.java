package com.cipfpmislata.proyecto3evaluacion.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cipfpmislata.proyecto3evaluacion.database.DBUtil;
import com.cipfpmislata.proyecto3evaluacion.domain.entity.User;
import com.cipfpmislata.proyecto3evaluacion.persistence.UserRepository;

public class UserRepositoryImplJDBC implements UserRepository{

    @Override
    public boolean create(User user) {
        Connection connection = DBUtil.open();
        String sql = "INSERT INTO users (id, name, mail, password) VALUES (?, ?, ?, ?)";
        List<Object> params = List.of(user.getId(), user.getName(), user.getMail(), user.getPassword());
        boolean result = DBUtil.insert(connection, sql, params);
        DBUtil.close(connection);
        return result;
    }

    @Override
    public User findByMail(String mail) {
        try{
            Connection connection = DBUtil.open();
            String sql = "SELECT * FROM users WHERE mail = ?";
            List<Object> params = List.of(mail);
            ResultSet resultSet = DBUtil.select(connection, sql, params);
            if (resultSet.next()) {
                User user = new User(
                    resultSet.getString("id"), 
                    resultSet.getString("name"),
                    resultSet.getString("mail"),
                    resultSet.getString("password")                    
                );
                return  user;                    
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
