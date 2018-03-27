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

    private int empates;
    private int ganadas;
    private int partidasJugadas;
    private Sesion sesion;

    Ranking() {
        partidasJugadas = 0;
        ganadas = 0;
        empates = 0;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public int getGanadas() {
        return ganadas;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public void mostrar() {

        System.out.println();
        System.out.println("************************************");
        System.out.println("*         !*[RANKING]*!            *");
        System.out.println("*                                  *");
        System.out.println("*Partidas jugadas:   " + partidasJugadas + "             *");
        System.out.println("*Partidas ganadas:   " + ganadas + "             *");
        System.out.println("*Partidas empatadas: " + empates + "             *");
        System.out.println("*Partidas perdidas:  " + (partidasJugadas - ganadas - empates) + "              *");
        this.sesion.menuVolver();

    }

    public void upgPartidasJugadas() {
        this.partidasJugadas++;
    }

    public void upgGanadas() {
        this.ganadas++;
    }

    public void upgEmpates() {
        this.empates++;
    }

}
