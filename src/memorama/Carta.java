/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorama;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author pablo
 */
public class Carta extends JLabel{

    private ImageIcon reversed;
    private ImageIcon simbolo;
    private boolean estado;
    private String set;
    private boolean inmovilizada;
    public Carta( ){
        super();
        Dimension d = new Dimension(25,25);
        setSize( d );
        setIcon( reversed );
        setVisible(true);
    }

    public boolean isInmovilizada() {
        return inmovilizada;
    }

    public void setInmovilizada(boolean inmovilizada) {
        this.inmovilizada = inmovilizada;
    }

    public String isSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public ImageIcon getReversed() {
        return reversed;
    }

    public void setReversed(ImageIcon reversed) {
        this.reversed = reversed;
    }

    public ImageIcon getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(ImageIcon simbolo) {
        this.simbolo = simbolo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


}
