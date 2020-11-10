/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memorama;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author LABIAALAP1
 */
public class Tablero extends JFrame {
    public static Jugador jugador1;
    public static Jugador jugador2;
    private static boolean juegoAbierto;
    private static JTextPane p1;
    private static JTextPane p2;
    private static JTextPane ta;
    private static JTextPane ta2;
    private static JTextPane t1;
    private static JTextPane t2;
    private static BotonDestapar[] botones;
    private final JPanel panelBotones;
    private final String[] simbolos = {"A1_Escudo", "A2_Estandarte", "A3_Bandera",
                                       "A4_Lema", "A5_Himno", "B1_EstandarteICL",
                                       "B2_EstandarteICLAEdoMex", "C1_ArbolMora",
                                       "C2_Edificio",
                                       "C3_AulaMagna",
                                       "C4_MuralSint", "C5_MonuMaes",
                                       "C6_Cerro",
                                       "C7_MoniAdolf",
                                       "C8_MonuAutono",
                                       "C9_Colores",
                                       "C10_Contigente",
                                       "C11_Particulares"}; 
    private final int []acomodoPredeterminado = {0, 1, 2, 17, 16, 15, 3, 4, 5,
                         14, 13, 12, 6, 7, 8, 11, 10, 9,
                         9, 10, 11, 8, 7, 6, 12, 13, 14,
                         5, 4, 3, 15, 16, 17, 2, 1, 0};
    
    private final int[] acomodoAzar = new int[36];
    
    public Tablero() {
        this.setTitle("Memorama UAEMex");
        jugador1 = new Jugador(true);
        jugador2 = new Jugador(false);
        p1 = new JTextPane();
        p2 = new JTextPane(); 
        ta = new JTextPane(); 
        ta2 = new JTextPane();         
        t1 = new JTextPane(); 
        t2 = new JTextPane();         
        int i;
        this.setLayout(new CardLayout());
        botones = new BotonDestapar[36];
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(7, 6, 2, 2));
        generaAcomodoAzar2();
        for(i = 0; i < 36; i++) {
            //para un acomodo predeterminado
            //botones[i] = new BotonDestapar(simbolos[acomodoPredeterminado[i]]);
            //para un acomodo al azar
            botones[i] = new BotonDestapar(simbolos[acomodoAzar[i]]);
            panelBotones.add(botones[i]);
        }
        Font font = new Font("Verdana", Font.BOLD, 22);        
        
        p1.setEditable(false);
        p1.setFont(font);
        p1.setOpaque(false);
        p1.setText("\n" + Integer.toString(jugador1.getPuntaje()));
        centrar(p1);
//------------------------------------------------------------------------------        
        DialogoUNO Traer1 = new DialogoUNO();
        String Jugador1 = Traer1.Nombre();
        if(Jugador1.equals("")){
            Jugador1="Jugador1";
        }
        
        DialogoDOS Traer2 = new DialogoDOS();
        String Jugador2 = Traer2.Nombre2();
        if(Jugador2.equals("")){
            Jugador2="Jugador2";
        }
//------------------------------------------------------------------------------        
        
        ta.setEditable(false);
        ta.setText("\n"+Jugador1);
        ta.setOpaque(false);
        ta.setFont(font);
        ta.setForeground(Color.BLUE);
        
        ta2.setEditable(false);
        ta2.setOpaque(false);
        ta2.setText("\n"+Jugador2);
        ta2.setFont(font);
        ta2.setForeground(Color.RED);
        centrar(ta);
        
        p2.setEditable(false);
        p2.setFont(font);
        p2.setOpaque(false);
        p2.setText("\n" + Integer.toString(jugador2.getPuntaje()));
        centrar(p2);
        
        t1.setEditable(false);
        t1.setFont(font);
        t1.setForeground(Color.BLUE);
        t1.setOpaque(false);
        t1.setText("\n<-" );

        t2.setEditable(false);
        t2.setFont(font);
        t2.setForeground(Color.RED);
        t2.setOpaque(false);
        t2.setText("\n" );
        t2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                panelBotones.add(ta);
                panelBotones.add(p1);
                panelBotones.add(t1);
                panelBotones.add(t2);
                panelBotones.add(p2);
        panelBotones.add(ta2);  
        

        
        
