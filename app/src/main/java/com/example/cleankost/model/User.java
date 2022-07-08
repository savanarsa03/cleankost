package com.example.cleankost.model;

public class User {

    private String id, name,alamat,no_telepon, namapesan;

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public User(String name, String alamat, String no_telepon, String namapesan) {
        this.name = name;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
        this.namapesan = namapesan;
    }

    public String getNamapesan() {
        return namapesan;
    }

    public void setNamapesan(String namapesan) {
        this.namapesan = namapesan;
    }

    public String getName(){

        return name;
    }
    public void setName(String name){

        this.name = name;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telepon () { return no_telepon; }

    public void setNo_telepon(String no_telepon) { this.no_telepon = no_telepon; }
}