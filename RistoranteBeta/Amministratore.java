import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileNotFoundException;
import java.util.*;

public class Amministratore {
    private List<Prodotto> menu;
    private Map<Integer, Tavolo> tavoli;

    public Amministratore() {
        this.menu = new ArrayList<>();
        this.tavoli = new HashMap<>();
    }

    public void caricaMenuDaFile(String nomeFile) throws FileNotFoundException {
        Menu menuLoader = new Menu();
        menuLoader.caricaMenuDaFile(nomeFile);
        this.menu = menuLoader.getProdotti();
    }

    public void aggiungiProdottoAlMenu(Prodotto prodotto) {
        menu.add(prodotto);
    }

    public void modificaProdottoAlMenu(Prodotto prodotto) {
        for (int i = 0; i < menu.size(); i++) {
            Prodotto prod = menu.get(i);
            if (prod.getNome().equals(prodotto.getNome())) {
                menu.set(i, prodotto);
                break;
            }
        }
    }

    public void effettuaPagamento(Tavolo tavolo, String metodoPagamento) {
        if (tavoli.containsKey(tavolo.getNumero())) {
            tavolo.getOrdinazioni().clear();
            tavoli.remove(tavolo.getNumero());
            System.out.println("Pagamento effettuato per il tavolo " + tavolo.getNumero() + " con metodo di pagamento: " + metodoPagamento);
        } else {
            System.out.println("Il tavolo selezionato non esiste o non ha ordinazioni.");
        }
    }

    public void visualizzaProdottiPiùVenduti() {
        // Calcolare il numero di volte che ogni prodotto è stato ordinato
        Map<Prodotto, Integer> venditeProdotto = new HashMap<>();
        for (Tavolo tavolo : tavoli.values()) {
            List<Ordinazione> ordinazioni = tavolo.getOrdinazioni();
            for (Ordinazione ordinazione : ordinazioni) {
                for (Prodotto prodotto : ordinazione.getProdotti()) {
                    venditeProdotto.put(prodotto, venditeProdotto.getOrDefault(prodotto, 0) + 1);
                }
            }
        }

        // Ordinare i prodotti in base al numero di volte che sono stati ordinati
        List<Map.Entry<Prodotto, Integer>> prodottiVenduti = new ArrayList<>(venditeProdotto.entrySet());
        prodottiVenduti.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Stampa dei prodotti più venduti
        System.out.println("Prodotti più venduti:");

        int count = 0;
        for (Map.Entry<Prodotto, Integer> entry : prodottiVenduti) {
            Prodotto prodotto = entry.getKey();
            int vendite = entry.getValue();

            System.out.println(prodotto.getNome() + " - " + vendite + " vendite");

            count++;
            if (count == 5) {
                break; // Limita la stampa ai primi 5 prodotti più venduti
            }
        }
    }

    public void addTavolo(Tavolo tavolo) {
        tavoli.put(tavolo.getNumero(), tavolo);
    }

    public Tavolo getTavoloByNumero(int numeroTavolo) {
        return tavoli.get(numeroTavolo);
    }
}
