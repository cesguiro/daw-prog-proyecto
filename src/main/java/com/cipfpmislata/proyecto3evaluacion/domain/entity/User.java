package com.cipfpmislata.proyecto3evaluacion.domain.entity;

public class User {
    
    private int id;
    private String name;
    private String mail;
    private String password;
    
    //Constructor necesario para que Hibernate pueda inicializar la entidad
    /*User(){

    }*/

    //Constructor por defecto con los campos obligatorios
    public User(int id, String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }


    //Constructor por defecto con los campos obligatorios
    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", mail=" + mail + ", password=" + password + ", repeat_password="
                + "]";
    }
}
