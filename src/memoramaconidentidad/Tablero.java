/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoramaconidentidad;

import javax.swing.JButton;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.TextArea;
import javax.swing.JLabel;

/**
 *
 * @author LABIAALAP1
 */
public class Tablero extends JFrame {
    private final BotonIdentidad[] botones;
    private final JPanel panelBotones, panelJugadores;
    private final JFrame f;
    private final JLabel j1, j2, espacio;
    private final TextArea t1, t2;
    private final Button boton1;
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
        botones = new BotonIdentidad[36];
        panelBotones = new JPanel();
        panelJugadores = new JPanel();
        f = new JFrame("Ayuda diosito ya no me sale semen");
        boton1 = new Button("XD");
        panelBotones.setLayout(new GridLayout(6, 6, 2, 2));
        generaAcomodoAzar2();
        for(i = 0; i < 36; i++) {
            //para un acomodo predeterminado
            //botones[i] = new BotonIdentidad(simbolos[acomodoPredeterminado[i]]);
            //para un acomodo al azar
            botones[i] = new BotonIdentidad(simbolos[acomodoAzar[i]]);
            panelBotones.add(botones[i]);
        }
        //getContentPane().add("Center", panelBotones);
        panelBotones.setSize(800, 700);
        panelBotones.setVisible(true);
        j1 = new JLabel("Jugador 1");
        
        espacio = new JLabel("      ");
        j2 = new JLabel("Jugador 2");
       
        panelJugadores.add(j1, BorderLayout.WEST);
        
        panelJugadores.add(espacio, BorderLayout.CENTER);
        
        panelJugadores.add(j2, BorderLayout.EAST);
        
        f.add(panelBotones, BorderLayout.NORTH);
        f.add(panelJugadores, BorderLayout.CENTER);
        /*addWindowListener(new CierraVentana());
        getContentPane().add("Center", panelBotones);
        setSize(800, 700);
        setVisible(true);*/
        
        f.pack();

        f.setSize(900,900);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
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
}
