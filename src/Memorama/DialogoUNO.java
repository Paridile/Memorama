package Memorama;
/**
 *
 * @author Aarón
 */
import java.awt.*;
import java.awt.event.*;

public class DialogoUNO extends Principal implements ActionListener {

  public static Frame f;
  public static Dialog d;
  public static Panel dp;
  
  public static Button db1;
  
  public static Label dl;
  public static Label d2;
  
  
  public static TextField tf1;


  public void go () {     

    d = new Dialog(f, "Dialogo", true);
    dp = new Panel();
    dp.setLayout(new FlowLayout());
    
    db1 = new Button("¡¡¡Listo!!!");
    
    dp.add(db1);
    
    tf1 = new TextField("", 2);
    tf1.addKeyListener(new NameHandler());

    
    dl = new Label ("Nombre De Jugador 1");
    d.setLocationRelativeTo(null); 
    d.add(dl,BorderLayout.PAGE_START);
    d.add(tf1,BorderLayout.CENTER);
    
    d.add(dp,BorderLayout.PAGE_END);
    
    d.pack();

    db1.addActionListener(this);

    d.setVisible(true);
  }
//------------------------------------------------------------------------------
  public void actionPerformed( ActionEvent ae) {    
    String buttonPressed = ae.getActionCommand();
        if (buttonPressed.equals("¡¡¡Listo!!!")) {
            System.out.println("Destapa Las Cartas Y Encuentra Su Igual");
            d.setVisible(false);
            d.dispose ();         
        } 
  }
//------------------------------------------------------------------------------  
  
  class NameHandler extends KeyAdapter {
    public void keyPressed(KeyEvent e) {
      char c = e.getKeyChar();
      if ( Character.isDigit(c)) {
            e.consume();  
      }
    }
  }
  
  public String Nombre(){
      String Nombre1 = "";
      Nombre1 = tf1.getText();
      System.out.println(Nombre1);
      return Nombre1;      
  }
  
}
