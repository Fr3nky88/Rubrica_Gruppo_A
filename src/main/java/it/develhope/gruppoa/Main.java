package it.develhope.gruppoa;

import it.develhope.gruppoa.rubrica.RubricaAbstract;
import it.develhope.gruppoa.rubrica.RubricaDatabase;
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
        RubricaAbstract rubrica = null;
        try {
//            rubrica = new RubricaFile("rubrica.txt");
            rubrica = new RubricaDatabase();
            rubrica.init();
            rubrica.start();
        } catch (IOException e) {
            System.out.println("C'è stato un errore, impossibile scrivere sul disco, stronzo!");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception exception) {
            System.out.println("C'è stato un errore generico, stronzo!");
            exception.printStackTrace();
            System.exit(0);
        }



    }
}









