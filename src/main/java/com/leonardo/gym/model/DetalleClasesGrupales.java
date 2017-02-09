/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.gym.model;

import java.util.Date;

/**
 *
 * @author Gabri
 */
public class DetalleClasesGrupales {
    int id_detalle,id_cliente,id_horario;
    Date fecha_hora;
    public DetalleClasesGrupales(){
        id_cliente=0;
        id_detalle=0;
        id_horario=0;
        fecha_hora=null;
    }
    public DetalleClasesGrupales(int id_detalle, int id_cliente, int id_horario, Date fecha_hora){
        this.id_detalle=id_detalle;
        this.id_horario=id_horario;
        this.id_cliente=id_cliente;
        this.fecha_hora=fecha_hora;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }
    
}
