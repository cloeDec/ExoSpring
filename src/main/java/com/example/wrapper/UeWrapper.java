package com.example.wrapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Ue;

public class UeWrapper implements RowMapper<Ue> {

    @Override
    public Ue mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Ue(
            rs.getInt("Id"), 
            rs.getString("Libelle")
        );
    }
    
}