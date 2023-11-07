package com.project;

import java.util.ArrayList;

public class ObjSoftware {
    private int id;
    private String nom;
    private int any;
    private ArrayList<Integer> llenguatges;


    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public void setLlenguatges(ArrayList<Integer> llenguatges) {
        this.llenguatges = llenguatges;
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

    public ArrayList<Integer> getLlenguatges() {
        return llenguatges;
    }

    public ObjSoftware(int i, String n, int a, ArrayList<Integer> l) {
        this.id = i;
        this.nom = n;
        this.any = a;
        this.llenguatges = l;
    }

    public ArrayList<Integer> getEines() {
        return llenguatges;
    }
}
