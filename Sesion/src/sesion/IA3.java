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
public class IA3 extends IA2 {

    @Override
    public Movimiento movimiento(Tablero tablero) {

        if (intentarGanar(tablero.getCasillas()) != null) {
            return intentarGanar(tablero.getCasillas());
        } else if (intentarNoperder(tablero.getCasillas()) != null) {
            return intentarNoperder(tablero.getCasillas());
        } else {
            return valorEstrat(tablero);
        }
    }

    public Movimiento intentarNoperder(int[][] casillas) {
        int[] coord = new int[2];
        Movimiento movi = new Movimiento();
        movi.setBlancas(false);
        movi.setJugador(this);

        if (noperderColum(casillas)[0] != -1) {
            coord = noperderColum(casillas);
            movi.setRow(coord[0]);
            movi.setCol(coord[1]);
            return movi;

        } else if (noperderFilas(casillas)[0] != -1) {
            coord = noperderFilas(casillas);
            movi.setRow(coord[0]);
            movi.setCol(coord[1]);
            return movi;
        } else if (noperderDiag(casillas)[0] != -1) {
            coord = noperderDiag(casillas);
            movi.setRow(coord[0]);
            movi.setCol(coord[1]);
            return movi;
        } else {
            return null;
        }

    }

    public int[] noperderColum(int[][] casillas) {

        int[] fichas = new int[3];
        int[] coord = new int[]{-1, -1};
        for (int i = 0; i < casillas[0].length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                fichas[j] = casillas[j][i];
            }
            if (noperderFichas(fichas) != -1) {
                coord[0] = noperderFichas(fichas);
                coord[1] = i;
            }
        }

        return coord;
    }

    public int[] noperderDiag(int[][] casillas) {
        int[] fichas = new int[3];
        int[] coord = new int[]{-1, -1};

        for (int i = 0; i < casillas.length; i++) {
            fichas[i] = casillas[i][i];
        }
        if (noperderFichas(fichas) != -1) {
            coord[0] = noperderFichas(fichas);
            coord[1] = noperderFichas(fichas);
            return coord;
        }

        for (int i = 2, j = 0; j < casillas.length; i--, j++) {
            fichas[j] = casillas[i][j];
        }

        if (noperderFichas(fichas) != -1) {
            if (noperderFichas(fichas) == 1) {
                coord[0] = 1;
                coord[1] = noperderFichas(fichas);
            } else if (noperderFichas(fichas) == 0) {
                coord[0] = 2;
                coord[1] = noperderFichas(fichas);

            } else {
                coord[0] = 0;
                coord[1] = noperderFichas(fichas);
            }
        }

        return coord;

    }

    public int[] noperderFilas(int[][] casillas) {

        int[] fichas = new int[3];
        int[] coord = new int[]{-1, -1};

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                fichas[j] = casillas[i][j];
            }
            if (noperderFichas(fichas) != -1) {
                coord[0] = i;
                coord[1] = noperderFichas(fichas);
            }
        }

        return coord;
    }

    public int noperderFichas(int[] fichas) {
        int contador = 0;

        for (int i = 0; i < fichas.length; i++) {
            if (fichas[i] == 1) {
                contador++;
            }
        }

        if (contador == 2) {
            for (int i = 0; i < fichas.length; i++) {
                if (fichas[i] != 1) {
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

}
