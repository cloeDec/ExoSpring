package com.example.wrapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Cours;

public class CoursWrapper implements RowMapper<Cours> {

    @Override
    public Cours mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Cours(
            rs.getInt("Id"), 
            rs.getString("Date_Debut"), 
            rs.getString("Date_Fin")
        );
    }
    
}