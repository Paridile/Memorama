package Memorama;

import java.awt.TextArea;
import javax.swing.JOptionPane;

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
    
    public static void Creadores() {
        JOptionPane.showMessageDialog(null, "Este programa fue hecho para la clase de Programación visual del\n"
                + "grupo ICO G-92 de UAEMex por\n\n"
                + "     - Ríos Díaz de León José Pablo\n"
                + "     - Jimenez Zempoalteca Uriel\n"
                + "     - Sanchez Cortes Aaron Israel\n"
                + "     - Paez Villafuerte Eithel Agustin\n\n");
    }
    
    public static void AcercaDelJuego() {
        JOptionPane.showMessageDialog(null, "MEMORAMA DE SIMBOLOS UNIVERSITARIOS\n"                
                + "     1) Da click en las tarjetas para voltearlas\n"
                + "     2) Si encuentras dos simbolos iguales ganas un punto\n"
                + "     3) Gana el jugador que obtenga mas puntos.\n"
                + "     4) Portense mal pero haganlo bien.\n\n");
    }
    
}
    
    
    

