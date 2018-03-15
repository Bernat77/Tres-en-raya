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
public class Ranking {
    private int partidasJugadas;
    private int ganadas;
    private int empates;
    
    Ranking(){
       partidasJugadas=0;
       ganadas=0;
       empates=0;
    }
    
    public void mostrar(){
        System.out.print("************************************");
        System.out.print("*                                  *");
        System.out.print("*          *[RANKING]*             *");
        System.out.print("*Partidas jugadas: "+partidasJugadas+"                *");
        System.out.print("*Partidas ganadas:*"+ganadas+"      *");
        System.out.print("*Partidas empatadas: "+empates+"              *");
        System.out.print("************************************");

    }
    
    
    
    
    
}
