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
public class Tablero {

    private Partida partida;
    private int[][] casillas;

    public Tablero() {
        casillas = new int[3][3];
    }

    public void mostrar() {
        for (int i = 0; i < casillas.length; i++) {
            System.out.print("  _  _  _ ");
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print("| " + casillas[i][j] + " |");
            }
            System.out.println();
        }
    }

    public boolean getCasilla(int row, int col) {
        
        
    }

    public boolean comprobarGanador() {

        if (comprobarFilas() || comprobarColum() || comprobarDiag()) {
            return true;
        }

        return false;

    }

    public boolean comprobarFichas(int[] fichas) {
        for (int i = 1; i < fichas.length; i++) {
            if (fichas[i - 1] != fichas[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean comprobarFilas() {

        int[] fichas = new int[3];

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                fichas[j] = casillas[i][j];
            }
            if (comprobarFichas(fichas)) {
                return true;
            }
        }

        return false;
    }

    public boolean comprobarColum() {

        int[] fichas = new int[3];

        for (int i = 0; i < casillas[0].length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                fichas[j] = casillas[j][i];
            }
            if (comprobarFichas(fichas)) {
                return true;
            }
        }

        return false;
    }

    public boolean comprobarDiag() {
        int[] fichas = new int[3];

        for (int i = 0; i < casillas.length; i++) {
            fichas[i] = casillas[i][i];
        }
        if (comprobarFichas(fichas)) {
            return true;
        }

        for (int i = 2, j = 0; j < casillas.length; i--, j++) {
            fichas[j] = casillas[i][j];
        }
        return comprobarFichas(fichas);
    }

    public boolean comprobarLleno() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; i < casillas.length; j++) {
                if (casillas[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validarMovimiento(Movimiento movimiento) {
        int row = movimiento.getRow();
        int col = movimiento.getCol();
        if (col < 3 && col >= 0) {
            if (row < 3 && row >= 0) {
                return true;
            }
        }
        return false;
    }

    public boolean validarCasillaVacia(int row, int col) {
        if (casillas[row][col] == 0) {
            return true;
        } else {
            return false;
        }
    }

}
