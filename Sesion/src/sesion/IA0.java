/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

/**
 *
 * @author dam1a14
 */
public class IA0 extends Jugador {

    public Movimiento movimiento(Tablero tablero) {
        int[][] casillas = tablero.getCasillas();
        Movimiento jugada = new Movimiento();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (tablero.getCasilla(i, j) == 0) {
                    jugada.setRow(i);
                    jugada.setCol(j);
                    jugada.setJugador(this);
                    jugada.setBlancas(false);
                    return jugada;
                }
            }
        }
        return null;
    }

}
