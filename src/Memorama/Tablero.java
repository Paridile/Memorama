/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memorama;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author LABIAALAP1
 */
public class Tablero extends JFrame {
    private final BotonDestapar[] botones;
    private final JPanel panelBotones;
    private final String[] simbolos = {"Escudo", "Estandarte", "Bandera",
                                       "Lema", "Himno", "EstandarteICL",
                                       "EstandarteICLAEdoMex", "ArbolMora",
                                       "EdificioCentralRectoria",
                                       "AulaMagnaLicAdolfoLopezMateos",
                                       "MuralSintesis", "MonumentoMaestros",
                                       "CerroCoatepec",
                                       "MonumentoMemoriaAdolfoLopezMateos",
                                       "MonumentoAutonomiaUniversitaria",
                                       "ColoresVerdeOro",
                                       "ContingenteCivicoDeportivoUniversitario",
                                       "ParticularesAdministracionUniversitaria"}; 
    private final int []acomodoPredeterminado = {0, 1, 2, 3, 4, 5, 6, 7, 8,
                         9, 10, 11, 12, 13, 14, 15, 16, 17,
                         0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                         10, 11, 12, 13, 14, 15, 16, 17};
    
    private final int[] acomodoAzar = new int[36];
    
    public Tablero() {
        int i;
        botones = new BotonDestapar[36];
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(6, 6, 2, 2));
        generaAcomodoAzar2();
        for(i = 0; i < 36; i++) {
            //para un acomodo predeterminado
            //botones[i] = new BotonIdentidad(simbolos[acomodoPredeterminado[i]]);
            //para un acomodo al azar
            
    
            botones[i] = new BotonDestapar(simbolos[acomodoAzar[i]]);
            panelBotones.add(botones[i]);
            
     
            
        }
//------------------------------------------------------------------------------  


//------------------------------------------------------------------------------        
        
        addWindowListener(new CierraVentana());
        getContentPane().add("Center", panelBotones);
        setSize(800, 700);
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
        boolean existe;// true / false
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
	}
    }
    
    public int addpuntos(){
        int correct = 0;
        correct = correct +1;
        return correct;     
    }
    
}

