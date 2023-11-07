package com.project;

import java.util.ArrayList;

public class ObjLlenguatge {
    private int id;
    private String nom;
    private int any;
    private String dificultad;
    private int popularitat;

    

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public void setPopularitat(int popularitat) {
        this.popularitat = popularitat;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getAny() {
        return any;
    }

    public String getDificultad() {
        return dificultad;
    }

    public int getPopularitat() {
        return popularitat;
    }

    public ObjLlenguatge(int i, String n, int a, String d, int p) {
        this.id = i;
        this.nom = n;
        this.any = a;
        this.dificultad = d;
        this.popularitat = p;
    }

}

