package rubrica;

import rubrica.models.Contatto;
import rubrica.models.Indirizzo;

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
        Scanner input = new Scanner(System.in).useDelimiter("\n");


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


                    Indirizzo indirizzo = new Indirizzo();


                    System.out.println("Inserisci la via:");
                    String via = input.next();
                    indirizzo.setVia(via);
                    System.out.println("Inserisci il numero civico");
                   indirizzo.setNumeroCivico(input.next());
                    System.out.println("Inserisci il cap");
                    indirizzo.setCap(input.next());
                    System.out.println("Inserisci la città");
                    indirizzo.setCitta(input.next());
                    System.out.println("Inserisci la provincia");
                    indirizzo.setProvincia(input.next());





                    Contatto contatto = new Contatto(name, cognome, numeroTelefono, indirizzo);
                    rubrica.add(contatto);
                    System.out.println("rubrica.models.Contatto aggiunto!");
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









