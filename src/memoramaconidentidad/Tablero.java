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
import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 *
 * @author LABIAALAP1
 */
public class Tablero extends JFrame {
    private static BotonIdentidad b1;
    private static BotonIdentidad b2;
    private int puntaje=0;
    private final BotonIdentidad[] botones;
    private final JPanel panelBotones, panelJu;
    private final JFrame f;
    private final JLabel labelJ1, labelJ2, espacio, labelP1, labelP2;
    private final JButton boton1, boton, prueba;
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
    
    private final String[] playerOne = {"JugadorUno"};
    
    private final String[] playerDos = {"JugadorDos"};
    
    private final int []acomodoPredeterminado = {0, 1, 2, 17, 16, 15, 3, 4, 5,
                         14, 13, 12, 6, 7, 8, 11, 10, 9,
                         9, 10, 11, 8, 7, 6, 12, 13, 14,
                         5, 4, 3, 15, 16, 17, 2, 1, 0};
    
    private final int[] acomodoAzar = new int[36];
    
    public Tablero() {
        int i;
        botones = new BotonIdentidad[36];
        panelBotones = new JPanel();
        
        panelJu = new JPanel();
        panelJu.setLayout(new BoxLayout(panelJu,BoxLayout.Y_AXIS));
        panelJu.setBounds(50, 50, 300, 700);
        labelJ1 = new JLabel("Jugador 1");
        labelJ2 = new JLabel("Jugador 2");
        labelP1 = new JLabel("0");
        labelP2 = new JLabel("0");
        espacio = new JLabel("      ");
        
        
        f = new JFrame("Ayuda diosito ya no me sale semen");
        boton1 = new JButton("Contador: ");
        boton1.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton = new JButton("Contador: ");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        prueba = new JButton("Pruebitas");
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
        
        
        labelJ1.setBounds(30, 10, 200, 30);
        labelJ1.setFont(new Font("cooper black",0,30));
        labelJ1.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        labelP1.setBounds(30, 10, 300, 30);
        labelP1.setFont(new Font("cooper black",0,30));
        labelP1.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        espacio.setBounds(30, 10, 300, 30);
        espacio.setFont(new Font("cooper black",0,30));
        espacio.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        labelJ2.setBounds(30, 30, 500, 30);
        labelJ2.setFont(new Font("cooper black",0,30));
        labelJ2.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        labelP2.setBounds(30, 10, 300, 30);
        labelP2.setFont(new Font("cooper black",0,30));
        labelP2.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panelJu.add(labelJ1);
        panelJu.add(labelP1);
        
        panelJu.add(espacio);
        
        panelJu.add(labelJ2);
        panelJu.add(labelP2);
        //panelJu.setSize(300, 700);
        panelJu.setVisible(true);
        
        f.add(panelBotones, BorderLayout.CENTER);
        f.add(panelJu, BorderLayout.EAST);
        
        //f.pack();

        f.setSize(1000,850);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }
    
    public void contador(){
        boolean iguales = false;
        if(b1.getSimbolo().equals(b2.getSimbolo())) {
            System.out.println("Iguales");
            b1.setInmovil(true);
            b2.setInmovil(true);
            puntaje+=10;
            labelP1.setText(puntaje+"");
        }
        else{    
                iguales = true;
        }
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
