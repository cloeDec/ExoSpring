package com.example.model;

public class Absence {

    private int id;
    private String date_debut;
    private String date_fin;
    private String type;

    public Absence(int id, String date_debut, String date_fin, String type) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateDebut() {
        return date_debut;
    }

    public void setDateDebut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDateFin() {
        return date_fin;
    }

    public void setDateFin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
