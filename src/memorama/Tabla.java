package Memorama;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;//Control + shift + i Para importar automaticamente
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aarón
 */

public class Tabla extends JFrame{
    
    private static int pts;
    private static int pts2;
    private static String Jugador1;
    private static String Jugador2;
    public static DefaultTableModel modelo;
    
    public Tabla(){
        super("Puntajes");
        modelo = new DefaultTableModel();
        modelo.addColumn("Jugador");
        modelo.addColumn("Puntaje");
        pts=0;
        pts2=0;

        this.setLocationRelativeTo(null);//-------------------------------------Centrar el Frame con respecto al componente                
//------------------------------------------------------------------------------
        int Puntos1 = 0;
        int Puntos2 = 0;
        
        DialogoUNO Traer1 = new DialogoUNO();
        Jugador1 = Traer1.Nombre();
        if(Jugador1.equals("")){
            Jugador1="Jugador1";
        }
        
          
          
        pts = Tablero.Puntaje1(Puntos1);
        pts2 = Tablero.Puntaje2(Puntos2);

        String cadenaPuntaje = String.valueOf(pts);
        
        String cadenaPuntaje2 = String.valueOf(pts2);
        
        DialogoDOS Traer2 = new DialogoDOS();
        Jugador2 = Traer2.Nombre2();
        if(Jugador2.equals("")){
            Jugador2="Jugador2";
        }
//------------------------------------------------------------------------------
        
        String [] J1 = {Jugador1,cadenaPuntaje};
        String [] J2 = {Jugador2,cadenaPuntaje2};
        
        modelo.addRow(J1);
        modelo.addRow(J2);
        
        JTable tabla = new JTable(modelo);//Pasa los datos de modelo, hacia la tabla.
        JScrollPane scroll = new JScrollPane(tabla);
        tabla.setBounds(50,10,50,50);//Cordenadas X / Y / Alto / Ancho
        setSize(400,400);//Tamaño Frame
        scroll.setBounds(12,22,250,250);
        add(scroll);
        
       
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//--------------------Cerrar Ventana / EXIT_ON_CLOSE
        setLayout(null);
        setVisible(true);  
        
        
    }
    
    public static void sumaPuntoTabla() {
        pts = Tablero.jugador1.getPuntaje();
        pts2= Tablero.jugador2.getPuntaje();
        String [] j1;
        String [] j2;
        j1=new String[] {Jugador1,String.valueOf(pts)};
        j2=new String[] {Jugador2,String.valueOf(pts2)};
        modelo.removeRow(0);
        modelo.removeRow(1);
        modelo.addRow(j1);
        modelo.addRow(j2);
    }
    
    public static void main (String [] a){
         Tabla ta = new Tabla();         
    }    
    
}