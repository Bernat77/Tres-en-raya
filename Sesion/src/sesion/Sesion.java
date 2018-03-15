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
    
    Sesion(){
        partidas=new ArrayList<Partida>();
        jugadores=new ArrayList<Jugador>();
    }

    public static void main(String[] args) {
        menu();
    }

    public static void ventMenu() {

        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("************************************");
    }

    public static void menu() {

        ventMenu();
        Scanner num = new Scanner(System.in);
        boolean menu = false;
        int val = num.nextInt();
        while (menu != true) {
            if (val != 1 && val != 2 && val != 3) {
                System.out.println("Escribe un número válido para las opciones");
            } else {
                menu = true;
                switch (val) {
                    case 1:
                        asdsad();
                        break;
                    case 2:
                        asdsad();
                        break;
                    case 3:
                        sadasd();
                        break;
                }
            }
            val = num.nextInt();
        }

    }
    
    public void crearHumano(String nombre){
        Jugador humano = new Jugador(nombre);
        jugadores.add(humano);
    }
    
    public void crearPartida(Jugador jugador1,Jugador jugador2){
        partidas.add(new Partida(jugador1,jugador2));
        
    }

    public static void mostrarRanking() {
        

    }

}
