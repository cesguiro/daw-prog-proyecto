package com.cipfpmislata.proyecto3evaluacion.database;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBUtil {

    public static final String DBHost = System.getenv("DBHOST");
    public static final String DBName = System.getenv("DBNAME");
    public static final String DBUser = System.getenv("DBUSER");
    public static final String DBPasswd = System.getenv("DBPASSWD");

    private static DataSource datasource;
    public static DataSource getDataSource(){
        if(datasource == null){
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
            dataSource.setUrl("jdbc:mariadb://" + DBHost + "/" + DBName);
            dataSource.setUsername(DBUser);
            dataSource.setPassword(DBPasswd);
            datasource = dataSource;
        }
        return datasource;
    }
    
    public static Connection open(){
        System.out.println("Conectando con la base de datos...");

        Connection connection;
        try {
            connection = DriverManager.getConnection(
                "jdbc:mariadb://" + DBHost + "/" + DBName,
                DBUser,
                DBPasswd
            );
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static void close(Connection connection) {
        try {
            System.out.println("Cerrando la conexión con la base de datos...");

            connection.close();

            System.out.println("Estado de la conexión: " + connection.isValid(0));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet select(Connection connection, String sql, List<Object> values) {
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            return preparedStatement.executeQuery();            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean insert(Connection connection, String sql, List<Object> values) {    
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static int update(Connection connection, String sql, List<Object> values) {    
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            int numRows = preparedStatement.executeUpdate();
            return numRows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement setParameters(Connection connection, String sql, List<Object> values){
        try {
            PreparedStatement preparedStatement =  connection.prepareStatement(sql);
            if(values != null) {
                for(int i=0;i<values.size();i++) {
                    Object value=values.get(i);
                    preparedStatement.setObject(i+1,value);
                }
            }    
            return preparedStatement;                        
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean delete(Connection connection, String sql, List<Object> values) {
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
