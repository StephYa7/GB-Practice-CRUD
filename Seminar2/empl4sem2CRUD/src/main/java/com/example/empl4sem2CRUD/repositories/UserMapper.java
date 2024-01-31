package com.example.empl4sem2CRUD.repositories;

import com.example.empl4sem2CRUD.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User person = new User();

        person.setId(resultSet.getInt("id"));
        person.setFirstName(resultSet.getString("firstName"));
        person.setLastName(resultSet.getString("lastName"));

        return person;
    }
}