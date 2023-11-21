package com.project;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class DaoLlenguatge implements Dao<ObjLlenguatge>{

    private void writeList(ArrayList<ObjLlenguatge> llista) {
        try {
            JSONArray jsonArray = new JSONArray();
            for (ObjLlenguatge llenguatge : llista) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", llenguatge.getId());
                jsonObject.put("nom", llenguatge.getNom());
                jsonObject.put("any", llenguatge.getAny());
                jsonObject.put("dificultad", llenguatge.getDificultad());
                jsonObject.put("popularitat", llenguatge.getPopularitat());
                jsonArray.put(jsonObject);
            }
            PrintWriter out = new PrintWriter(Main.llenguatgesPath);
            out.write(jsonArray.toString(4)); // 4 es l'espaiat
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getPosition (int id) {
        int result = -1;
        ArrayList<ObjLlenguatge> llista = getAll();
        for (int cnt = 0; cnt < llista.size(); cnt = cnt + 1) {
            ObjLlenguatge llenguatge = llista.get(cnt);
            if (llenguatge.getId() == id) {
                result = cnt;
                break;
            }
        }
        return result;
    }

    @Override
    public void add(ObjLlenguatge llenguatge) {
        ArrayList<ObjLlenguatge> llista = getAll();
        ObjLlenguatge item = get(llenguatge.getId());
        if (item == null) {
            llista.add(llenguatge);
            writeList(llista);
        }
    }

    @Override
    public ObjLlenguatge get(int id) {
        ObjLlenguatge result = null;
        ArrayList<ObjLlenguatge> llista = getAll();
        int pos = getPosition(id);
        if (pos != -1) {
            result = llista.get(pos);
        }
        return result;
    }

    @Override
    public ArrayList<ObjLlenguatge> getAll() {
        ArrayList<ObjLlenguatge> result = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(Main.einesPath)));
            
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String nom = jsonObject.getString("nom");
                int any = jsonObject.getInt("any");
                int popularitat = jsonObject.getInt("popularitat");
                String dificultad = jsonObject.getString("dificultat");
                ObjLlenguatge llenguatge = new ObjLlenguatge(id, nom, any, dificultad, popularitat);
                result.add(llenguatge);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    

    @Override
    public void update(int id, ObjLlenguatge llenguatge) {
        ArrayList<ObjLlenguatge> llista = getAll();
        int pos = getPosition(id);
        if (pos != -1) {
            llista.set(pos, llenguatge);
            writeList(llista);
        }
    }

    @Override
    public void delete(int id) {
        ArrayList<ObjLlenguatge> llista = getAll();
        int pos = getPosition(id);
        if (pos != -1) {
            llista.remove(pos);
            writeList(llista);
        }
    }

    @Override
    public void print () {
        ArrayList<ObjLlenguatge> llista = getAll();
        for (int cnt = 0; cnt < llista.size(); cnt = cnt + 1) {
            System.out.println("    " + llista.get(cnt));
        }
    }

    public void setNom(int id, String name) {
        ArrayList<ObjLlenguatge> llista = getAll();
        for (int cnt = 0; cnt < llista.size(); cnt++) {
            if (llista.get(cnt).getId() == id) {
                llista.get(cnt).setNom(name);
            }
        }
        writeList(llista);
    }
    
    public void setAny(int id, int any) {
        ArrayList<ObjLlenguatge> llista = getAll();
        for (int cnt = 0; cnt < llista.size(); cnt++) {
            if (llista.get(cnt).getId() == id) {
                llista.get(cnt).setAny(any);
            }
        }
        writeList(llista);
    }

    public void setDificultat(int id, String dif) {
        ArrayList<ObjLlenguatge> llista = getAll();
        for (int cnt = 0; cnt < llista.size(); cnt++) {
            if (llista.get(cnt).getId() == id) {
                llista.get(cnt).setDificultad(dif);
            }
        }
        writeList(llista);
    }

    public void setPopularitat(int id, int pop) {
        ArrayList<ObjLlenguatge> llista = getAll();
        for (int cnt = 0; cnt < llista.size(); cnt++) {
            if (llista.get(cnt).getId() == id) {
                llista.get(cnt).setPopularitat(pop);;
            }
        }
        writeList(llista);
    }
}
