/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_4.Vistas;

import java.util.Scanner;
import programacion_4.Controlador.ControlCajero;
import programacion_4.Vistas.VistaEvalucionesCajero;

/**
 *
 * @author jandr
 */
public class VistaCajero {

    public static void Cajero() {
        int tam = ControlCajero.ConsultaTamaño(); //defino el numero de datos de la base de datos
        String [][] infocajero = new String[tam][2];
        infocajero = ControlCajero.ConsultaInfoCajero(); // traigo todos los datos de la base de datos
        int op = 0;
        String[] num = new String [2];
        num[0] = "";
        Scanner leer = new Scanner(System.in);
        
        String user = "";
        String pass = "";
        int monto = 0;
        int [] total = new int [6];
        do
        {
            System.out.println("....Lista de Todos los Cajeros Activos.....\n");
            for(int x = 0 ; x < tam ; x++)
            {
                System.out.println(infocajero[x][0]);
                System.out.println(infocajero[x][1]);
            }
            System.out.println("....Digite el numero de Cagero para hacer la transacción:");
            System.out.println("....Precione 0 para canselar la transacción:");
            op = leer.nextInt();
            if(op != 0)
            {
                num = ControlCajero.ConsultarCajero(op);
                if(num[1] == "")
                {
                    System.out.println("....Este Cajero No Existe en nuestros registros....");
                    System.out.println("....Intente nuevamente....");
                }else
                {
                    Scanner leer2 = new Scanner(System.in);
                    System.out.println("....Bienvenido al Cajero"+num[1]+"....\n");
                    System.out.println("....Por favor digite los Siguientes datos....\n");
                    System.out.println("....Usuario(Documento de Identidad):");
                    user = leer2.nextLine();
                    System.out.println("....Contraseña:");
                    pass = leer2.nextLine();
                    System.out.println("....Cuanto desea retirar:");
                    monto = leer2.nextInt();
                    VistaEvalucionesCajero.VistaEvaluar(user,pass,monto,op);
                    
                }
                
            }         
        }while (op != 0);
        
        
        
    }
    
}
