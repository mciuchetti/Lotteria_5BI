/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author monica
 */public class Lotteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
              
        System.out.println("Quanti numeri vuoi estrarre?");
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n;
        try {
            //lettura da tastiera
            n = Integer.parseInt(b.readLine());
            // Creazione del thread di estrazione
            Estrazione estrazione = new Estrazione(n);
            estrazione.start();

            // Creazione di 4 giocatori
            Giocatore g1 = new Giocatore(1, estrazione);
            Giocatore g2 = new Giocatore(2, estrazione);
            Giocatore g3 = new Giocatore(3, estrazione);
            Giocatore g4 = new Giocatore(4, estrazione);
            
            // Avvio dei thread dei giocatori
            g1.start();
            g2.start();
            g3.start();
            g4.start();

            // Attesa che i giocatori e l'estrazione terminino
            try {
                g1.join();
                g2.join();
                g3.join();
                g4.join();
                estrazione.join();
            } catch (InterruptedException e) {
                System.out.println("Errore nell'attesa della fine dei thread: " + e.getMessage());
            }

            } catch (IOException ex) {
                Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Errore nell'inserimento dei numeri da estrarre!");
            }
        System.out.println("L'estrazione è terminata.");
    }
}
   