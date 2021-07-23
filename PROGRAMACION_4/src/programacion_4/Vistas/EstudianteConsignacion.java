/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_4.Vistas;
import java.util.Scanner;
import programacion_4.Controlador.OficinaControl;
/**
 *
 * @author jandr
 */
public class EstudianteConsignacion {

    static void ConsignarStudent() {
        Scanner leer = new Scanner(System.in);
        String doc = "";
        int value = 0;
        System.out.println("\n Digite el Documento del estudiante:");
        doc = leer.nextLine();
        System.out.println("\n Digite el Valor de la consignación:");
        System.out.println(value = leer.nextInt());
        OficinaControl.UpdateControl(doc, value);
    }

    static void RegistrarAlEstudiante() {
        Scanner leer = new Scanner(System.in);
        String name = "";
        String doc = "";
        String cash = "";
        String pas = "";
        int state = 1;
        System.out.println("\n Digite el Nombre Completo:");
        name = leer.nextLine();
        System.out.println("\n Digite el Documento Identidad:");
        doc = leer.nextLine();
        System.out.println("\n Digite el Efectivo Inicial:");
        cash = leer.nextLine();
        System.out.println("\n Digite la Contraseña:");
        pas = leer.nextLine();
                        
        OficinaControl.RegisterStudent(name, doc, cash, pas, state);
    }

    static void RegistrarElCajero() {
        Scanner leer = new Scanner(System.in);
        String nam = "";
        int num =0;
        int d1 = 0;
        int d2 = 0;
        int d3 = 0;
        int d4 = 0;
        int d5 = 0;
        System.out.println("\n Digite el Nombre Del Cajero:");
        nam = leer.nextLine();
        System.out.println("\n Digite el numero de cajero:");
        num = leer.nextInt();
        System.out.println("\n Cuantos Billetes de $50.000 tiene:");
        d1 = leer.nextInt();
        System.out.println("\n Cuantos Billetes de $20.000 tiene:");
        d2 = leer.nextInt();
        System.out.println("\n Cuantos Billetes de $10.000 tiene:");
        d3 = leer.nextInt();
        System.out.println("\n Cuantos Billetes de $5.000 tiene:");
        d4 = leer.nextInt();
        System.out.println("\n Cuantos Billetes de $2.000 tiene:");
        d5 = leer.nextInt();
        OficinaControl.Money(nam, num, d1, d2, d3, d4, d5);
    }

    static void DeleteTheStudent() {
        Scanner leer = new Scanner(System.in);
        String docum = "";
        System.out.println("\n Digite el Documento del estudiante que desea eliminar:");
        docum = leer.nextLine();
        OficinaControl.DeleteStudent(docum);
    }

    static void DeleteTheCajero() {
        Scanner leer = new Scanner(System.in);
        String document = "";
        System.out.println("\n Digite el Numero del Cajero que desea eliminar:");
        document = leer.nextLine();
        OficinaControl.DeleteCajero(document);
    }

    static void RegisterEmpleado() {
        Scanner leer = new Scanner(System.in);
        String name = "";
        String doc = "";
        String pas = "";
        System.out.println("\n Digite el Nombre Completo:");
        name = leer.nextLine();
        System.out.println("\n Digite el Documento Identidad:");
        doc = leer.nextLine();
        System.out.println("\n Digite su contraseña:");
        pas = leer.nextLine();
        OficinaControl.RegisterAdmin(name,doc,pas);
    }
    
}
