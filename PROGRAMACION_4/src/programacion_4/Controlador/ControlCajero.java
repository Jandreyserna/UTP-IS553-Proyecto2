/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_4.Controlador;

import programacion_4.Modelos.ModeloCajero;

/**
 *
 * @author jandr
 */
public class ControlCajero {

    public static int ConsultaTamaño() {
        String sql = "SELECT COUNT(IdCajero) FROM cajero Where State = 1";
        int tam = 0;
        tam = ModeloCajero.ConsultaTamañoCajero(sql);
        return tam;
    }

    public static String[][] ConsultaInfoCajero() {
        String sql = "SELECT Numero, Sucursal FROM cajero WHERE State = 1";
        int tam = 0;
        tam = ConsultaTamaño();
        String[][] arreglo = new String [tam][2];
        arreglo = ModeloCajero.ConsultaCajeros(sql,tam);
        
        return arreglo;
    }

    public static String[] ConsultarCajero(int num) {
        String[] Numero = new String[2];
        String sql = "SELECT Numero,Sucursal FROM cajero WHERE Numero = "+num+" AND State = 1 AND Sucursal != ''";
        Numero = ModeloCajero.BuscarCajero(sql);
        return Numero;
    }

    public static boolean EvaluarUser(String user) {
        boolean eval = false;
        String sql = "SELECT Doc FROM students WHERE State = 1 AND Doc = "+user;
        String usuario = ModeloCajero.EvaluaUser(sql);
        if (usuario == "")
        {
            return false;
        }else
        {
            return true;
        }
    }

    public static boolean EvaluarPass(String pass, String doc) {
        String sql = "SELECT Doc FROM students WHERE State = 1 AND Pass = '"+pass+"' AND Doc = "+doc;
        String usuario = ModeloCajero.EvaluaUser(sql);
        if (usuario == "")
        {
            return false;
        }else
        {
            return true;
        }
    }

    public static boolean EvaluarCashCajero(int monto, int caja) {
         String sql = "SELECT Numero FROM cajero WHERE State = 1 AND Numero = "+caja+" AND Cash >= "+monto;
        String usuario = ModeloCajero.EvaluaUser(sql);
        
        if (usuario == "")
        {
            return false;
        }else
        {
            return true;
        }
    }

    public static boolean EvaluarCashUsuario(int monto, String user) {
        String sql = "SELECT Doc FROM students WHERE State = 1 AND Doc = "+user+" AND Cash >= "+monto;
        String usuario = ModeloCajero.EvaluaUser(sql);
        if (usuario == "")
        {
            return false;
        }else
        {
            return true;
        }
    }

    public static void Retiros(int caje, int monto, String user) {
        int[] denominaciones = new int[6];
        int monto2 = 0;
        int aux = 0;
        int d1 = 0;
        int d2 = 0;
        int d3 = 0;
        int d4 = 0;
        int d5 = 0;
        String sql = "SELECT Cash, D1,D2,D3,D4,D5 FROM cajero WHERE Numero = "+caje;
        denominaciones = ModeloCajero.ConsultaDenominaciones(sql);
        monto2 = monto;
        d1 = monto2 / 50000;
        if(d1 >= denominaciones[1])
        {
            aux = d1 - denominaciones[1];
            d1 = denominaciones[1];
            denominaciones[1] = 0;
            aux = aux * 50000;
            monto2 = monto2+aux;
        }else
        {
            denominaciones[1] = denominaciones[1] - d1;
        }
        d2 = monto2 / 20000;
        if(d2 >= denominaciones[2])
            {
                aux = d2 - denominaciones[2];
                d2 = denominaciones[2];
                denominaciones[2] = 0;
                aux = aux * 20000;
                monto2 = monto2+aux;
            }else
            {
                denominaciones[2] = denominaciones[2] - d2;
            }
        d3 = monto2 / 10000;
        if(d3 >= denominaciones[3])
            {
                aux = d3 - denominaciones[3];
                d3 = denominaciones[3];
                denominaciones[3] = 0;
                aux = aux * 10000;
                monto2 = monto2+aux;
            }else
                {
                    denominaciones[3] = denominaciones[3] - d3;
                }
        d4 = monto2 / 5000;
        if(d4 >= denominaciones[4])
            {
                aux = d4 - denominaciones[4];
                d4 = denominaciones[4];
                denominaciones[4] = 0;
                aux = aux * 5000;
                monto2 = monto2+aux;
            }else
                {
                        denominaciones[4] = denominaciones[4] - d4;
                }
        d5 = monto2 / 2000;
        int r = monto2 % 2000;
        if(d5 >= denominaciones[5])
            {
                aux = d5 - denominaciones[5];
                d5 = denominaciones[5];
                aux = aux * 2000;
                monto2 = monto2+aux;
            }
        if (r != 0)
                {
                     System.out.println("El monto solicitado no es valido...");
                }else{
                       denominaciones[5] = denominaciones[5] - d5;
                       System.out.println("El monto retirado fue "+monto+"...");
                        System.out.println(d1+" En Billestes de $50.000...");
                        System.out.println(d2+" En Billestes de $20.000...");
                        System.out.println(d3+" En Billestes de $10.000...");
                        System.out.println(d4+" En Billestes de $5.000....");
                        System.out.println(d5+" En Billestes de $2.000....");      
                    }
        String sql0 = "SELECT Cash FROM students WHERE Doc = "+user;
        int money = ModeloCajero.QueryMoney(sql0);
        money = money - monto;
        String sql1 = "UPDATE cajero SET Cash = "+monto+" WHERE Numero= ?";
        ModeloCajero.UpdateCaja(sql1,caje);
        String sql2 = "UPDATE students SET Cash = "+money+" WHERE doc= ?";
        ModeloCajero.UpdateEstudent(sql2,user);
            
                
        
        

    }
    
}
