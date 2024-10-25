/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Random;

/**
 *
 * @author monica
 */
public class Giocatore extends Thread{
    private Estrazione estrazione;
    private int idGiocatore;

    public Giocatore(int idGiocatore, Estrazione estrazione) {
        this.idGiocatore = idGiocatore;
        this.estrazione = estrazione;
    }

    public void run() {
        Random rand = new Random();
        int numeroScelto = rand.nextInt(100); // Il giocatore sceglie un numero casuale tra 0 e 99
        System.out.println("Giocatore " + idGiocatore + " ha scelto il numero " + numeroScelto);
        estrazione.verifica(numeroScelto, idGiocatore);
    }
}
