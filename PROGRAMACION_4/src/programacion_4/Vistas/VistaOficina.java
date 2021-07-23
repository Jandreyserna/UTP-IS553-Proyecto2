/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_4.Vistas;

import static java.nio.file.Files.delete;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import programacion_4.Controlador.OficinaControl;

/**
 *
 * @author jandr
 */
public class VistaOficina {
    
    public static void oficina() throws SQLException
    {
        int opc = 0;
        String user = ""; 
        String pass = "";
        String log = "";
        Scanner leer = new Scanner(System.in);
        
        
        System.out.println("....POR FAVOR INGRESE SU USUARIO Y CONTRASEÑA.....");
        System.out.println("USUARIO(Su Documento Identidad): ");
        user = leer.nextLine();
        System.out.println("CONTRASEÑA: "); 
        pass = leer.nextLine();
        OficinaControl logear = new OficinaControl();
        
        try {
            log = logear.login(user,pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaOficina.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(log);
        if(log != "")
        {
            String name = "";
            String doc = "";
            String cash = "";
            String pas = "";
            int state = 1;
            System.out.println(" ");
            
            do{
                System.out.println("....BIENVENIDO A LA OFICINA "+log+".........");
                System.out.println("Que funcion desea realizar..................");
                System.out.println("--------------------------------------------");  
                System.out.println("1. Registrar un estudiante..................");
                System.out.println("2. hacer una consignacion a un estudiante...");
                System.out.println("3. Registrar un cajero......................");
                System.out.println("4. Eliminar  un estudiante..................");
                System.out.println("5. Eliminar un cajero.......................");
                System.out.println("6. Registrar Empleado.......................");
                System.out.println("0. Atras....................................");
                System.out.println("--------------------------------------------");
                System.out.println("Digite una opcion:");
                opc = leer.nextInt();
        
                switch(opc)
                {
                    
                    case 1:
                        EstudianteConsignacion.RegistrarAlEstudiante();
                         
                        break;
                        
                    case 2:
                        
                        EstudianteConsignacion.ConsignarStudent();

                        break;
                        
                    case 3:
                        EstudianteConsignacion.RegistrarElCajero();
                        
                        break;
                        
                    case 4:
                        EstudianteConsignacion.DeleteTheStudent();
                        
                        break;
                        
                    case 5:
                        EstudianteConsignacion.DeleteTheCajero();
                        
                        break;
                        
                    case 6:
                        EstudianteConsignacion.RegisterEmpleado();
                        
                        break;
                }
            }while(opc != 0);
        }else
        {
            System.out.println("Error los datos no coinciden ");
        }
    }

}
