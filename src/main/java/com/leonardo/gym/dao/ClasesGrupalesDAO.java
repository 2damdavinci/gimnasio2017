/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.gym.dao;

import com.leonardo.gym.model.ClaseGrupal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabri
 */
public class ClasesGrupalesDAO {

    ResultSet rs;

    public ClasesGrupalesDAO() {

    }

    public ResultSet ReturnClase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();

            rs = sentencia.executeQuery("SELECT * FROM ClasesGrupales");

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }



    public void AñadirClase(ClaseGrupal clase) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();

            sentencia.executeUpdate("INSERT INTO ClasesGrupales (nombre, descripcion, aforo) VALUES('" + clase.getNombre() + "', '" + clase.getDescripcion() + "', " + clase.getAforo() + ")");
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void EliminarClase(ClaseGrupal clase) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();

            sentencia.executeUpdate("DELETE FROM ClasesGrupales WHERE id_clase="+clase.getId());
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
        public void ModificarClase(ClaseGrupal clase) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();
            Statement sentenci1 = conexion.createStatement();
            
           
            sentencia.executeUpdate("UPDATE ClasesGrupales SET nombre='"+clase.getNombre()+"', descripcion='"+clase.getDescripcion()+"', aforo="+clase.getAforo()+" WHERE id_clase= "+clase.getId());
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
