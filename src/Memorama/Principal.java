package Memorama;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class Principal extends WindowAdapter implements ActionListener{
    private JFrame f;//---------------------------------------------------VENTANA
    private MenuBar mb;//------------------------------------------BARRA DE MENU
    private BufferedImage img;
    
    private Menu m1;//-----------------------------------------PESTAÑA 1:JUEGO
    private Menu m2;//-----------------------------------------PESTAÑA 2:AYUDA
//------------------------------------------------------------------------------BOTONES DE LA PESTAÑA 1: JUEGO
    private MenuItem juegoNuevo;
    //private MenuItem nuevaVentana;
    private MenuItem puntajes;
    private MenuItem salir;
//------------------------------------------------------------------------------BOTONES DE LA PESTAÑA 2: AYUDA  
    private MenuItem creadores;
    private MenuItem acercaDelJuego;   
    
//------------------------------------------------------------------------------MAIN DE EJECUCIÓN
  public static void main (String args[]) {
    Principal Traer1 = new Principal();
    Traer1.go();
  }
  
  
//------------------------------------------------------------------------------VOID: PARAMETROS DE ACCIÓN
  public void go() {
//------------------------------------------------------------------------------ACCIONES DEL PROGRAMA
    f = new JFrame("Memorama UAEMEX");//-------------------------------TITULO DE LA VENTANA
    f.setSize(400,400);//-------------TAMAÑO DE LA VENTA (HORIZONTAL * VERTICAL)
    f.setVisible(true);//--------------------------------------------VER VENTANA
    f.addWindowListener((WindowListener) this);    
    f.setLocationRelativeTo(null); 
    img = null;
    try {
        img = ImageIO.read(new File("simbolos/principal.jpg"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    Image dimg = img.getScaledInstance(330, 300, Image.SCALE_SMOOTH);
    ImageIcon imageIcon = new ImageIcon(dimg);
    f.setContentPane(new JLabel(imageIcon));
    
    
//------------------------------------------------------------------------------ACCIONES DE LA BARRA DE MENU
    mb = new MenuBar();//------------------------------------------BARRA DE MENU
    f.setMenuBar(mb);//----------------------COLOCAR BARRA DE MENU EN LA VENTANA        
//------------------------------------------------------------------------------PESTAÑAS
    m1 = new Menu("Juego");//----------------------------------NOMBRAR PESTAÑA
    m2 = new Menu("Ayuda");    
//------------------------------------------------------------------------------COLOCAR PESTAÑAS EN LA BARRA DE MENU
    mb.add(m1);
    mb.add(m2);    
//------------------------------------------------------------------------------BOTONES DE PESTAÑA "ARCHIVO"    
    juegoNuevo = new MenuItem("Juego Nuevo");//--------------NOMBRAR BOTONES DE LA PESTAÑA"
   // nuevaVentana = new MenuItem("Nueva Ventana");
    puntajes = new MenuItem("Puntajes");
    puntajes.setEnabled(false);
    salir = new MenuItem("Salir");
        
    m1.add(juegoNuevo);//------------------------METER BOTONES A LA PESTAÑA "ARCHIVO"
    //m1.add(nuevaVentana);
    m1.add(puntajes);
    m1.add(salir);
//------------------------------------------------------------------------------BOTONES DE PESTAÑA "AYUDA"     
    creadores = new MenuItem("Creadores");
    acercaDelJuego = new MenuItem("Acerca Del Juego");
    
    m2.add(creadores);
    m2.add(acercaDelJuego);
//------------------------------------------------------------------------------IMPLEMENTAR BOTONES ALL  
    juegoNuevo.addActionListener(this);
    //nuevaVentana.addActionListener(this);
    puntajes.addActionListener(this);
    salir.addActionListener(this);
    creadores.addActionListener(this);
    acercaDelJuego.addActionListener(this);  
    m1.addActionListener(this);
    Tablero.setJuegoAbierto(false);
  }
//------------------------------------------------------------------------------CIERRE GO
  
  
//------------------------------------------------------------------------------VOID: EVENTOS
    public void actionPerformed(ActionEvent ev){
        System.out.println("Opcion \"" + ev.getActionCommand() + "\" Elegida.");
        switch(ev.getActionCommand()){
//------------------------------------------------------------------------------PESTAÑA JUEGO            
            case "Juego Nuevo":
            if(!Tablero.isJuegoAbierto()){
                PestañaJuego.Nuevo();     
                puntajes.setEnabled(true);
                Tablero.setJuegoAbierto(true);
            }
            else {
                alertaJuegoAbierto();
            }
            break;
            case "Nueva Ventana":
                PestañaJuego.NuevaVentana();
            break;
            case "Puntajes":
                PestañaJuego.Puntajes();
            break;
            case "Salir":                
                PestañaJuego.Salir();
            break;
//------------------------------------------------------------------------------PESTAÑA AYUDA             
            case "Creadores":
                PestañaJuego.Creadores();
            break;
            case "Acerca Del Juego":
                PestañaJuego.AcercaDelJuego();
            break;                 
        }
      
    }
    
    
    
    
    
 //------------------------------------------------------------------------------VOID: Validar juego abierto
    public void alertaJuegoAbierto(){
        JOptionPane.showMessageDialog(null, "Ya tienes abierto un memorama");
    }   
    
//------------------------------------------------------------------------------VOID: BOTON CERRAR VENTANA
    public void windowClosing(WindowEvent ev){
        System.out.println("Cerrando Memorama");
        f.setVisible (false);
        f.dispose ();
    }
//------------------------------------------------------------------------------VOID: ITEM STATE  
    public void itemStateChanged(ItemEvent ie) {
        String state = "deselected";
        if (ie.getStateChange() == ItemEvent.SELECTED) {
            state = "selected";
        }
        System.out.println(ie.getItem() + " " + state);
    }        
}