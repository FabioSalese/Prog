import java.util.ArrayList;
import java.util.List;

public class StrategiaPropostaPiattiCategoria implements StrategiaPropostaPiatti {
    private Prodotto prodottoSelezionato;
    
    public StrategiaPropostaPiattiCategoria() {
        // Costruttore senza argomenti
        // Puoi inizializzare prodottoSelezionato con un valore predefinito se necessario
    }

    public StrategiaPropostaPiattiCategoria(Prodotto prodottoSelezionato) {
        this.prodottoSelezionato = prodottoSelezionato;
    }
    public List<Prodotto> propostaPiattiAlternativi(Menu menu, Prodotto prodottoSelezionato) {
        // Implementazione per proporre piatti alternativi in base al prodotto selezionato
        List<Prodotto> piattiAlternativi = new ArrayList<>();
        List<Prodotto> piatti = menu.getProdotti();

        for (Prodotto piatto : piatti) {
            if (piatto.getCategoria().equals(prodottoSelezionato.getCategoria()) && !piatto.equals(prodottoSelezionato)) {
                piattiAlternativi.add(piatto);
            }
        }

        return piattiAlternativi;
    }
}