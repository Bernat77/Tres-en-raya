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

    private boolean turno;
    private Jugador[] jugadores;
    private Sesion sesion;
    private Tablero tablero;

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

    public Jugador getJugador(int i) {
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

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public void crearTablero() {
        Tablero tablero = new Tablero();
        tablero.setPartida(this);
        setTablero(tablero);
    }

    public void jugar() {
        crearTablero();
        boolean ganado = false;
        while (!ganado) {
            if (turno) {
                System.out.println("--Le toca a " + getJugador(0).getNombre() + ".--");
                Scanner num = new Scanner(System.in);
                System.out.println("Introduce la fila: ");
                int row = num.nextInt() - 1;
                System.out.println("Introduce la columna: ");
                int col = num.nextInt() - 1;
                System.out.println();
                if (tablero.validarMovimiento(getJugador(0).movimiento(row, col))) {
                    tablero.move(getJugador(0).movimiento(row, col));
                } else {
                    ganado = true;
                    this.sesion.getRanking().upgPartidasJugadas();
                    System.out.println("Has perdido...");
                    break;
                }
            } else if (getJugador(1) instanceof IA0) {
                System.out.println("Movimiento de la I.A.\n");
                tablero.move(((IA0) getJugador(1)).movimiento(tablero));
            }
            tablero.mostrar();

            if (tablero.comprobarLleno()) {
                ganado = true;
                if (tablero.comprobarGanador()) {
                    if (turno == true) {
                        this.sesion.getRanking().upgGanadas();
                        this.sesion.getRanking().upgPartidasJugadas();
                        System.out.println("¡¡Ha ganado " + getJugador(0).getNombre() + "!!");
                        break;
                    } else {
                        this.sesion.getRanking().upgPartidasJugadas();
                        System.out.println("Has perdido...");
                        break;
                    }
                } else {
                    System.out.println("¡Empate!");
                    this.sesion.getRanking().upgPartidasJugadas();
                    this.sesion.getRanking().upgEmpates();
                    break;
                }
            }

            if (tablero.comprobarGanador()) {
                if (turno == true) {
                    this.sesion.getRanking().upgGanadas();
                    this.sesion.getRanking().upgPartidasJugadas();
                    System.out.println("¡¡Ha ganado " + getJugador(0).getNombre() + "!!");
                } else {
                    this.sesion.getRanking().upgPartidasJugadas();
                    System.out.println("Has perdido...");
                }
                ganado = true;
            }
            turno = !turno;
        }
    }

}
