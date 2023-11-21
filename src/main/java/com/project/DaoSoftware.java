package com.project;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class DaoSoftware implements Dao<ObjSoftware>{
    
    private void writeList(ArrayList<ObjSoftware> llista) {
        try {
            JSONArray jsonArray = new JSONArray();
            for (ObjSoftware software : llista) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", software.getId());
                jsonObject.put("nom", software.getNom());
                jsonObject.put("any", software.getAny());
                JSONArray jsonLlenguatges = new JSONArray(software.getLlenguatges());
                jsonObject.put("llenguatges", jsonLlenguatges);
                jsonArray.put(jsonObject);
            }
            PrintWriter out = new PrintWriter(Main.einesPath);
            out.write(jsonArray.toString(4)); // 4 es l'espaiat
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getPosition (int id) {
        int result = -1;
        ArrayList<ObjSoftware> llista = getAll();
        for (int cnt = 0; cnt < llista.size(); cnt = cnt + 1) {
            ObjSoftware software = llista.get(cnt);
            if (software.getId() == id) {
                result = cnt;
                break;
            }
        }
        return result;
    }

    @Override
    public void add(ObjSoftware software) {
        ArrayList<ObjSoftware> llista = getAll();
        llista.add(software);
        writeList(llista);
    }

    @Override
    public ObjSoftware get(int id) {
        ObjSoftware result = null;
        ArrayList<ObjSoftware> llista = getAll();
        int pos = getPosition(id);
        if (pos != -1) {
            result = llista.get(pos);
        }
        return result;
    }

    @Override
    public ArrayList<ObjSoftware> getAll() {
        ArrayList<ObjSoftware> result = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(Main.einesPath)));
            
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String nom = jsonObject.getString("nom");
                int any = jsonObject.getInt("any");
                JSONArray jsonLlenguatges = jsonObject.getJSONArray("llenguatges");
                ArrayList<Integer> llenguatges = new ArrayList<>();
                for (int j = 0; j < jsonLlenguatges.length(); j++) {
                    llenguatges.add(jsonLlenguatges.getInt(j));
                }
                ObjSoftware software = new ObjSoftware(id, nom, any, llenguatges);
                result.add(software);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    

    @Override
    public void update(int id, ObjSoftware software) {
        ArrayList<ObjSoftware> llista = getAll();
        for (ObjSoftware e : llista){
            if (e.getId() == id) {
                int index = llista.indexOf(e);
                llista.set(index, software);
                writeList(llista);
            }
        }
    }

    @Override
    public void delete(int id) {
        ArrayList<ObjSoftware> llista = getAll();
        int pos = getPosition(id);
        if (pos != -1) {
            llista.remove(pos);
            writeList(llista);
        }
    }

    @Override
    public void print () {
        ArrayList<ObjSoftware> llista = getAll();
        for (int cnt = 0; cnt < llista.size(); cnt = cnt + 1) {
            System.out.println(String.format("software %s: %s, %s - %s",Integer.toString(cnt), llista.get(cnt).getNom(), llista.get(cnt).getAny(), llista.get(cnt).getLlenguatges()));

        }
    }

    public void setLlenguatgesAdd(int id, int idLlenguatge){
        ArrayList<ObjSoftware> llista = getAll();
        for (ObjSoftware e : llista){
            if (e.getId() == id) {
                ArrayList<Integer> llenguatges = e.getLlenguatges();
                llenguatges.add(idLlenguatge);
                update(id, e);
            }
        }
    }

    public void setLlenguatgesDelete(int id, int idLlenguatge){
        ArrayList<ObjSoftware> llista = getAll();
        for (int cnt = 0; cnt < llista.size(); cnt++) {
            if (llista.get(cnt).getId() == id) {
                for (int len = 0; len < llista.get(cnt).getLlenguatges().size(); len++) {
                    if (llista.get(cnt).getLlenguatges().get(len) == idLlenguatge) {
                        llista.get(cnt).getLlenguatges().remove(len);
                    }
                }
            }
        }
        writeList(llista);
    }
}
