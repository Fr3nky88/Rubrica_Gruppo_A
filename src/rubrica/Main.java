package rubrica;

import rubrica.enums.Province;
import rubrica.models.Contatto;
import rubrica.models.Indirizzo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 * Scrivi un programma Java che simuli una rubrica. L'utente deve essere in grado di aggiungere, cercare, visualizzare e cancellare contatti dalla rubrica.
 * <p>
 * BONUS: Ordina lista
 * Ricerca contatti per iniziale cognome
 */
public class Main {

    public static void main(String[] args) {
        Rubrica rubrica = null;
        try {
            rubrica = new Rubrica("rubrica.txt");
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









