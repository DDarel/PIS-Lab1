package DAO;

import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import Connection.ConnectionPool;

public class UserDAOImpl implements UserDAO{

    ConnectionPool connection = new ConnectionPool();

    public UserDAOImpl() throws SQLException {
    }

    public User get(int id) throws SQLException {
        Connection con = connection.getConnection();
        User user = null;
        String sql = "SELECT user_id, user_name, user_surname FROM cinema.users WHERE user_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            int user_id = rs.getInt("user_id");
            String user_name = rs.getString("user_name");
            String user_surname = rs.getString("user_surname");
            user = new User(user_id, user_name, user_surname);
        }
        return user;
    }

    public List<User> getAll() throws SQLException {
        return null;
    }

    public int save(User user) throws SQLException {
        return 0;
    }

    public int insert(User user) throws SQLException {
        Connection con = connection.getConnection();
        String sql = "INSERT INTO users (user_name, user_surname) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getSurname());
        int result = ps.executeUpdate();
        return result;
    }

    public int update(User user) throws SQLException {
        return 0;
    }

    public int delete(User user) {
        return 0;
    }
}
