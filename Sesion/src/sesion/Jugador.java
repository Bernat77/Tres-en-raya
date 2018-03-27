/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import java.util.*;

/**
 *
 * @author dam1a14
 */
public class Jugador {

    private Partida partida;
    private Sesion sesion;
    private String nombre;

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Movimiento movimiento(int row, int col) {
        Movimiento jugada = new Movimiento();
        jugada.setRow(row);
        jugada.setCol(col);
        jugada.setJugador(this);
        if (this.getPartida().getJugador(0) == this) {
            jugada.setBlancas(true);
        } else {
            jugada.setBlancas(false);
        }
        return jugada;
    }
}
