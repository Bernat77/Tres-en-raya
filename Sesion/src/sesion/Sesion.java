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

    private ArrayList<Jugador> jugadores;
    private ArrayList<Partida> partidas;
    private Ranking ranking;

    Sesion() {
        partidas = new ArrayList<Partida>();
        jugadores = new ArrayList<Jugador>();
    }

    public static void main(String[] args) {
        inicio();
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Jugador crearIA(int n) {

        IA0 ia;

        switch (n) {
            case 1:
                ia = new IA0();
                ia.setSesion(this);
                return ia;
            case 2:
                ia = new IA1();
                ia.setSesion(this);
                return ia;
            case 3:
                ia = new IA2();
                ia.setSesion(this);
                return ia;
            case 4:
                ia = new IA3();
                ia.setSesion(this);
                return ia;
            case 5:
                ia = new IA4();
                ia.setSesion(this);
                return ia;
        }

        return null;
    }

    public Jugador crearHumano(String nombre) {
        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setSesion(this);
        jugadores.add(jugador);
        return jugador;
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

    public void empezar() {
        System.out.println("***********Nueva partida************\n");
        Scanner scan = new Scanner(System.in);
        ventIA();
        int ia = -1;
        boolean selec = false;
        System.out.println("*Introduce una opción:             *");
        do {
            try {
                ia = scan.nextInt();

            } catch (InputMismatchException e) {
                scan.next();
                System.out.println("Por favor, introduce un número.");
                continue;
            }
            if (ia != 1 && ia != 2 && ia != 3 && ia != 4 && ia != 5) {
                System.out.println("Por favor, introduce un número válido.");
            } else {
                selec = true;
            }

        } while (!selec);

        System.out.println("Introduce tu nombre:");
        Partida partida = crearPartida(crearHumano(scan.next()), crearIA(ia));
        System.out.println("\n************--START--***************\n");
        partida.jugar();
        System.out.println("\nLa partida ha terminado.\n");
        menuVolver();

    }

    public static void inicio() {
        Sesion sesion = new Sesion();
        sesion.crearRanking();
        sesion.menu();
    }

    public void instrucciones() {
        System.out.println("************************************");
        System.out.println("*         |Instrucciones|          *");
        System.out.println("*                                  *");
        System.out.println("*                                  *");
        System.out.println("*Bienvenido al tres en raya.       *");
        System.out.println("*Una vez que comience el juego se  *");
        System.out.println("*decidirá aleatoriamente cuál de   *");
        System.out.println("*los participantes comenzará.      *");
        System.out.println("*Cuando le toque a usted, se le    *");
        System.out.println("*pedirá que introduzca la fila y la*");
        System.out.println("*columna que hagan referencia a la *");
        System.out.println("*casilla donde desea realizar su   *");
        System.out.println("*movimiento. Los rangos para ambos *");
        System.out.println("*van del 1 al 3, pues el tablero   *");
        System.out.println("*tiene 3 filas y 3 columnas. Usted *");
        System.out.println("*deberá introducir un movimiento   *");
        System.out.println("*válido o por el contrario, usted  *");
        System.out.println("*perderá la partida inmediatamente.*");
        System.out.println("*                                  *");
        System.out.println("*                    -Buena suerte.*");
        menuVolver();

    }

    public void menu() {

        ventMenu();
        Scanner num = new Scanner(System.in);
        System.out.println("*Introduce una opción:             *");
        boolean menu = false;
        int val;
        do {
            try {
                val = num.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un número.");
                num.next();
                continue;
            }
            if (val != 1 && val != 2 && val != 3 && val != 4) {
                System.out.println("/!/Introduce un número válido para las opciones/!/:");

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
                        instrucciones();
                    case 4:
                        System.out.println("*------------------------*");
                        System.out.println("|     ¡Vuelve pronto!    |");
                        System.out.println("*------------------------*");
                        System.out.println("                  ©2018 Bernat Salleras López");
                        break;
                }
            }
        } while (!menu);

    }

    public void mostrarRanking() {
        ranking.mostrar();
    }

    public boolean sorteoTurno() {
        return (Math.random() < 0.5);
    }

    public void menuVolver() {

        System.out.println("***********--Opciones--*************");
        System.out.println("*1. Volver al menú                 *");
        System.out.println("*2. Salir del juego                *");
        Scanner num = new Scanner(System.in);
        System.out.println("************************************");
        System.out.println("*Introduce una opción:             *");
        boolean menu = false;
        int val;
        do {
            try {
                val = num.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un número.");
                num.next();
                continue;
            }
            if (val != 1 && val != 2) {
                System.out.println("/!/Introduce un número válido para las opciones/!/");
            } else {
                menu = true;
                switch (val) {
                    case 1:
                        menu();
                        break;
                    case 2:
                        System.out.println("*------------------------*");
                        System.out.println("|     ¡Vuelve pronto!    |");
                        System.out.println("*------------------------*");
                        System.out.println("                  ©2018 Bernat Salleras López");
                        break;
                }
            }
        } while (!menu);

    }

    public void ventIA() {
        System.out.println("************************************");
        System.out.println("*    Selecciona la dificultad:     *");
        System.out.println("*                                  *");
        System.out.println("* 1.Babymode                       *");
        System.out.println("* 2.Fácil                          *");
        System.out.println("* 3.Normal                         *");
        System.out.println("* 4.Difícil                        *");
        System.out.println("* 5.Muy difícil                    *");
        System.out.println("************************************");
    }

    public void ventMenu() {

        System.out.println("************************************");
        System.out.println("*XOX     XOO     OOO    XXO     OXX*");
        System.out.println("*       *|||TRES EN RAYA|||*       *");
        System.out.println("*                                  *");
        System.out.println("**********--Opciones--**************");
        System.out.println("* 1. Nueva partida                 *");
        System.out.println("* 2. Ranking                       *");
        System.out.println("* 3. Instrucciones                 *");
        System.out.println("* 4. Salir                         *");
        System.out.println("************************************");
    }

}