        addWindowListener(new CierraVentana());
        this.add(panelBotones);
        this.pack();
        setSize(800, 750);
        setVisible(true);
        
    }
    
    
    public void generaAcomodoAzar1() {
        int i, valor;
        int []indicesAcomodo = new int[18];
        for(i = 0; i < 18; i++) {
            indicesAcomodo[i] = 0;
        }
        Random r = new Random();
        i = 0;
        while(i < 36) {
            valor = r.nextInt(18);
            if(indicesAcomodo[valor] < 2) {
                indicesAcomodo[valor]++;
                acomodoAzar[i] = valor;
                i++;
            }
        }
    }
     
    public void generaAcomodoAzar2() {
        int i, j, valor;
        for(i = 0; i < 36; i++) {
            acomodoAzar[i] = -1;
        }
        boolean existe;
        Random r = new Random();
        i = 0;
        while(i < 18) {
            valor = r.nextInt(18);
            existe = false;
            j = 0;
            while(j <= i) {
                if(acomodoAzar[j] == valor) {
                    existe = true;
                    break;
                }
                j++;
            }
            if(!existe) {
                acomodoAzar[i] = valor;            
                i++;
            }
        }
        i = 18;
        while(i < 36) {
            valor = r.nextInt(18);
            existe = false;
            j = 18;
            while(j <= i) {
                if(acomodoAzar[j] == valor) {
                    existe = true;
                    break;
                }
                j++;
            }
            if(!existe) {
                acomodoAzar[i] = valor;               
                i++;
            }                
        }
    }
    
    class CierraVentana extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.out.println("Cerrando Memorama");
            panelBotones.setVisible (false);
            dispose(); 
            setJuegoAbierto(false);
	}
    }
             
    
    public static boolean diferentes() {
       int i=0;
       boolean impar=false;
       for(BotonDestapar b:botones){
            if(!b.isInmovil() && b.isDestapado()) {
                i++;
            }
            
        }
        if(i>=2){
            for(BotonDestapar b:botones){
            if(!b.isInmovil() && b.isDestapado()) {
                b.tapar();
                impar=true;
            }
            
        }

        }
            return impar;    
    }
    
    public static void centrar(JTextPane ta) {
        StyledDocument doc = ta.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }
    
    public static void cambiaTurno() {      
        if(jugador1.isTurno()){
            jugador1.setTurno(false);
            jugador2.setTurno(true);
            t1.setText("");
            t2.setText("\n<-");
            
        }
        else if(jugador2.isTurno()){
            jugador1.setTurno(true);
            jugador2.setTurno(false);
            t1.setText("\n<-");
            t2.setText("");
        }       
    }
    
    public static void aumentaPuntuación() {
        int total;
        if(jugador1.isTurno()){
            jugador1.sumaPunto();
            
        }
        else if(jugador2.isTurno()){
            jugador2.sumaPunto();
        }   
        escribePunto();
        total = jugador1.getPuntaje() + jugador2.getPuntaje();
        if(total == 18) {
            ganador();
        }
    }
    
    public static void escribePunto(){
        p1.setText("\n" + Integer.toString(jugador1.getPuntaje()));
        p2.setText("\n" + Integer.toString(jugador2.getPuntaje()));
    }
    
    public static void ganador() {
        if(jugador1.getPuntaje() > jugador2.getPuntaje()){
            DialogoUNO Traer1 = new DialogoUNO();
            String Jugador1 = Traer1.Nombre();
            if(Jugador1.equals("")){
                Jugador1="Jugador1";
            }
            JOptionPane.showMessageDialog(null, "Gana "+Jugador1);
        }
        else if(jugador1.getPuntaje() < jugador2.getPuntaje()){
            DialogoDOS Traer2 = new DialogoDOS();
            String Jugador2 = Traer2.Nombre2();
            if(Jugador2.equals("")){
                Jugador2="Jugador2";
            }
            JOptionPane.showMessageDialog(null, "Gana "+Jugador2);
        }
        else{
            JOptionPane.showMessageDialog(null, "Empataron");
        }
    }
    
    public static int Puntaje1(int PuntajeJ1){
      int Puntaje1 = 0;
      Puntaje1 = jugador1.getPuntaje();
      return Puntaje1;
    }
    public static int Puntaje2(int PuntajeJ2){
      int Puntaje2 = 0;
      Puntaje2 = jugador2.getPuntaje(); 
      return Puntaje2;
  }

    public static boolean isJuegoAbierto() {
        return juegoAbierto;
    }

    public static void setJuegoAbierto(boolean juegoAbierto) {
        Tablero.juegoAbierto = juegoAbierto;
    }
   
    
    
}

