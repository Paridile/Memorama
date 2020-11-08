package Memorama;

public class Jugador {
    private  int puntaje;
    private  boolean turno;

    public Jugador(boolean turno) {
        this.puntaje = 0;
        this.turno = turno;
    }
    
    public  void sumaPunto() {
        puntaje++;
    }

    public  int getPuntaje() {
        return puntaje;
    }

    public  void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }  

    public  boolean isTurno() {
        return turno;
    }

    public  void setTurno(boolean turno) {
       this.turno = turno;
    }
    
}
