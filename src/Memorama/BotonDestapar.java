
package Memorama;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotonDestapar extends JButton implements ActionListener {
    private String simbolo;
    private boolean destapado;
    public BotonDestapar(String simbolo) {
     
        super();
        int ct=0;
       do{
           
        setIcon(new ImageIcon("simbolos/Yugioh.png"));
        this.simbolo = simbolo;
        destapado = false;
        addActionListener(this);  
               ct=ct+1;
    }while(ct<5);
        System.out.println("Final");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!destapado) {
            destapado = true;
            setIcon(new ImageIcon("simbolos/" + simbolo +".png"));
        }            
        else {
            destapado = false;
            setIcon(new ImageIcon("simbolos/Yugioh.png"));
        }
    }
}
