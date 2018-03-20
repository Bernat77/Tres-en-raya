package sesion;

public class Movimiento {

    private boolean blancas;
    private int col;
    private int row;
    private Jugador jugador;

    Movimiento() {

    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setBlancas(boolean blanca) {
        blancas = blanca;
    }

    public void setRow(int r) {
        row = r;
    }

    public void setCol(int c) {
        col = c;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public boolean getBlancas() {
        return blancas;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}
