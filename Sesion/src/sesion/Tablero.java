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

}
