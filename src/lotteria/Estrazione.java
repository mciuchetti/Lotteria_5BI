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
public class Estrazione extends Thread {
    private int[][] matriceNumeri;
    private int n;
    private int[] vincitori;
    private int numeroVincitori;
        
    public Estrazione(int n) {
        matriceNumeri = new int[n][n];
        Random rand = new Random();
        matriceNumeri = new int[5][5]; // Creazione di una matriceNumeri 5x5 di numeri casuali
        for (int i = 0; i < matriceNumeri.length; i++) {
            for (int j = 0; j < matriceNumeri[i].length; j++) {
                matriceNumeri[i][j] = rand.nextInt(100); // Numeri casuali tra 0 e 99
            }
        }

        // Inizializza l'array dei vincitori con -1 (nessun vincitore inizialmente)
        for (int i = 0; i < vincitori.length; i++) {
            vincitori[i] = -1;
        }
    }

    // Metodo per visualizzare la matriceNumeri
    public void stampaMatrice() {
        for (int[] riga : matriceNumeri) {
            for (int num : riga) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
    
    // Metodo per visualizzare i vincitori 
    public void stampaVincitori() {
        for (int i = 0; i < vincitori.length; i++) {
                System.out.print(vincitori[i] + "\t");
            }
            System.out.println();
        }

    // Metodo chiamato dai giocatori per verificare se il loro numero è nella matriceNumeri
    public void verifica(int numero, int idGiocatore) {
            // Ricerca del numero nella matriceNumeri
            boolean trovato = false;
            int i = 0;

            // Inizio ricerca con un ciclo while
            while (i < matriceNumeri.length && !trovato) {
                int j = 0;
                while (j < matriceNumeri[i].length && !trovato) {
                    if (matriceNumeri[i][j] == numero) {
                        trovato = true; // Indica che il numero è stato trovato
                        System.out.println("Giocatore " + idGiocatore + " ha trovato il numero " + numero + " nella posizione (" + i + "," + j + ")");

                        // Se ci sono meno di 3 vincitori, aggiungi il giocatore all'array vincitori
                        if (numeroVincitori < 3) {
                            vincitori[numeroVincitori] = idGiocatore;
                            numeroVincitori++;
                            System.out.println("Giocatore " + idGiocatore + " è tra i vincitori!");
                        } else {
                            System.out.println("Giocatore " + idGiocatore + " non è tra i vincitori!");
                        }
                    }
                    j++;
                }
                i++;
            }
            if (trovato == false)
                System.out.println("Giocatore " + idGiocatore + " non ha trovato il numero " + numero);
    }

    public void run() {
        System.out.println("Estrazione avviata! Ecco la matrice generata:");
        stampaMatrice();
        stampaVincitori();
        System.out.println("Fine estrazione");
    }
}


