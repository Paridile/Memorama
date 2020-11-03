/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorama;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Uriel
 */
public class Ventana implements ActionListener, ItemListener {
    private JFrame f;
    
    public void go(){
        f = new JFrame("Memorama de cagada");
        f.pack();

        f.setSize(900,900);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent we){
        System.exit(0);
        }
        });
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
