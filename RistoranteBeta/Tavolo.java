import java.util.ArrayList;
import java.util.List;

public class Tavolo implements Subject {
    private int numero;
    private List<Observer> observers;
    private List<Ordinazione> ordinazioni;

    public Tavolo(int numero) {
        this.numero = numero;
        this.observers = new ArrayList<>();
        this.ordinazioni = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void prendiOrdinazione(Ordinazione ordinazione) {
        ordinazioni.add(ordinazione);
        notifyObservers();
    }

    public void annullaUltimaOrdinazione() {
        if (!ordinazioni.isEmpty()) {
            ordinazioni.remove(ordinazioni.size() - 1);
            notifyObservers();
        }
    }

    public List<Ordinazione> getOrdinazioni() {
        return ordinazioni;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

}
