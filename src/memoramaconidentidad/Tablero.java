/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoramaconidentidad;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
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
import javax.swing.JTextPane;

/**
 *
 * @author LABIAALAP1
 */
public class Tablero extends JFrame {
    private  final BotonIdentidad[] botones;
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
        Font font = new Font("Verdana", Font.BOLD, 12);
        int i;
        JTextPane ta = new JTextPane();
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
            //botones[i] = new BotonIdentidad(simbolos[acomodoPredeterminado[i]]);
            //para un acomodo al azar
            botones[i] = new BotonIdentidad(simbolos[acomodoAzar[i]]);
            panelBotones.add(botones[i]);
        }
        JPanel xd = new JPanel();
        JPanel xd2 = new JPanel();
        JPanel xd3 = new JPanel();
        JPanel xd4 = new JPanel();
        panelBotones.add(ta);
        ta.setText("\n\n:O");
        ta.setFont(font);
        ta.setForeground(Color.white);
        ta.setBackground(Color.BLUE);
        
        JTextPane ta2 = new JTextPane();
                panelBotones.add(xd);
                panelBotones.add(xd2);
                panelBotones.add(xd3);
                panelBotones.add(xd4);
        panelBotones.add(ta2);      
        ta2.setText("xdd");
        ta2.setBackground(Color.red);

        
        
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
    
     
    public static void nombreBotones() {
        
        //for(BotonIdentidad b: botones)
        //System.out.println(b.getName());
    }
}

