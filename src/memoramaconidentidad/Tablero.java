/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoramaconidentidad;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author LABIAALAP1
 */
public class Tablero extends JFrame {
    Jugador jugador1 = new Jugador(1);
    Jugador jugador2 = new Jugador(2);
    private static BotonIdentidad[] botones;
    private final JPanel panelBotones;
    private final JPanel puntaje;
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
        int i;
        this.setLayout(new CardLayout());
        puntaje = new JPanel();
        puntaje.setSize(800, 100);
        puntaje.setBackground(Color.red);
        botones = new BotonIdentidad[36];
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(7, 6, 2, 2));
        generaAcomodoAzar2();
        for(i = 0; i < 36; i++) {
            //para un acomodo predeterminado
            botones[i] = new BotonIdentidad(simbolos[acomodoPredeterminado[i]]);
            //para un acomodo al azar
            //botones[i] = new BotonIdentidad(simbolos[acomodoAzar[i]]);
            panelBotones.add(botones[i]);
        }
        Font font = new Font("Verdana", Font.BOLD, 22);        
        
        //ta.setBackground(Color.BLUE);
        JTextPane p1 = new JTextPane();
        p1.setEditable(false);
        p1.setFont(font);
        p1.setOpaque(false);
        p1.setText("\n" + Integer.toString(jugador1.getPuntaje()));
        centrar(p1);
        
        JTextPane ta = new JTextPane();           
        ta.setEditable(false);
        ta.setText("\nJugador 1");
        ta.setOpaque(false);
        ta.setFont(font);
        ta.setForeground(Color.BLUE);
        
        JTextPane ta2 = new JTextPane(); 
        ta2.setEditable(false);
        ta2.setOpaque(false);
        ta2.setText("\nJugador 2");
        ta2.setFont(font);
        ta2.setForeground(Color.RED);
        centrar(ta);
        
        
        JTextPane p2 = new JTextPane();
        p2.setEditable(false);
        p2.setFont(font);
        p2.setOpaque(false);
        p2.setText("\n" + Integer.toString(jugador2.getPuntaje()));
        centrar(p2);
        
        JTextPane t1 = new JTextPane();
        t1.setEditable(false);
        t1.setFont(font);
        t1.setForeground(Color.BLUE);
        t1.setOpaque(false);
        t1.setText("\n<-" );

        
        JTextPane t2 = new JTextPane();
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
            dispose();
            System.exit(0);
	}
    }
             
    
    public static boolean diferentes() {
       int i=0;
       boolean impar=false;
       for(BotonIdentidad b:botones){
            if(!b.isInmovil() && b.isDestapado()) {
                i++;
            }
            
        }
        if(i>=2){
            for(BotonIdentidad b:botones){
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
    
}

