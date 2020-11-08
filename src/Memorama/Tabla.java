
package Memorama;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;//Control + shift + i Para importar automaticamente
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aarón
 */

public class Tabla extends JFrame{
    public Tabla(){
        super("PUNTAJES");
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Jugodor");
        modelo.addColumn("Puntaje");

        this.setLocationRelativeTo(null);//-------------------------------------Centrar el Frame con respecto al componente                
        
        Tablero Traer1 = new Tablero();//Traer Metodo 
        int Pts= Traer1.addpuntos();  
        
        String Puntos = Integer.toString(Pts);//Convertirlo a String
        
        
        String [] JA = {"Jugador A",Puntos};
        String [] JB = {"Jugador B","10"};
        
        modelo.addRow(JA);
        modelo.addRow(JB);
        
        JTable tabla = new JTable(modelo);//Pasa los datos de modelo, hacia la tabla.
        tabla.setBounds(12,12,200,200);//Cordenadas X / Y / Alto / Ancho
        setSize(400,400);
        add(tabla);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//--------------------Cerrar Ventana / EXIT_ON_CLOSE
        setLayout(null);
        setVisible(true);
        
        
    }
    public static void main (String [] a){
         Tabla ta = new Tabla();
         
    }    
    
}
