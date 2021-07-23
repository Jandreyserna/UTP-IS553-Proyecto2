/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_4;

/**
 *
 * @author jandr
 */
import java.io.IOException;
import java.sql.SQLException;
import programacion_4.Vistas.VistaOficina;
import java.util.Scanner;

import programacion_4.Vistas.Limpiador;
import programacion_4.Vistas.VistaCajero;
public class PROGRAMACION_4 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        int op = 0;
        Scanner leer = new Scanner(System.in);
        do{
        System.out.println("....BIENVENIDO A SU MENU DE BANISCUTP....");
        System.out.println("-----------------------------------------");  
        System.out.println("1. Entrar como Oficina...................");
        System.out.println("2. Entrar Al Cajero......................");
        System.out.println("3. Entrar como Carro de Valores..........");
        System.out.println("0. Salir.................................");
        System.out.println("-----------------------------------------");
        System.out.println("Digite una opcion:");
        op = leer.nextInt();
        
        switch(op)
        {
            case 1:
                Limpiador.Limpiando();
                VistaOficina.oficina();
                
                break;

            case 2:
                VistaCajero.Cajero();
                break;
            case 3:
                
                break;
            
        }
        
        }while(op != 0);
        
    }
    
}
