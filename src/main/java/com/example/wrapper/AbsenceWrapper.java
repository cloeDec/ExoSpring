package com.example.wrapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Absence;

public class AbsenceWrapper implements RowMapper<Absence> {

    @Override
    public Absence mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Absence(
            rs.getInt("Id"), 
            rs.getString("Date_Debut"), 
            rs.getString("Date_Fin"), 
            rs.getString("Type")
        );
    }
    
}