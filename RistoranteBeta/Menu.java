import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Prodotto> prodotti;

    public Menu() {
        this.prodotti = new ArrayList<>();
    }

    public void caricaMenuDaFile(String nomeFile) throws FileNotFoundException {
        File file = new File(nomeFile);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String riga = scanner.nextLine();
            String[] elementi = riga.split(";");

            if (elementi.length == 3) {
                String nomeProdotto = elementi[0].trim();
                double prezzoProdotto = Double.parseDouble(elementi[1].trim());
                String categoriaProdotto = elementi[2].trim();

                Prodotto prodotto = new Prodotto(nomeProdotto, prezzoProdotto, categoriaProdotto);
                prodotti.add(prodotto);
            }
        }

        scanner.close();
    }

   

    public void aggiungiProdotto(Prodotto prodotto) {
        prodotti.add(prodotto);
    }

    public void modificaProdotto(Prodotto prodottoModificato) {
        for (int i = 0; i < prodotti.size(); i++) {
            Prodotto prodotto = prodotti.get(i);
            if (prodotto.getNome().equals(prodottoModificato.getNome())) {
                prodotti.set(i, prodottoModificato);
                break;
            }
        }
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }
}
