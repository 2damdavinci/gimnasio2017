/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.gym.dao;

import com.leonardo.gym.model.DetalleClasesGrupales;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gabri
 */
public class DetallesClasesGrupalesDAO {

    ResultSet rs;

    public DetallesClasesGrupalesDAO() {

    }

    public ResultSet ReturnDetalleHorario(DetalleClasesGrupales detalle) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();
            System.out.println("SELECT * FROM DetallesClasesGrupales where id_horario = " + detalle.getId_horario());
            rs = sentencia.executeQuery("SELECT * FROM DetallesClasesGrupales where id_horario = " + detalle.getId_horario());

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public void AñadirDetalle(DetalleClasesGrupales detalle) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate("INSERT INTO DetallesClasesGrupales (id_horario, id_cliente, fechaHora) VALUES(" + detalle.getId_horario() + ", " + detalle.getId_cliente() + ", '" + detalle.getFechaSQL() + "')");
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void EliminarDetalle(DetalleClasesGrupales detalle){
                try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();

            sentencia.executeUpdate("DELETE FROM DetallesClasesGrupales WHERE id_detalle="+detalle.getId_detalle());
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
