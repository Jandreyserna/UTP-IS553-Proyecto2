/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_4.Modelos;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;

/**
 *
 * @author jandr
 */
public class ModeloCajero {
    
     public static Connection  Conexion() 
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

    public static int ConsultaTamañoCajero(String sql) {
        Connection cn;
        int tam = 0;
        cn = Conexion();
        ResultSet rs = null;
        Statement pst;
         try {
             pst = cn.createStatement();
             rs = pst.executeQuery(sql);
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ModeloCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         try {
             while(rs.next())
             {
                 tam = rs.getInt(1);
             }
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ModeloCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
            
        
        return tam;
    }

    public static String[][] ConsultaCajeros(String sql, int tam)
    {
        Connection cn;
        String[][] array =new String [tam][2];
        int i = 0;
        cn = Conexion();
        ResultSet rs = null;
        Statement pst;
         try {
             pst = cn.createStatement();
             rs = pst.executeQuery(sql);
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ModeloCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         try {
             while(rs.next())
             {
                 array[i][0] = rs.getString(1);
                 array[i][1] = rs.getString(2);
                // System.out.println(array[i][0]);
                // System.out.println(array[i][1]); 
                 i++;
             }
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ModeloCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         return array;
    }

    public static String[] BuscarCajero(String sql) {
        Connection cn;
        String[] numero =new String [2];       
        cn = Conexion();
        ResultSet rs = null ;
        Statement pst;
         try {
             pst = cn.createStatement();
             rs = pst.executeQuery(sql);
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ModeloCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         try {
             while(rs.next())
             {
                numero[0] = rs.getString(1);
                numero[1] = rs.getString(2);
           
             }
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ModeloCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         return numero;
    }

    public static String EvaluaUser(String sql) {
        Connection cn;
        cn = Conexion();
        String usuario = "";
        ResultSet rs = null;
        Statement pst;
         try {
             pst = cn.createStatement();
             rs = pst.executeQuery(sql);
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ModeloCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         try {
             while(rs.next())
             {
                 usuario = rs.getString(1);
             }
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ModeloCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
            
        
        return usuario;
    }

    public static int[] ConsultaDenominaciones(String sql)
    {
         Connection cn;
        cn = Conexion();
        int[] usuario = new int[6];
        ResultSet rs = null;
        Statement pst;
         try {
             pst = cn.createStatement();
             rs = pst.executeQuery(sql);
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ModeloCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         try {
             while(rs.next())
             {
                 usuario[0] = rs.getInt(1);
                 usuario[1] = rs.getInt(2);
                 usuario[2] = rs.getInt(3);
                 usuario[3] = rs.getInt(4);
                 usuario[4] = rs.getInt(5);
                 usuario[5] = rs.getInt(6);
             }
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ModeloCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         return usuario;
    }

    public static int QueryMoney(String sql0) {
        Connection cn;
        cn = Conexion();
        int usuario =  0;
        ResultSet rs = null;
        Statement pst;
         try {
             pst = cn.createStatement();
             rs = pst.executeQuery(sql0);
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ModeloCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         try {
             while(rs.next())
             {
                 usuario = rs.getInt(1);
                
             }
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ModeloCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         return usuario;
    }

    public static void UpdateCaja(String sql1, int caje) {
        Connection cn = Conexion();
        
        
            PreparedStatement pst;
         try {
             pst = cn.prepareStatement(sql1);
             pst.setInt(1, caje);
            pst.executeUpdate();
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ModeloCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
            
            
        
    }

    public static void UpdateEstudent(String sql2, String user) {
         Connection cn = Conexion();
        
        
            PreparedStatement pst;
         try {
             pst = cn.prepareStatement(sql2);
             pst.setString(1, user);
            pst.executeUpdate();
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ModeloCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
    }
    
}
