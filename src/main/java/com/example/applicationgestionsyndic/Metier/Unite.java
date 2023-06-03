package com.example.applicationgestionsyndic.Metier;

public class Unite {
    private int id_unite;
    private int num_port;
    private  int copro_id;
    private String type_unite;

    public int getId_unite() {
        return id_unite;
    }

    public int getNum_port() {
        return num_port;
    }

    public int getCopro_id() {
        return copro_id;
    }

    public String getType_unite() {
        return type_unite;
    }

    public void setId_unite(int id_unite) {
        this.id_unite = id_unite;
    }

    public void setNum_port(int num_port) {
        this.num_port = num_port;
    }

    public void setCopro_id(int copro_id) {
        this.copro_id = copro_id;
    }

    public void setType_unite(String type_unite) {
        this.type_unite = type_unite;
    }
}
