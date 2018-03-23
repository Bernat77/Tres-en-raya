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
public class IA1 extends IA0 {

    private int[][] pesos;

    IA1() {
        pesos = new int[][]{{3, 2, 3}, {2, 4, 2}, {3, 2, 3}};
    }

    @Override
    public Movimiento movimiento(Tablero tablero) {

        Movimiento movi = new Movimiento();
        int x, y;
        x = 0;
        y = 0;
        for (int i = 0; i < pesos.length; i++) {
            for (int j = 0; j < pesos[i].length; j++) {
                if (pesos[x][y] < pesos[i][j] && tablero.getCasilla(i, j) == 0) {
                    x = i;
                    y = j;
                }
            }

        }        
        movi.setRow(x);
        movi.setCol(y);
        movi.setBlancas(false);
        movi.setJugador(this);
        return movi;
    }

    
    
    
    
    
    
    
}
