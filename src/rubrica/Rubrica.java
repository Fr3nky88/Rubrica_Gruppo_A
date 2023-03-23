package rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 * Scrivi un programma Java che simuli una rubrica. L'utente deve essere in grado di aggiungere, cercare, visualizzare e cancellare contatti dalla rubrica.
 * <p>
 * BONUS: Ordina lista
 * Ricerca contatti per iniziale cognome
 */
public class Rubrica {

    public static void main(String[] args) {
        List<Contatto> rubrica = new ArrayList<>();
        Scanner input = new Scanner(System.in);


        boolean running = true;

        while (running) {
            System.out.println(" *******   **     ** ******   *******   **   ******      **             ********  *******   **     ** *******  *******    *******             **    \n" +
                    "/**////** /**    /**/*////** /**////** /**  **////**    ****           **//////**/**////** /**    /**/**////**/**////**  **/////**           ****   \n" +
                    "/**   /** /**    /**/*   /** /**   /** /** **    //    **//**         **      // /**   /** /**    /**/**   /**/**   /** **     //**         **//**  \n" +
                    "/*******  /**    /**/******  /*******  /**/**         **  //**       /**         /*******  /**    /**/******* /******* /**      /**        **  //** \n" +
                    "/**///**  /**    /**/*//// **/**///**  /**/**        **********      /**    *****/**///**  /**    /**/**////  /**////  /**      /**       **********\n" +
                    "/**  //** /**    /**/*    /**/**  //** /**//**    **/**//////**      //**  ////**/**  //** /**    /**/**      /**      //**     **       /**//////**\n" +
                    "/**   //**//******* /******* /**   //**/** //****** /**     /**       //******** /**   //**//******* /**      /**       //*******        /**     /**\n" +
                    "//     //  ///////  ///////  //     // //   //////  //      //         ////////  //     //  ///////  //       //         ///////         //      // ");
            System.out.println("Seleziona un'operazione:");
            System.out.println("1. Aggiungi contatto");
            System.out.println("2. Cerca contatto");
            System.out.println("3. Visualizza tutti i contatti");
            System.out.println("4. Cancella contatto");
            System.out.println("0. Esci");

            int scelta = input.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci il nome del contatto:");
                    String name = input.next();
                    System.out.println("Inserisci il cognome del contatto:");
                    String cognome = input.next();
                    System.out.println("Inserisci il numero di telefono del contatto:");
                    String numeroTelefono = input.next();
                    Contatto contatto = new Contatto(name, cognome, numeroTelefono, new Indirizzo(String via, int numeroCivico, String cap))
                    rubrica.add(contatto);
                    System.out.println("rubrica.Contatto aggiunto!");
                    break;
                case 2:
                    System.out.println("Inerisci il nome del contatto:");
                    String searchName = input.next();
                    System.out.println("Inerisci il cognome del contatto:");
                    String searchSurname = input.next();
                    for (Contatto c : rubrica) {
                        if (searchName.equals(c.getNome()) && searchSurname.equals(c.getCognome())) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 3:
                    System.out.println("/---------------------------------------------/");
                    System.out.println("/----------------------RUBRICA----------------/");
                    System.out.println("/---------------------------------------------/");
                    int i = 1;
                    for (Contatto c1 : rubrica) {
                        System.out.println(i + " - " + c1);
                        i++;
                    }
                    System.out.println("/---------------------------------------------/");
                    break;
                case 4:
                    System.out.println("Inserisci il nome del contatto:");
                    String deleteName = input.next();
                    System.out.println("Inserisci il cognome del contatto:");
                    String deleteSurname = input.next();
                    rubrica.removeIf(c -> deleteName.equals(c.getNome()) && deleteSurname.equals(c.getCognome()));
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Operazione non valida");
                    break;
            }
        }

    }
}

class Contatto {
    private String nome;
    private String cognome;
    private String telefono;

    private Indirizzo indirizzo;

    public Contatto(String nome, String cognome, String telefono, Indirizzo indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public String toString() {
        return nome + " " + cognome + ": " + telefono;
    }



}





