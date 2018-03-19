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
public class Sesion {

    private Ranking ranking;
    private ArrayList<Partida> partidas;
    private ArrayList<Jugador> jugadores;

    Sesion() {
        partidas = new ArrayList<Partida>();
        jugadores = new ArrayList<Jugador>();
    }

    public static void main(String[] args) {
        inicio();
    }

    public void ventMenu() {

        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("************************************");
    }

    public static void inicio() {
        Sesion sesion = new Sesion();
        sesion.crearRanking();
        sesion.menu();
    }

    public void menu() {

        ventMenu();
        Scanner num = new Scanner(System.in);
        boolean menu = false;
        int val;
        do {
            val = num.nextInt();
            if (val != 1 && val != 2 && val != 3) {
                System.out.println("Escribe un número válido para las opciones");
            } else {
                menu = true;
                switch (val) {
                    case 1:
                        empezar();
                        break;
                    case 2:
                        mostrarRanking();
                        break;
                    case 3:
                        break;
                }
            }
        } while (!menu);

    }

    public Jugador crearHumano(String nombre) {
        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setSesion(this);
        jugadores.add(jugador);
        return jugador;
    }

    public IA0 crearIA() {
        IA0 ia = new IA0();
        ia.setSesion(this);
        return ia;
    }

    public Partida crearPartida(Jugador jugador1, Jugador jugador2) {
        Partida partida = new Partida(jugador1, jugador2);
        jugador1.setPartida(partida);
        jugador2.setPartida(partida);
        partida.setSesion(this);
        partidas.add(partida);
        partida.setTurno(sorteoTurno());
        return partida;
    }

    public void crearRanking() {
        Ranking ranking = new Ranking();
        this.ranking = ranking;
        ranking.setSesion(this);
    }

    public void mostrarRanking() {
        ranking.mostrar();
    }

    public boolean sorteoTurno() {
        return (Math.random() < 0.5);
    }

    public void empezar() {

        Scanner nom = new Scanner(System.in);
        System.out.println("Introduce tu nombre:");
        Partida partida = crearPartida(crearHumano(nom.next()), crearIA());
        partida.jugar();
        System.out.println("La partida ha acabado.");
        menuVolver();

    }

    public void menuVolver() {

        System.out.println("Introduce una opción:");
        System.out.println("1. Volver al menú");
        System.out.println("2. Salir del juego");
        Scanner num = new Scanner(System.in);
        boolean menu = false;
        int val;
        do {
            val = num.nextInt();
            if (val != 1 && val != 2) {
                System.out.println("Escribe un número válido para las opciones");
            } else {
                menu = true;
                switch (val) {
                    case 1:
                        menu();
                        break;
                    case 2:
                        break;
                }
            }
        } while (!menu);

    }

}
