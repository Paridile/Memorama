package Memorama;


/**
 *
 * @author pablo
 */
public class Validar {
    private static BotonDestapar b1;
    private static BotonDestapar b2;
    
    public static boolean comparaCasillas() {
        boolean iguales = false;
        if(b1.getSimbolo().equals(b2.getSimbolo())) {
            System.out.println("Iguales");
            iguales = true;
            b1.setInmovil(true);
            b2.setInmovil(true);
            Tablero.aumentaPuntuación();
        }
        return iguales;
    }    

    public static BotonDestapar getB1() {
        return b1;
    }

    public static void setB1(BotonDestapar b1) {
        Validar.b1 = b1;
    }

    public static BotonDestapar getB2() {
        return b2;
    }

    public static void setB2(BotonDestapar b2) {
        Validar.b2 = b2;
    }          
    
    
}