package sesion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bernat2
 */
public class IA4 extends IA3 {

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

    public void recalValorEst(Movimiento movi) {
        int x = movi.getRow();
        int y = movi.getCol();

        boolean c1 = false;
        boolean c2 = false;

        //Las esquinas de la izquierda del tablero
        if (y == 0 && x != 1) {

            for (int i = 1, j = 1; i < pesos.length; i++, j--) {
                if (x == 0) {
                    pesos[i][0]--;
                    if (!c1) {
                        for (int z = 1; z < pesos.length; z++) {
                            pesos[z][z]--;
                        }
                        c1 = true;
                    }
                } else if (x == 2) {
                    pesos[j][0]--;
                    if (!c2) {
                        for (int z = 1, k = 1; z < pesos.length; z++, k--) {
                            pesos[z][k]--;
                        }
                        c2 = true;
                    }
                }
                pesos[x][i]--;
            }
        } //Las esquinas de la derecha del tablero
        else if (y == 2 && x != 1) {

            for (int i = 1, j = 1; i < pesos.length; i++, j--) {
                if (x == 0) {
                    pesos[i][0]--;
                    if (!c2) {
                        for (int z = 1, k = 1; z < pesos.length; z++, k--) {
                            pesos[k][z]--;
                        }
                        c2 = true;
                    }
                    pesos[j][i]--;
                } else if (x == 2) {
                    pesos[j][0]--;
                    if (!c1) {
                        for (int z = 1; z > 0; z--) {
                            pesos[z][z]--;
                        }
                        c1 = true;
                    }
                }
                pesos[x][j]--;
            }
        }
        //puesto en una de las puntas de cruz verticales
        boolean c3 = false;
        boolean c4 = false;
        if (y == 1 && x != 1) {
            pesos[x][0]--;
            pesos[x][2]--;

            if (c3 == false) {
                for (int i = 1, j = 1; i < pesos.length; i++, j--) {
                    if (x == 0) {
                        pesos[i][y]--;
                    } else if (x == 2) {
                        pesos[j][y]--;
                    }
                }
                c3 = true;
            }
        } else if (y != 1 && x == 1) {
            pesos[0][y]--;
            pesos[2][y]--;

            if (c4 == false) {
                for (int i = 1, j = 1; i < pesos.length; i++, j--) {
                    if (y == 0) {
                        pesos[x][i]--;
                    } else if (y == 2) {
                        pesos[x][j]--;
                    }
                }
                c4 = true;
            }
        }

    }

}
