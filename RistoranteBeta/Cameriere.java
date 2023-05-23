import java.util.ArrayList;
import java.util.List;

public class Cameriere implements Observer {
    private List<Tavolo> tavoli;
    private Menu menu;

    public Cameriere(Menu menu, List<Tavolo> tavoli) {
        this.tavoli = tavoli;
        this.menu = menu;
    }

    public void update(Tavolo tavolo) {
        List<Ordinazione> ordinazioni = tavolo.getOrdinazioni();
        System.out.println("Cameriere - Aggiornamento tavolo " + tavolo.getNumero() + ":");
        for (Ordinazione ordinazione : ordinazioni) {
            List<Prodotto> prodotti = ordinazione.getProdotti();
            for (Prodotto prodotto : prodotti) {
                System.out.println("- " + prodotto.getNome() + " - " + ordinazione.getQuantita());
            }
        }
        System.out.println();
    }
    
    public void prendiOrdinazione(Tavolo tavolo) {
        // Implementazione per prendere l'ordinazione da un tavolo
        // Utilizzando il design pattern Command
        ComandoPrendiOrdinazione comando = new ComandoPrendiOrdinazione(tavolo);
        comando.esegui();
    }

    public void annullaUltimaOrdinazione(Tavolo tavolo) {
        // Implementazione per annullare l'ultima ordinazione da un tavolo
        // Utilizzando il design pattern Command
        ComandoAnnullaUltimaOrdinazione comando = new ComandoAnnullaUltimaOrdinazione(tavolo);
        comando.esegui();
    }

    public void proponiPiattiAlternativi(Tavolo tavolo, Prodotto prodotto) {
        // Implementazione per proporre piatti alternativi in base al prodotto selezionato
        // Utilizzando il design pattern Strategy
        StrategiaPropostaPiatti strategia = StrategiaPropostaPiattiFactory.creaStrategia();
        List<Prodotto> piattiAlternativi = strategia.propostaPiattiAlternativi(menu, prodotto);
        // Eseguire le azioni necessarie per proporre i piatti alternativi al tavolo
    }

    public void addTavolo(Tavolo tavolo) {
        tavoli.add(tavolo);
        tavolo.registerObserver(this); // Aggiunge il cameriere come observer del tavolo
    }

    public void removeTavolo(Tavolo tavolo) {
        tavoli.remove(tavolo);
        tavolo.removeObserver(this); // Rimuove il cameriere come observer del tavolo
    }
}
