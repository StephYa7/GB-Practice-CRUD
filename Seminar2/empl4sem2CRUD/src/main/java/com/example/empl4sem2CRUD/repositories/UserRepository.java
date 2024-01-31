package com.example.empl4sem2CRUD.repositories;

import com.example.empl4sem2CRUD.model.User;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {


    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";


        return jdbc.query(sql, new UserMapper());
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id = ?";
        jdbc.update(sql, id);
    }

    public User getById(int id) {

        String sql = "SELECT * FROM userTable WHERE id = ?";

        User user = jdbc.queryForObject(sql, new Object[]{id}, new UserMapper());
        if (user == null) {
            throw new IllegalArgumentException("User by ID not found");
        }
        return user;
    }
}