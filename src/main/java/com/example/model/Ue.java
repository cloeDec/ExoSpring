package com.example.model;

public class Ue {

    private int id;
    private String libelle;

    public Ue(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Ue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
