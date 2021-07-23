/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_4.Conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jandr
 */

public class Conectar
{  
  
        
    public Connection  Conexion() 
    {
        Connection conect = null;
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          conect = DriverManager.getConnection("jdbc:mysql://localhost/cajero","root","");
        }catch (Exception e) {
            
        }
        return conect;
    }
    public void InsertarDatos(String arg)
    {
        Connection cn = Conexion();
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO oficinas (arg) VALUES(?)");
            pst.setString(1, arg);
            pst.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet Consulta(String arg)
    {
        Connection cn = Conexion();
        ResultSet rs = null;
        try {
            Statement pst = cn.createStatement();
            rs = pst.executeQuery(arg);
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void Ingresar(String[] arraydates)
    {
        Connection cn = Conexion();
        ResultSet rs = null;
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO students (Name,Doc,Cash,Pass,State) VALUES(?,?,?,?,?)");
            pst.setString(1, arraydates[0]);
            pst.setString(2, arraydates[1]);
            pst.setString(3, arraydates[2]);
            pst.setString(4, arraydates[3]);
            pst.setString(5, "1");
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateOneFieldStudent(String sql2,String doc) {
        Connection cn = Conexion();
        
        try {
            PreparedStatement pst = cn.prepareStatement(sql2);
            pst.setString(1, doc);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void IngresarCajero(int[] arreglo, String name) {
        Connection cn = Conexion();
        ResultSet rs = null;
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO cajero (Numero,Sucursal,Cash,D1,D2,D3,D4,D5,State) VALUES(?,?,?,?,?,?,?,?,?)");
            
            pst.setInt(1, arreglo[0]);
            pst.setString(2, name);
            pst.setInt(3, arreglo[1]);
            pst.setInt(4, arreglo[2]);
            pst.setInt(5, arreglo[3]);
            pst.setInt(6, arreglo[4]);
            pst.setInt(7, arreglo[5]);
            pst.setInt(8, arreglo[6]);
            pst.setString(9, "1");
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void IngresarAdmin(String[] arreglo) {
        Connection cn = Conexion();
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO oficinas (Name,Doc,Pass,State) VALUES(?,?,?,?)");
            
            pst.setString(1, arreglo[0]);
            pst.setString(2, arreglo[1]);
            pst.setString(3, arreglo[2]);
            pst.setString(4, "1");
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateOneFieldCajero(String sql, String doc) {
        Connection cn = Conexion();
        
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, doc);
            int retorno = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}