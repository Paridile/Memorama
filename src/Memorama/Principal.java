package Memorama;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;



public class Principal extends WindowAdapter implements ActionListener{
    private Frame f;//---------------------------------------------------VENTANA
    private MenuBar mb;//------------------------------------------BARRA DE MENU
    private Label LTitulo; 
    
    private Menu m1;//-----------------------------------------PESTAÑA 1:JUEGO
    private Menu m2;//-----------------------------------------PESTAÑA 2:AYUDA
//------------------------------------------------------------------------------BOTONES DE LA PESTAÑA 1: JUEGO
    private MenuItem juegoNuevo;
    private MenuItem nuevaVentana;
    private MenuItem salir;
//------------------------------------------------------------------------------BOTONES DE LA PESTAÑA 2: AYUDA  
    private MenuItem verAyuda;
    private MenuItem enviarComentarios;
    private MenuItem acercaDelJuego;            
//------------------------------------------------------------------------------MAIN DE EJECUCIÓN
  public static void main (String args[]) {
    Principal Traer1 = new Principal();
    Traer1.go();
  }
//------------------------------------------------------------------------------VOID: PARAMETROS DE ACCIÓN
  public void go() {
//------------------------------------------------------------------------------ACCIONES DEL PROGRAMA
    f = new Frame("Memorama UAEMEX");//-------------------------------TITULO DE LA VENTANA
    f.setSize(400,400);//-------------TAMAÑO DE LA VENTA (HORIZONTAL * VERTICAL)
    f.setVisible(true);//--------------------------------------------VER VENTANA
    f.addWindowListener((WindowListener) this);    
    
    
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
    nuevaVentana = new MenuItem("Nueva Ventana");
    salir = new MenuItem("Salir");
        
    m1.add(juegoNuevo);//------------------------METER BOTONES A LA PESTAÑA "ARCHIVO"
    m1.add(nuevaVentana);
    m1.add(salir);
//------------------------------------------------------------------------------BOTONES DE PESTAÑA "AYUDA"     
    verAyuda = new MenuItem("Ver Ayuda");
    enviarComentarios = new MenuItem("Enviar Comentarios");
    acercaDelJuego = new MenuItem("Acerca Del Juego");
    
    m2.add(verAyuda);//------------------------METER BOTONES A LA PESTAÑA "AYUDA"
    m2.add(enviarComentarios);
    m2.add(acercaDelJuego);
//------------------------------------------------------------------------------IMPLEMENTAR BOTONES ALL  
    juegoNuevo.addActionListener(this);
    nuevaVentana.addActionListener(this);
    salir.addActionListener(this);
    verAyuda.addActionListener(this);
    enviarComentarios.addActionListener(this);
    acercaDelJuego.addActionListener(this);    
  }
//------------------------------------------------------------------------------CIERRE GO

//------------------------------------------------------------------------------VOID: EVENTOS
    public void actionPerformed(ActionEvent ev){
        System.out.println("Opcion \"" + ev.getActionCommand() + "\" Elegida.");
        switch(ev.getActionCommand()){
//------------------------------------------------------------------------------PESTAÑA JUEGO            
            case "Juego Nuevo":
            PestañaJuego.Nuevo();           
            break;
            case "Nueva Ventana":
                PestañaJuego.NuevaVentana();
            break;
            case "Salir":                
                //PestañaArchivos.Abrir(f,ta);
            break;
//------------------------------------------------------------------------------PESTAÑA AYUDA             
            case "Ver Ayuda":
                //PestañaArchivos.Guardar(ta);//Falta comparar INCOMPLETO
            break;
            case "Enviar Comentarios":
                //PestañaArchivos.GuardarComo(ta);
            break;
            case "Acera Del Juego":
                //Instrucciones.nuevo(ta);//INCOMPLETO
            break;            
        }
      
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