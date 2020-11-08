package memoramaconidentidad;

public class Jugador {
    private static int numero;
    private static int puntaje;
    private boolean turno;

    public Jugador(int numero) {
        this.numero = numero;
        this.puntaje = 0;
    }
    
    public static void sumaPunto() {
        puntaje++;
    }

    public static int getPuntaje() {
        return puntaje;
    }

    public static void setPuntaje(int puntaje) {
        Jugador.puntaje = puntaje;
    }       
}
