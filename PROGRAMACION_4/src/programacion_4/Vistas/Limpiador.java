/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_4.Vistas;

import java.io.IOException;

/**
 *
 * @author jandr
 */
public class Limpiador {
    public static void Limpiando() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            /*No hacer nada*/
        }
           /*Introduce tu código desde aquí*/
    }
}
