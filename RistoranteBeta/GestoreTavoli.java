import java.util.List;

public class GestoreTavoli {
    public static Tavolo getTavoloByNumero(List<Tavolo> tavoli, int numeroTavolo) {
        for (Tavolo tavolo : tavoli) {
            if (tavolo.getNumero() == numeroTavolo) {
                return tavolo;
            }
        }
        return null;
    }
}