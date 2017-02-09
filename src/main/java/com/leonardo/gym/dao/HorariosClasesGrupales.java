/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.gym.dao;

import com.leonardo.gym.model.HorarioClaseGrupal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gabri
 */
public class HorariosClasesGrupales {
     ResultSet rs;

    public HorariosClasesGrupales() {

    }



    public ResultSet ReturnHorarioClase(HorarioClaseGrupal horario) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();

            rs = sentencia.executeQuery("SELECT * FROM HorarioClasesGrupales where id_clase = " + horario.getId());

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;

    }

    public void AñadirHorario(HorarioClaseGrupal horario) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();

            sentencia.executeUpdate("INSERT INTO HorarioClasesGrupales (id_clase, profesor, fecha, plazasLibres, hora) VALUES(" + horario.getId_clase() + ", '" + horario.getProfesor() + "', '" + horario.getFechaSQL()+ "', "+horario.getPlazaslibres()+", '"+horario.getHora()+"')");
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void EliminarHorario(HorarioClaseGrupal horario) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();

            sentencia.executeUpdate("DELETE FROM HorarioClasesGrupales WHERE id_horario="+horario.getId());
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
        public void ModificarHorario(HorarioClaseGrupal horario) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();
                    
           
            sentencia.executeUpdate("UPDATE HorarioClasesGrupales SET id_clase="+horario.getId_clase()+", profesor='"+horario.getProfesor()+"', fecha='"+horario.getFechaSQL()+"', plazasLibres='"+horario.getPlazaslibres()+"',hora='"+horario.getHora()+"' WHERE id_horario= "+horario.getId());
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
