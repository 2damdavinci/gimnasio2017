/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.gym.model;

import java.util.Date;

/**
 *
 * @author Javier Prieto
 */
public class HorarioClaseGrupal {
    int id, id_clase, plazaslibres;
    String profesor;
    Date fecha;
    Date hora;

    public HorarioClaseGrupal() {
        id=0;
        id_clase=0;
        plazaslibres=0;
        profesor="";
        fecha=null;
        hora=null;
    }

    public HorarioClaseGrupal(int id, int id_clase, int plazaslibres, String profesor, Date fecha, Date hora) {
        this.id = id;
        this.id_clase = id_clase;
        this.plazaslibres = plazaslibres;
        this.profesor = profesor;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public int getPlazaslibres() {
        return plazaslibres;
    }

    public void setPlazaslibres(int plazaslibres) {
        this.plazaslibres = plazaslibres;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
    
}
