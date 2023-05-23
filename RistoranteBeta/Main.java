import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        int ruolo;

        System.out.println("Benvenuto! Sei un cameriere o un amministratore?");
        System.out.println("Seleziona il tuo ruolo:");
        System.out.println("1. Cameriere");
        System.out.println("2. Amministratore");
        System.out.println("0. Esci");

        ruolo = scanner.nextInt();
        scanner.nextLine(); // Consuma il carattere di invio

        List<Tavolo> tavoli = new ArrayList<>(); // Creazione della lista di tavoli
        GestoreTavoli gestoreTavoli = new GestoreTavoli(); // Creazione dell'oggetto GestoreTavoli

        if (ruolo == 1) {
            Menu menu = new Menu();
           
            // Carica il menu da un file
            try {
                menu.caricaMenuDaFile("Menu.txt");
            } catch (FileNotFoundException e) {
                System.out.println("File del menu non trovato. Il programma verrà terminato.");
                return;
            }

            Cameriere cameriere = new Cameriere(menu, tavoli); // Passa l'oggetto GestoreTavoli e la lista di tavoli al cameriere

            cameriere.addTavolo(new Tavolo(1));
            cameriere.addTavolo(new Tavolo(2));
            cameriere.addTavolo(new Tavolo(3));

            int scelta;
            do {
                System.out.println("Cosa desideri fare?");
                System.out.println("1. Prendere un'ordinazione");
                System.out.println("2. Annullare un'ordinazione");
                System.out.println("0. Esci");

                scelta = scanner.nextInt();
                scanner.nextLine(); // Consuma il carattere di invio

                switch (scelta) {
                    case 1:
                        // Prendere un'ordinazione
                        System.out.println("Inserisci il numero del tavolo:");
                        int numeroTavolo = scanner.nextInt();
                        scanner.nextLine(); // Consuma il carattere di invio
                        Tavolo tavolo = GestoreTavoli.getTavoloByNumero(tavoli, numeroTavolo); // Utilizza il metodo getTavoloByNumero di GestoreTavoli
                        if (tavolo != null) {
                            cameriere.prendiOrdinazione(tavolo);
                        } else {
                            System.out.println("Il tavolo selezionato non esiste.");
                        }
                        break;
                    case 2:
                        // Annullare un'ordinazione
                        System.out.println("Inserisci il numero del tavolo:");
                        int numeroTavoloAnnullamento = scanner.nextInt();
                        scanner.nextLine(); // Consuma il carattere di invio

                        Tavolo tavoloAnnullamento = GestoreTavoli.getTavoloByNumero(tavoli, numeroTavoloAnnullamento); // Utilizza il metodo getTavoloByNumero di GestoreTavoli
                        if (tavoloAnnullamento != null) {
                            cameriere.annullaUltimaOrdinazione(tavoloAnnullamento);
                        } else {
                            System.out.println("Il tavolo selezionato non esiste.");
                        }
                        break;
                    case 0:
                        System.out.println("Arrivederci!");
                        break;
                    default:
                        System.out.println("Scelta non valida.");
                        break;
                }
            } while (scelta != 0);
        } else if (ruolo == 2) {
            Amministratore amministratore = new Amministratore();
            Menu menu = new Menu();

            // Carica il menu da un file
            try {
                menu.caricaMenuDaFile("menu.txt");
            } catch (FileNotFoundException e) {
                System.out.println("File del menu non trovato. Il programma verrà terminato.");
                return;
            }

            int scelta;
            do {
                System.out.println("Cosa desideri fare?");
                System.out.println("1. Aggiungere un prodotto al menu");
                System.out.println("2. Modificare un prodotto nel menu");
                System.out.println("3. Effettuare un pagamento");
                System.out.println("4. Visualizzare i prodotti più venduti");
                System.out.println("0. Esci");

                scelta = scanner.nextInt();
                scanner.nextLine(); // Consuma il carattere di invio

                switch (scelta) {
                    case 1:
                        // Aggiungere un prodotto al menu
                        System.out.println("Inserisci il nome del prodotto:");
                        String nomeProdotto = scanner.nextLine();

                        System.out.println("Inserisci il prezzo del prodotto:");
                        double prezzoProdotto = scanner.nextDouble();
                        scanner.nextLine(); // Consuma il carattere di invio

                        System.out.println("Inserisci la categoria del prodotto:");
                        String categoriaProdotto = scanner.nextLine();

                        Prodotto nuovoProdotto = new Prodotto(nomeProdotto, prezzoProdotto, categoriaProdotto);
                        menu.aggiungiProdotto(nuovoProdotto);
                        break;
                    case 2:
                        // Modificare un prodotto nel menu
                        System.out.println("Inserisci il nome del prodotto da modificare:");
                        String nomeProdottoModifica = scanner.nextLine();

                        System.out.println("Inserisci il nuovo prezzo del prodotto:");
                        double nuovoPrezzoProdotto = scanner.nextDouble();
                        scanner.nextLine(); // Consuma il carattere di invio

                        System.out.println("Inserisci la nuova categoria del prodotto:");
                        String nuovaCategoriaProdotto = scanner.nextLine();

                        Prodotto prodottoModificato = new Prodotto(nomeProdottoModifica, nuovoPrezzoProdotto, nuovaCategoriaProdotto);
                        menu.modificaProdotto(prodottoModificato);
                        break;
                    case 3:
                        // Effettuare un pagamento
                        System.out.println("Inserisci il numero del tavolo:");
                        int numeroTavoloPagamento = scanner.nextInt();
                        scanner.nextLine(); // Consuma il carattere di invio

                        System.out.println("Inserisci il metodo di pagamento:");
                        String metodoPagamento = scanner.nextLine();

                        Tavolo tavoloPagamento = GestoreTavoli.getTavoloByNumero(tavoli, numeroTavoloPagamento); // Utilizza il metodo getTavoloByNumero di GestoreTavoli
                        if (tavoloPagamento != null) {
                            amministratore.effettuaPagamento(tavoloPagamento, metodoPagamento);
                        } else {
                            System.out.println("Il tavolo selezionato non esiste.");
                        }
                        break;
                    case 4:
                        // Visualizzare i prodotti più venduti
                        amministratore.visualizzaProdottiPiùVenduti();
                        break;
                    case 0:
                        System.out.println("Arrivederci!");
                        break;
                    default:
                        System.out.println("Scelta non valida.");
                        break;
                }
            } while (scelta != 0);
        } else if (ruolo == 0) {
            System.out.println("Arrivederci!");
        } else {
            System.out.println("Scelta non valida. Il programma verrà terminato.");
        }
    }
}
