package Memorama;

import java.awt.TextArea;

public class PestañaJuego {
//------------------------------------------------------------------------------JUEGO
    public static void Nuevo(){                           
        System.out.println("Configuraciones Juego Nuevo");  
        DialogoUNO Dialogo = new DialogoUNO();
        Dialogo.go();
        DialogoDOS Dialogo2 = new DialogoDOS();
        Dialogo2.go();
        new Tablero();
        
    }
    
//------------------------------------------------------------------------------NUEVA VENTANA
    public static void NuevaVentana(){
        System.out.println("Ventana Nueva Abierta");
        Principal Traer1 = new Principal();
        Traer1.go();        
    }
//------------------------------------------------------------------------------PUNTAJES
    public static void Puntajes(){
        System.out.println("Ventana Nueva Abierta");
        Tabla tab = new Tabla();       
    }
//------------------------------------------------------------------------------PUNTAJES   
    public static void Salir(){                           
        System.out.println("Cerrando Memorama");  
        System.exit(0);
        
    }
    
}
