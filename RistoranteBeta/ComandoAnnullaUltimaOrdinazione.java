public class ComandoAnnullaUltimaOrdinazione implements Comando {
    private Tavolo tavolo;
    private Ordinazione ultimaOrdinazione;

    public ComandoAnnullaUltimaOrdinazione(Tavolo tavolo) {
        this.tavolo = tavolo;
        this.ultimaOrdinazione = null;
    }

    public void esegui() {
        if (!tavolo.getOrdinazioni().isEmpty()) {
            ultimaOrdinazione = tavolo.getOrdinazioni().get(tavolo.getOrdinazioni().size() - 1);
            tavolo.annullaUltimaOrdinazione();
        }
    }

    public void annulla() {
        if (ultimaOrdinazione != null) {
            tavolo.prendiOrdinazione(ultimaOrdinazione);
            ultimaOrdinazione = null;
        }
    }
}