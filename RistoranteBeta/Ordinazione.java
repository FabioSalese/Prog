import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ordinazione {
    private Tavolo tavolo;
    private List<Prodotto> prodotti;
    private List<Integer> quantita;

    public Ordinazione(Tavolo tavolo) {
        this.tavolo = tavolo;
        this.prodotti = new ArrayList<>();
        this.quantita = new ArrayList<>();
    }

    public Tavolo getTavolo() {
        return tavolo;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public List<Integer> getQuantita() {
        return quantita;
    }

    public void aggiungiProdotto(Prodotto prodotto, int quantita) {
        prodotti.add(prodotto);
        this.quantita.add(quantita);
    }

    public void rimuoviProdotto(Prodotto prodotto, int quantita) {
        int index = prodotti.indexOf(prodotto);
        if (index != -1) {
            int quantitaAttuale = this.quantita.get(index);
            int nuovaQuantita = quantitaAttuale - quantita;
            if (nuovaQuantita > 0) {
                this.quantita.set(index, nuovaQuantita);
            } else {
                this.prodotti.remove(index);
                this.quantita.remove(index);
            }
        }
    }
}
