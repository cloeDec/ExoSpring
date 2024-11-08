package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.model.Absence;
import com.example.wrapper.AbsenceWrapper;

@Service
public class AbsenceService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    
   public List<Absence> getAll(){
        String sql = "SELECT * FROM Absences;";
        return this.jdbcTemplate.query(sql, new AbsenceWrapper());
   } 

   public Absence getByID(int id){
        String sql = "SELECT * FROM Absences WHERE Id= ?";
        return this.jdbcTemplate.queryForObject(sql, new AbsenceWrapper(),id);
   }

   public int insert(Absence absence){
     String sql = "INSERT INTO Absences(Date_Debut,Date_Fin,Type) VALUES (?,?,?,?)";
     return this.jdbcTemplate.update(sql, absence.getDateDebut(), absence.getDateFin(), absence.getType());
   }

   public int update(Absence absence){
     String sql = "UPDATE Absences set Date_Debut=?,Date_Fin=?,Type=? WHERE Id=?";
     return this.jdbcTemplate.update(sql, absence.getDateDebut(), absence.getDateFin(), absence.getType(), absence.getId());
   }

   public int delete(int id){
     String sql= "DELETE Absences WHERE Id=?";
     return this.jdbcTemplate.update(sql,id);
   }
   
}