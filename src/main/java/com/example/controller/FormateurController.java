package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Service.FormateurService;
import com.example.model.Formateur;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/formateurs")

public class FormateurController {
    @Autowired
    private FormateurService formateurService;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<String> getAll(){
        try {
            String jsonData = objectMapper.writeValueAsString(formateurService.getAll());
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
            return new ResponseEntity<>(jsonData, headers, HttpStatus.OK);
        } catch (JsonProcessingException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getByID(@PathVariable("id") int id){
        try {
            String jsonData = objectMapper.writeValueAsString(formateurService.getByID(id));
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
            return new ResponseEntity<>(jsonData, headers, HttpStatus.OK);
        } catch (JsonProcessingException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Formateur formateur){
        try {
            formateurService.insert(formateur);
            String jsonData = objectMapper.writeValueAsString("Formateur ajouté");
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
            return new ResponseEntity<>(jsonData, headers, HttpStatus.CREATED);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>("Not Found", HttpStatus.INTERNAL_SERVER_ERROR);

        }
        
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Formateur formateur, @PathVariable("id") int id) {
        try {
            Formateur existingFormateur = formateurService.getByID(id);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
            if (existingFormateur == null) {
                return new ResponseEntity<>("{\"error\": \"Formateur not found\"}", headers , HttpStatus.NOT_FOUND);
            }

            if (formateur.getNom() != null) existingFormateur.setNom(formateur.getNom());
            if (formateur.getPrenom() != null) existingFormateur.setPrenom(formateur.getPrenom());
            if (formateur.getEmail() != null) existingFormateur.setEmail(formateur.getEmail());
            if (formateur.getTelephone() != null) existingFormateur.setTelephone(formateur.getTelephone());

            formateurService.update(existingFormateur);
            String jsonData = objectMapper.writeValueAsString("Formateur Modifié");
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
            return new ResponseEntity<>(jsonData, headers, HttpStatus.CREATED);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>("Not Updated", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        try {
            formateurService.delete(id);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
            return new ResponseEntity<>("{\"message\": \"Formateur supprimé\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>("Not Deleted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
