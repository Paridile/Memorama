/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoramaconidentidad;

/**
 *
 * @author pablo
 */
public class Validar {
    private int cantidadInmovilizados;
    private static String temp1;
    private static String temp2;
    private static String[] inmoviles;
    
    public Validar() {
        String[] inmoviles = new String[18];
    }
    
    public static void compara(boolean destapado, String simbolo){
        if(!destapado){
            if(temp1==null){
                temp1 = simbolo;
                System.out.println("Temp1 = " + temp1);
            }
        else if(temp2 == null) {
            temp2 = simbolo;
            System.out.println("Temp2 = " + temp2);
        }
        
        if(temp1 !=null && temp2 != null){
            if(temp1 == temp2) {
                System.out.println("Iguales");
                inmovilizar(temp1);
            }
            temp1 = null;
            temp2 = null;
        }
        }
    }
    
    public static void inmovilizar(String simbolo) {
        int cont = 0;
        if(inmoviles.length > 0) {            
            inmoviles[inmoviles.length + 1] = simbolo;
        }
        else{
            inmoviles[0] = simbolo;
        }
        for(String i:inmoviles){
            System.out.println(i + " esta inmovil");
        }
        
    }
    
    
    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }
}
