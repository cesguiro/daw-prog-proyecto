package com.cipfpmislata.proyecto3evaluacion.persistence.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.cipfpmislata.proyecto3evaluacion.database.DBUtil;
import com.cipfpmislata.proyecto3evaluacion.domain.entity.User;
import com.cipfpmislata.proyecto3evaluacion.persistence.UserRepository;

public class UserRepositoryImplJDBC implements UserRepository{

    @Override
    public boolean create(User user) {
        try {
            Connection connection = DBUtil.open();
            String sql = "INSERT INTO users (name, mail, password) VALUES (?, ?, ?)";
            List<Object> params = List.of(user.getName(), user.getMail(), user.getPassword());
            boolean result = DBUtil.insert(connection, sql, params);
            DBUtil.close(connection);
            return result;
        } catch (SQLIntegrityConstraintViolationException e){
            throw new RuntimeException("Usuario ya registrado");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
