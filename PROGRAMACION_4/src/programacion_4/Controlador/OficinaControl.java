/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_4.Controlador;

/**
 *
 * @author jandr
 */

import java.sql.SQLException;
import programacion_4.Modelos.ModeloOficina;

public class OficinaControl {

    public static void RegisterStudent(String name, String doc, String cash, String pas, int state) 
    {
        
        //ModeloOficina.RegisterNewStudent(name,doc,cash,pas,state);
        String sql1 = "SELECT Doc, State FROM students WHERE Doc ="+doc;
        String [] arreglo = new String[4];
        arreglo[0] = name;
        arreglo[1] = doc;
        arreglo[2] = cash;
        arreglo[3] = pas;
        
        ModeloOficina.ConsultasIngresos(sql1,arreglo);
        
    }

    public static void UpdateControl(String docu, int value) 
    {
        ModeloOficina.UpdateCash(value,docu);
    }

    public static void DeleteStudent(String doc) {
        ModeloOficina.DeleteOneStudent(doc);
    }

    public static void Money(String name,int num, int d1, int d2, int d3, int d4, int d5)
    {
        int cash = (50000*d1)+(20000*d2)+(10000*d3)+(5000*d4)+(2000*d5);
        String sql = "SELECT Numero, State FROM cajero WHERE Numero ="+num;
        
        int [] arreglo = new int[7];
        arreglo[0] = num;
        arreglo[1] = cash;
        arreglo[2] = d1;
        arreglo[3] = d2;
        arreglo[4] = d3;
        arreglo[5] = d4;
        arreglo[6] = d5;
        ModeloOficina.ConsultaIngresoCajero(sql,name,arreglo);
    }

    public static void DeleteCajero(String doc) {
        ModeloOficina.DeleteOneCajero(doc);
    }

    public static void RegisterAdmin(String name, String doc, String pas) {
        //ModeloOficina.RegisterNewStudent(name,doc,cash,pas,state);
        String sql = "SELECT Doc, State FROM oficinas WHERE Doc ="+doc;
        String [] arreglo = new String[3];
        arreglo[0] = name;
        arreglo[1] = doc;
        arreglo[2] = pas;
        
        ModeloOficina.ConsultasIngresosAdmin(sql,arreglo);
    }
    
    
    public String login(String user, String pass) throws SQLException, ClassNotFoundException 
    {
        ModeloOficina ofi = new ModeloOficina();
        String sql = "SELECT `Name` FROM oficinas WHERE Doc ="+user+" AND Pass ='"+pass+"'";
        return ofi.QeryLogin(sql);
    }
}
