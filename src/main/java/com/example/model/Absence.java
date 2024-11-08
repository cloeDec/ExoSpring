package com.example.model;

public class Absence {

    private int id;
    private String dateDebut;
    private String dateFin;
    private String type;
    private int fkEtudiant;

    public Absence(int id, String dateDebut, String dateFin, String type, int fkEtudiant) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.type = type;
        this.fkEtudiant = fkEtudiant;
    }

    public Absence() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFkEtudiant() {
        return fkEtudiant;
    }

    public void setFkEtudiant(int fkEtudiant) {
        this.fkEtudiant = fkEtudiant;
    }

}
