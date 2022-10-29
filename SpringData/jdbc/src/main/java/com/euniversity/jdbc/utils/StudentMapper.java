package com.euniversity.jdbc.utils;

import com.euniversity.jdbc.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Student(
                rs.getLong("id"),
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getInt("age"),
                rs.getString("department")
        );
    }
}
