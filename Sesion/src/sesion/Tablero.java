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
    
    
    public void setPartida(Partida partida){
        this.partida=partida;
    }
    
    public Partida getPartida(){
        return partida;    
}

    public void mostrar() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print("| " + casillas[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void move(Movimiento movi) {
        if (validarMovimiento(movi)) {
            casillas[movi.getRow()][movi.getCol()]=impFicha(movi.getBlancas());
        }
    }

    public int impFicha(boolean ficha) {
        if (ficha) {
            return 1;
        } else {
            return -1;
        }
    }

    public int getCasilla(int row, int col) {
        return casillas[row][col];

    }

    public int[][] getCasillas() {
        return casillas;
    }

    public boolean comprobarGanador() {

        return (comprobarFilas() || comprobarColum() || comprobarDiag());

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
            for (int j = 0; j < casillas.length; j++) {
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
                return (validarCasillaVacia(row, col));
            }
        }
        System.out.println("Este movimiento no es válido.");
        return false;
    }

    public boolean validarCasillaVacia(int row, int col) {
        if (getCasilla(row, col) == 0) {
            return true;
        } else {
            System.out.println("En esta casilla ya hay una ficha.");
            return false;
        }
    }
}
