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

    public IA0() {

    }

    public Movimiento movimientoia(Tablero tablero) {
        int[][] casillas = tablero.getCasillas();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; i < casillas[i].length; j++) {
                if (tablero.getCasilla(i, j) == 0) {
                    return movimiento(i, j);
                }
            }
        }
        return null;
    }

}
