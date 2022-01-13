package com.example.addressbookserver.service;

import com.example.addressbookserver.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeopleManager {
    private static final PeopleManager instance = new PeopleManager();
    private final List<User> userList;

    private PeopleManager() {
        userList = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setGender("男");
        user.setName("仲崇滔");
        user.setTelephone(123123123);
        userList.add(user);

        user = new User();
        user.setId(2);
        user.setGender("男");
        user.setName("秦国海");
        user.setTelephone(12312333);
        userList.add(user);
    }

    public static PeopleManager getInstance() {
        return instance;
    }

    public List<User> getUsers() {
        Connection conn = null;
        ResultSet resultSet = null;
        Statement statement = null;
        List<User> users = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:F:\\addressbook\\addressbook_server\\addressbookserver\\DataBase\\addressbook.sqlite");
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT id, name, telephone, gender FROM user");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setGender(resultSet.getString("gender"));
                user.setTelephone(resultSet.getInt("telephone"));
                users.add(user);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }


        try {
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;
    }

    int addUser(User user) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:F:\\addressbook\\addressbook_server\\addressbookserver\\DataBase\\addressbook.sqlite");

            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO user (name, telephone, gender) VALUES (?,?,?)");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setInt(2,user.getTelephone());
            preparedStatement.setString(3,user.getGender());
            preparedStatement.execute();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 1;
    }

    public boolean deleteUser(int id) {

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:F:\\addressbook\\addressbook_server\\addressbookserver\\DataBase\\addressbook.sqlite");

            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM user WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}
