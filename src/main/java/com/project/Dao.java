package com.project;

import java.util.ArrayList;

public interface Dao<T> {

    void add(T t);

    T get(int id);
    ArrayList<T> getAll();

    void update(int id, T t);
    
    void delete(int id);

    void print();

    void setNom(int id, String Nom);

    void setAny(int id, int any);

}
