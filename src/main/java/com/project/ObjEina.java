package com.project;

import java.util.ArrayList;

public class ObjEina {
    private int id;
    private int any;
    private ArrayList<Integer> llenguatges;

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

    private String nom;
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

    public ObjEina(int i, String n, int a, ArrayList<Integer> l) {
        this.id = i;
        this.nom = n;
        this.any = a;
        this.llenguatges = l;
    }
}
