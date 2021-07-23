/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_4.Vistas;

import programacion_4.Controlador.ControlCajero;

/**
 *
 * @author jandr
 */
public class VistaEvalucionesCajero {

    static void VistaEvaluar(String user, String pass, int monto, int caje) {
        boolean exist = ControlCajero.EvaluarUser(user);
        boolean exist2 = false;
        boolean exist3 = false;
        boolean exist4 = false;
        
        if(exist == true)
        {
            exist2 = ControlCajero.EvaluarPass(pass, user);
            if(exist2 == true)
            {
                exist3 = ControlCajero.EvaluarCashCajero(monto, caje);
                if(exist3 == true)
                {
                    exist4 = ControlCajero.EvaluarCashUsuario(monto, user);
                    if(exist4 == true)
                    {
                        ControlCajero.Retiros(caje,monto,user);
                    }else
                    {
                        System.out.println("La cuenta "+user+" no tiene suficiente Dinero....."); 
                    }
                }else
                {
                    System.out.println("El Cajero no tiene suficiente Dinero.....");  
                }
            }else
            {
             System.out.println("la contraseña no coincide.....");   
            }
            
        }else
        {
            System.out.println("Este Usuario"+user+" no existe.....");
        }
    }
    
}
