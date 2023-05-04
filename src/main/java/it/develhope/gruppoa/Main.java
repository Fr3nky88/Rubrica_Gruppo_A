package it.develhope.gruppoa;

import it.develhope.gruppoa.rubrica.RubricaFile;

import java.io.IOException;


/**
 * Scrivi un programma Java che simuli una rubrica. L'utente deve essere in grado di aggiungere, cercare, visualizzare e cancellare contatti dalla rubrica.
 * <p>
 * BONUS: Ordina lista
 * Ricerca contatti per iniziale cognome
 */
public class Main {

    public static void main(String[] args) {
        RubricaFile rubrica = null;
        try {
            rubrica = new RubricaFile("rubrica.txt");
            rubrica.init();
            rubrica.start();
        } catch (IOException e) {
            System.out.println("C'è stato un errore, impossibile scrivere sul disco, stronzo!");
            System.exit(0);
        } catch (Exception exception) {
            System.out.println("C'è stato un errore generico, stronzo!");
            System.exit(0);
        }



    }
}









