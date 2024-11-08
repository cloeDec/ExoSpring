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

//    public int insert(Etudiant etudiant){
//      String sql = "INSERT INTO Etudiants(Nom,Prenom,Email,Telephone) VALUES (?,?,?,?)";
//      return this.jdbcTemplate.update(sql, etudiant.getNom(), etudiant.getPrenom(), etudiant.getEmail(), etudiant.getTelephone());
//    }

//    public int update(Etudiant etudiant){
//      String sql = "UPDATE Etudiants set Nom=?,Prenom=?,Email=?,Telephone=? WHERE Id=?";
//      return this.jdbcTemplate.update(sql, etudiant.getNom(), etudiant.getPrenom(), etudiant.getEmail(), etudiant.getTelephone(), etudiant.getId());
//    }

//    public int delete(int id){
//      String sql= "DELETE Etudiants WHERE Id=?";
//      return this.jdbcTemplate.update(sql,id);
//    }
   
}
