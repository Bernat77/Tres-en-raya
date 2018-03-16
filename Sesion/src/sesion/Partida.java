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
public class Partida {

    private Sesion sesion;
    private Jugador[] jugadores;
    private Tablero tablero;
    private static int jugadaActual;

    Partida(Jugador jugador1, Jugador jugador2) {
        jugadores = new Jugador[2];
        jugadores[0] = jugador1;
        jugadores[1] = jugador2;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }
    
    public Jugador getJugador(int i){
        return jugadores[i];
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public 
    
    
}
