/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

/**
 *
 * @author Bernat2
 */
public class IA2 extends IA1 {

    @Override
    public Movimiento movimiento(Tablero tablero) {

        if (intentarGanar(tablero.getCasillas()) != null) {
            return intentarGanar(tablero.getCasillas());
        } else {
            return valorEstrat(tablero);
        }
    }

    public Movimiento intentarGanar(int[][] casillas) {

        int[] coord = new int[2];
        Movimiento movi = new Movimiento();
        movi.setBlancas(false);
        movi.setJugador(this);

        if (comprobarColum(casillas)[0] != -1) {
            coord = comprobarColum(casillas);
            movi.setRow(coord[0]);
            movi.setCol(coord[1]);
            return movi;

        } else if (comprobarFilas(casillas)[0] != -1) {
            coord = comprobarFilas(casillas);
            movi.setRow(coord[0]);
            movi.setCol(coord[1]);
            return movi;
        } else if (comprobarDiag(casillas)[0] != -1) {
            coord = comprobarDiag(casillas);
            movi.setRow(coord[0]);
            movi.setCol(coord[1]);
            return movi;
        } else {
            return null;
        }

    }

    public int[] comprobarColum(int[][] casillas) {

        int[] fichas = new int[3];
        int[] coord = new int[]{-1, -1};
        for (int i = 0; i < casillas[0].length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                fichas[j] = casillas[j][i];
            }
            if (comprobarFichas(fichas) != -1) {
                coord[0] = comprobarFichas(fichas);
                coord[1] = i;
            }
        }

        return coord;
    }

    public int[] comprobarDiag(int[][] casillas) {
        int[] fichas = new int[3];
        int[] coord = new int[]{-1, -1};

        for (int i = 0; i < casillas.length; i++) {
            fichas[i] = casillas[i][i];
        }
        if (comprobarFichas(fichas) != -1) {
            coord[0] = comprobarFichas(fichas);
            coord[1] = comprobarFichas(fichas);
            return coord;
        }

        for (int i = 2, j = 0; j < casillas.length; i--, j++) {
            fichas[j] = casillas[i][j];
        }

        if (comprobarFichas(fichas) != -1) {
            if (comprobarFichas(fichas) == 1) {
                coord[0] = 1;
                coord[1] = comprobarFichas(fichas);
            } else if (comprobarFichas(fichas) == 0) {
                coord[0] = 2;
                coord[1] = comprobarFichas(fichas);

            } else {
                coord[0] = 0;
                coord[1] = comprobarFichas(fichas);
            }
        }

        return coord;

    }

    public int[] comprobarFilas(int[][] casillas) {

        int[] fichas = new int[3];
        int[] coord = new int[]{-1, -1};

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                fichas[j] = casillas[i][j];
            }
            if (comprobarFichas(fichas) != -1) {
                coord[0] = i;
                coord[1] = comprobarFichas(fichas);
            }
        }

        return coord;
    }

    public int comprobarFichas(int[] fichas) {
        int contador = 0;

        for (int i = 0; i < fichas.length; i++) {
            if (fichas[i] == -1) {
                contador++;
            }
        }

        if (contador == 2) {
            for (int i = 0; i < fichas.length; i++) {
                if (fichas[i] != -1) {
                    if (fichas[i] == 0) {
                        return i;
                    } else {
                        return -1;
                    }
                }
            }
        }

        return -1;
    }

    public Movimiento valorEstrat(Tablero tablero) {
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
