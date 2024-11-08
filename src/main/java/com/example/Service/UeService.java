package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.model.Ue;
import com.example.wrapper.UeWrapper;

@Service
public class UeService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    
   public List<Ue> getAll(){
        String sql = "SELECT * FROM ue;";
        return this.jdbcTemplate.query(sql, new UeWrapper());
   } 

   public Ue getByID(int id){
        String sql = "SELECT * FROM ue WHERE Id= ?";
        return this.jdbcTemplate.queryForObject(sql, new UeWrapper(),id);
   }

   public int insert(Ue ue){
     String sql = "INSERT INTO Ue(Libelle) VALUES (?)";
     return this.jdbcTemplate.update(sql, ue.getLibelle());
   }

   public int update(Ue ue){
     String sql = "UPDATE Ue set Libelle=? WHERE Id=?";
     return this.jdbcTemplate.update(sql, ue.getLibelle(), ue.getId());
   }

   public int delete(int id){
     String sql= "DELETE FROM Ue WHERE Id=?";
     return this.jdbcTemplate.update(sql,id);
   }
   
}
