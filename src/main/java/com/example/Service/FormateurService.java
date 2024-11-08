package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.model.Formateur;
import com.example.wrapper.FormateurWrapper;

@Service
public class FormateurService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    
   public List<Formateur> getAll(){
        String sql = "SELECT * FROM Formateurs;";
        return this.jdbcTemplate.query(sql, new FormateurWrapper());
   } 

   public Formateur getByID(int id){
        String sql = "SELECT * FROM Formateurs WHERE Id= ?";
        return this.jdbcTemplate.queryForObject(sql, new FormateurWrapper(),id);
   }

//    public int insert(Etudiant etudiant){
//      String sql = "INSERT INTO Formateurs(Nom,Prenom,Email,Telephone) VALUES (?,?,?,?)";
//      return this.jdbcTemplate.update(sql, etudiant.getNom(), etudiant.getPrenom(), etudiant.getEmail(), etudiant.getTelephone());
//    }

//    public int update(Etudiant etudiant){
//      String sql = "UPDATE Formateurs set Nom=?,Prenom=?,Email=?,Telephone=? WHERE Id=?";
//      return this.jdbcTemplate.update(sql, etudiant.getNom(), etudiant.getPrenom(), etudiant.getEmail(), etudiant.getTelephone(), etudiant.getId());
//    }

//    public int delete(int id){
//      String sql= "DELETE Formateurs WHERE Id=?";
//      return this.jdbcTemplate.update(sql,id);
//    }
   
}
