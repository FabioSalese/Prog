public class ComandoPrendiOrdinazione implements Comando {
    private Tavolo tavolo;
    private Ordinazione ultimaOrdinazione;

    public ComandoPrendiOrdinazione(Tavolo tavolo) {
        this.tavolo = tavolo;
        this.ultimaOrdinazione = null;
    }

    public void esegui() {
        // Crea una nuova ordinazione per il tavolo
        Ordinazione ordinazione = new Ordinazione(tavolo);
        tavolo.prendiOrdinazione(ordinazione);
        ultimaOrdinazione = ordinazione;
    }

    public void annulla() {
        if (ultimaOrdinazione != null) {
            tavolo.annullaUltimaOrdinazione();
            ultimaOrdinazione = null;
        }
    }
}