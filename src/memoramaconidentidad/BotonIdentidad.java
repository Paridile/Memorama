/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoramaconidentidad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author LABIAALAP1
 */
public class BotonIdentidad extends JButton implements ActionListener {
    private boolean inmovil;
    private String simbolo;
    private boolean destapado;

    public BotonIdentidad(String simbolo) {
        super();
        setIcon(new ImageIcon("simbolos/Carta_Volteada.png"));
        this.simbolo = simbolo;
        destapado = false;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { 

        if(Validar.compara(destapado, simbolo)){
            Tablero.inmoviliza(simbolo);
        }        
        if(!destapado) {
            destapado = true;
            setIcon(new ImageIcon("simbolos/" + simbolo +".png"));
        }            
        else {
                if(!inmovil){
                destapado = false;
                setIcon(new ImageIcon("simbolos/Carta_Volteada.png"));
                }
        }
    }  

    public String getSimbolo() {
        return simbolo;
    }

    public boolean isInmovil() {
        return inmovil;
    }

    public void setInmovil(boolean inmovil) {
        this.inmovil = inmovil;
    }
    
}
