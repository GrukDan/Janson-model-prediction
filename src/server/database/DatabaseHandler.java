package server.database;

import client.Objects.User;
import server.database.entities.UserEntity;

import java.sql.*;

public class DatabaseHandler extends DatabaseConfig {

    Connection dbConection;

    public Connection getDbConection() {

        String connectionURL = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            dbConection = DriverManager.getConnection(connectionURL, dbUser, dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConection;
    }

    public void registrationUser(User user) {

        String insertSQL = "INSERT INTO " + UserEntity.USER_TABLE + "(" +
                UserEntity.NAME + "," + UserEntity.SURNAME + "," + UserEntity.ROLE + "," +
                UserEntity.LOGIN + "," + UserEntity.PASSWORD + ")" + " VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConection().prepareStatement(insertSQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ResultSet getUserByLoginAndPassword(String login,String password) {
        ResultSet resultSet = null;
        String selectSQL = "SELECT * FROM " + UserEntity.USER_TABLE + " WHERE " +
                UserEntity.LOGIN + "=? AND " + UserEntity.PASSWORD + "=?";
        try {
            PreparedStatement preparedStatement = getDbConection().prepareStatement(selectSQL);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void closeConnection() {
        try {
            dbConection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
