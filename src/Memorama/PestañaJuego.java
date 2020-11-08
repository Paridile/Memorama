package Memorama;

import java.awt.TextArea;

public class PestañaJuego {
//------------------------------------------------------------------------------JUEGO
    public static void Nuevo(){                           
        System.out.println("Configuraciones Juego Nuevo");  
        //DialogoUNO Dialogo = new DialogoUNO();
        //Dialogo.go();
        //new Tablero();
        Tabla tab = new Tabla();
    }
    
//------------------------------------------------------------------------------NUEVA VENTANA
    public static void NuevaVentana(){
        System.out.println("Ventana Nueva Abierta");
        Principal Traer1 = new Principal();
        Traer1.go();        
    }
    
    
}
