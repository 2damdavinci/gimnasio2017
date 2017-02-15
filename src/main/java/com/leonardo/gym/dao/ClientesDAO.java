/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.gym.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gabri
 */
public class ClientesDAO {

    ResultSet rs;

    public ClientesDAO() {

    }

    public ResultSet busquedaID(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();

            rs = sentencia.executeQuery("SELECT * FROM Clientes where id_cliente=" + id);
            
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public ResultSet busquedaNombre(String nombre) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();

            rs = sentencia.executeQuery("SELECT * FROM Clientes where nombre= '" + nombre + "'");
            
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet busquedaApellido(String apellido) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();

            rs = sentencia.executeQuery("SELECT * FROM Clientes where apellidos like '%" + apellido + "%'");
            
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet busquedaNif(String nif) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();

            rs = sentencia.executeQuery("SELECT * FROM Clientes where nif= '" + nif + "'");
            
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet busquedaTelefonoFijo(String telefonoFijo) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();

            rs = sentencia.executeQuery("SELECT * FROM Clientes where telefono_fijo=" + telefonoFijo);
            
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet busquedaTelefonoMovil(String telefonoMovil) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();

            rs = sentencia.executeQuery("SELECT * FROM Clientes where telefono_movil=" + telefonoMovil);
            
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet busquedaEmail(String email) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");
            Statement sentencia = conexion.createStatement();

            rs = sentencia.executeQuery("SELECT * FROM Clientes where email='" + email + "'");
            
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
