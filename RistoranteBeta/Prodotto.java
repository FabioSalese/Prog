class Prodotto {
    private String nome;
    private double prezzo;
    private String categoria;

    public Prodotto(String nome, double prezzo, String categoria) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getCategoria() {
        return categoria;
    }
}