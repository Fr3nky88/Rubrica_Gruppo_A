package it.develhope.gruppoa.rubrica;

import it.develhope.gruppoa.RubricaInitExpetion;
import it.develhope.gruppoa.enums.Province;
import it.develhope.gruppoa.models.Contatto;
import it.develhope.gruppoa.models.Indirizzo;
import it.develhope.gruppoa.rubrica.IRubrica;

import java.util.List;
import java.util.Scanner;

public abstract class RubricaAbstract implements IRubrica {
    protected List<Contatto> rubrica;
    protected Scanner input;

    boolean isInit;

    public void start() throws RubricaInitExpetion {

        if (!isInit) {
            throw new RubricaInitExpetion();
        }

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
                    do
                    {
                        try {
                            indirizzo.setProvincia(Province.valueOf(input.next().toUpperCase()));
                        }  catch (IllegalArgumentException exception) {
                            System.out.println("La provincia che hai inserito non è valida, riprova, puoi scegliere fra queste province");
                            for(Province provincia : Province.values()) {
                                System.out.println(provincia);
                            }
                        }
                    } while (indirizzo.getProvincia() == null);

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
