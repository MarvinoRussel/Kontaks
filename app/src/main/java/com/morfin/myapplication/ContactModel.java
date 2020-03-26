package com.morfin.myapplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ContactModel extends RealmObject {

    @PrimaryKey
    private Integer id;
    private String nama;
    private Integer nomor;

    public void setId(Integer id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return nama;
    }

    public void setNomor(Integer nomor){
        this.nomor = nomor;
    }
    public int getNomor(){
        return nomor;
    }
}
