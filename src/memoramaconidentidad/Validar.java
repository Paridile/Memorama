/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoramaconidentidad;

import javax.swing.ImageIcon;

/**
 *
 * @author pablo
 */
public class Validar {
    private static BotonIdentidad b1;
    private static BotonIdentidad b2;
    


    
    
//    public static void voltea() throws InterruptedException {
//        Validar.setCount(Validar.getCount()+1);
//        if(Validar.getCount() == 2){
//        Validar.setCount(0);
//                Thread.sleep(1000);
//             Tablero.diferentes();
//        }
//                   
//    }
    
    public static boolean comparaCasillas() {
        boolean iguales = false;
        if(b1.getSimbolo().equals(b2.getSimbolo())) {
            System.out.println("Iguales");
            b1.setInmovil(true);
            b2.setInmovil(true);
        }
        else{    
                iguales = true;
        }
        return iguales;
    }

    

    public static BotonIdentidad getB1() {
        return b1;
    }

    public static void setB1(BotonIdentidad b1) {
        Validar.b1 = b1;
    }

    public static BotonIdentidad getB2() {
        return b2;
    }

    public static void setB2(BotonIdentidad b2) {
        Validar.b2 = b2;
    }          
}
