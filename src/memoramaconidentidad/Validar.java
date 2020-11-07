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
    private int cantidadInmovilizados;
    private static BotonIdentidad b1;
    private static BotonIdentidad b2;
    private static String temp1;
    private static String temp2;
    private static boolean flag;
    private static int count;
    
    public Validar() {
        count=0;
        flag=false;
    }
        
    public static String getTemp1() {
        return temp1;
    }

    public static void setTemp1(String temp1) {
        Validar.temp1 = temp1;
    }

    public static String getTemp2() {
        return temp2;
    }

    public static void setTemp2(String temp2) {
        Validar.temp2 = temp2;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Validar.count = count;
    }
    
    public static void voltea() throws InterruptedException {
        Validar.setCount(Validar.getCount()+1);
        if(Validar.getCount() == 2){
        Validar.setCount(0);
                Thread.sleep(1000);
             Tablero.diferentes();
        }
                   
    }
    
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

    public static boolean isFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        Validar.flag = flag;
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
