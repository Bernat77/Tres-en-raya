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

    protected int[][] pesos;

    IA1() {
        pesos = new int[][]{{3, 2, 3}, {2, 4, 2}, {3, 2, 3}};
    }

    @Override
    public Movimiento movimiento(Tablero tablero) {

        int[][] casillas = tablero.getCasillas();
        Movimiento movi = new Movimiento();
        int x = 0;
        int y = 0;

        //Busca una casilla vacía y guarda sus coordenadas.
        
        buscar:     //etiquetamos el bucle grande
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (tablero.getCasilla(i, j) == 0) {
                    x = i;
                    y = j;
                    break buscar;       //para romperlo en cuanto encuentre la primera casilla vacía.

                }
            }
        }

//Hará una comparación entre la casilla vacía que ha guardado y las demás casillas disponibles. Si hay una de mayor peso se quedará con esa.
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
