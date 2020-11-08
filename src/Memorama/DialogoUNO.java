package Memorama;

import java.awt.*;
import java.awt.event.*;

public class DialogoUNO extends Principal implements ActionListener {

  public static Frame f;
  public static Dialog d;
  public static Panel dp;
  
  public static Button db1;
  public static Button db2;
  
  public static Label dl;
  public static Label d2;
  
  private TextField tf;

  public void go () {     

    d = new Dialog(f, "Dialogo", true);
    dp = new Panel();
    dp.setLayout(new FlowLayout());
    
    db1 = new Button("Empezar Juego");
    db2 = new Button("Cancelar");
    
    dp.add(db1);
    dp.add(db2);
    
    tf = new TextField("", 2);
    tf.addKeyListener(new NameHandler());
    
    dl = new Label ("Juego Memorama UAEMEX");
    d2 = new Label ("Selecciona El Numero De Jugadores");
    
    d.add(dl,BorderLayout.PAGE_START);
    d.add(d2,BorderLayout.BEFORE_LINE_BEGINS);
    d.add(tf,BorderLayout.CENTER);
    d.add(dp,BorderLayout.SOUTH);
    
    d.pack();

    db1.addActionListener(this);
    db2.addActionListener(this);

    d.setVisible(true);
  }
//------------------------------------------------------------------------------
  public void actionPerformed( ActionEvent ae) {
    String buttonPressed = ae.getActionCommand();
        if (buttonPressed.equals("Empezar Juego")) {
            System.out.println("Destapa Las Cartas Y Encuentra Su Igual");
            d.setVisible(false);
            d.dispose ();
         
        } else if (buttonPressed.equals("Cancelar")) {
            System.out.println("Volveras Al Menu Principal");
            //PestañaArchivos.Guardar(ta);
            d.setVisible(false);
            d.dispose (); 
        }
  }
//------------------------------------------------------------------------------  
  
  class NameHandler extends KeyAdapter {
    public void keyPressed(KeyEvent e) {
      char c = e.getKeyChar();
      if ( Character.isDigit(c)) {
          System.out.println("Ingresa Un Valor Numerico");        
      }else{
          e.consume();
      }
    }
  }
  
}
