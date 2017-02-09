/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.gym.model;

/**
 *
 * @author Javier Prieto
 */
public class ClaseGrupal {
    private int id, aforo;
    private String nombre, descripcion;
    public ClaseGrupal() {
        id=0;
        aforo=0;
        nombre="";
        descripcion="";
    }
    public ClaseGrupal(int id, String nombre, String descripcion, int aforo) {
        this.id = id;
        this.aforo = aforo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripción(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
