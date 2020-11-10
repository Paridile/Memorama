package Memorama;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author LABIAALAP1
 */
public class BotonDestapar extends JButton implements ActionListener {
    private boolean inmovil;
    private String simbolo;
    private boolean destapado;

    public BotonDestapar(String simbolo) {
        super();
        setIcon(new ImageIcon("simbolos/Carta_Volteada.png"));
        this.simbolo = simbolo;
        destapado = false;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { 

//        if(Validar.compara(destapado, simbolo)){
//           // Tablero.inmoviliza(simbolo);
//        }     
        if(!Tablero.diferentes()) {

        if(!destapado) {
            destapar();  
            if(Validar.getB1() == null){                
                Validar.setB1(this);
                if(Validar.getB1().isInmovil()){
                    Validar.setB1(null);
                }
            }
            else if(Validar.getB2() == null){
                Validar.setB2(this);
                if(Validar.getB2().isInmovil()){
                    Validar.setB1(null);
                }
            }
            if (Validar.getB1() != null && Validar.getB2() != null) {
                    if(!Validar.comparaCasillas()){
                        Tablero.cambiaTurno();
                    }
                    Validar.setB1(null);
                    Validar.setB2(null);
            }
        }            
        else {
            if(!inmovil){
                //tapar();
            }
        }    
        }
    }  
    
    public void destapar() {
        setIcon(new ImageIcon("simbolos/" + simbolo +".png"));
        destapado = true;
    }
    
    public void tapar(){
        destapado = false;
        setIcon(new ImageIcon("simbolos/Carta_Volteada.png"));
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

    public boolean isDestapado() {
        return destapado;
    }

    public void setDestapado(boolean destapado) {
        this.destapado = destapado;
    }

}