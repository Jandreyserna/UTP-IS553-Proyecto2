/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_4.Modelos;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import programacion_4.Conexion.Conectar;


/**
 *
 * @author jandr
 */
public class ModeloOficina {

    public static void RegisterNewStudent(String name, String doc, String cash, String pas, int state) {
         Conectar conect = new Conectar();
    }

    public static void ConsultasIngresos(String sql1, String[] array) {
        Conectar conect = new Conectar();
        ResultSet rs = conect.Consulta(sql1);
        String doc = "";
        int stat = 0;
        try {
            while (rs.next()){
                doc = rs.getString(1);
                stat = rs.getInt(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloOficina.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(doc == "")
        {
            conect.Ingresar(array);
            System.out.println("Estudiante Registrado\n");
        
        }else if (doc != "" && stat == 0)
            {
                Scanner leer = new Scanner(System.in);
                char op ;
                System.out.println("El estudiante ya tiene una cuenta");
                System.out.println("Desea Activarla");
                System.out.println("Y (si), X(no)");
                op = leer.next().charAt(0);
                if (op == 'Y' || op == 'y')
                {
                    String sql2 = "UPDATE students SET State = 1 WHERE Doc=?";
                    conect.UpdateOneFieldStudent(sql2,doc);
                    System.out.println("estudiante activo nuevamente");
                }
            }else 
                {
                    System.out.println("Este estudiante ya existe en el registro");
                }
    }

    public static void UpdateCash(int value, String docu)
    {   
        
        String sql2 = "SELECT Name, Cash FROM students WHERE Doc="+docu+" AND State = 1";
        String nombre = "";
        int monto = 0;
        Conectar conect = new Conectar();
        ResultSet rs = conect.Consulta(sql2);
        
        try {
            while (rs.next()){
                nombre = rs.getString(1);
                monto = rs.getInt(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloOficina.class.getName()).log(Level.SEVERE, null, ex);
        }
        monto = monto + value;
        String sql = "UPDATE students SET Cash ="+monto+" WHERE Doc=?";
        if(nombre == "")
        {
            System.out.println("No existe ningun estudiante registrado con este documento");
        }else
        {
         conect.UpdateOneFieldStudent(sql, docu);
         System.out.println("Monto Actualizado");
        }
        
    }

    public static void DeleteOneStudent(String doc) {
        Conectar conect = new Conectar();
        String sql = "UPDATE students SET State = 0 WHERE Doc=?";
        conect.UpdateOneFieldStudent(sql, doc);
    }

    public static void ConsultaIngresoCajero(String sql, String name, int[] arreglo)
    {
        Conectar conect = new Conectar();
        ResultSet rs = conect.Consulta(sql);
        String num = "";
        int stat = 0;
        try {
            while (rs.next()){
                num = rs.getString(1);
                stat = rs.getInt(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloOficina.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(num == "")
        {
            conect.IngresarCajero(arreglo,name);
            System.out.println("Cajero Registrado\n");
        
        }else if (num != "" && stat == 0)
            {
                Scanner leer = new Scanner(System.in);
                char op ;
                System.out.println("El cajero ya tiene una cuenta");
                System.out.println("Desea Activarlo");
                System.out.println("Y (si), X(no)");
                op = leer.next().charAt(0);
                if (op == 'Y' || op == 'y')
                {
                    String sql2 = "UPDATE cajero SET State = 1 WHERE Numero=?";
                    conect.UpdateOneFieldStudent(sql2,num);
                    System.out.println("Cajero activo nuevamente");
                }
            }else 
                {
                    System.out.println("Este cajero ya existe en el registro");
                }
        
    }

    public static void DeleteOneCajero(String doc) {
        Conectar conect = new Conectar();
        String sql = "UPDATE cajero SET State = 0 WHERE Numero=?";
        conect.UpdateOneFieldCajero(sql, doc);
        System.out.println("Cajero eliminado");
    }

    public static void ConsultasIngresosAdmin(String sql, String[] arreglo) {
        Conectar conect = new Conectar();
        ResultSet rs = conect.Consulta(sql);
        String num = "";
        int stat = 0;
        try {
            while (rs.next()){
                num = rs.getString(1);
                stat = rs.getInt(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloOficina.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(num == "")
        {
            conect.IngresarAdmin(arreglo);
            System.out.println("Administrador Registrado\n");
        
        }else if (num != "" && stat == 0)
            {
                Scanner leer = new Scanner(System.in);
                char op ;
                System.out.println("El Administrador ya tiene una cuenta");
                System.out.println("Desea Activarlo");
                System.out.println("Y (si), X(no)");
                op = leer.next().charAt(0);
                if (op == 'Y' || op == 'y')
                {
                    String sql2 = "UPDATE oficinas SET State = 1 WHERE Doc=?";
                    conect.UpdateOneFieldStudent(sql2,num);
                    System.out.println("Administrador activo nuevamente");
                }
            }else 
                {
                    System.out.println("Este Administrador ya existe en el registro");
                }
        
    }
    
     
    public String QeryLogin(String sql)
    {
        Conectar conect = new Conectar();
        ResultSet rs = conect.Consulta(sql);
        String nombre = "";
        try {
            while (rs.next()){
                nombre = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloOficina.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre);
        
        return nombre;       
    }
}
