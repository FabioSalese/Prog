import java.util.List;

public interface StrategiaPropostaPiatti {
    List<Prodotto> propostaPiattiAlternativi(Menu menu, Prodotto prodottoSelezionato);
}