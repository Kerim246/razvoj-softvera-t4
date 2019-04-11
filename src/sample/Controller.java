package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class Controller {

    public TextArea Unos;
    public Button dodaj;
    public Button dodaj_racun;
    public ChoiceBox<Artikal> izbor;
    public Spinner spinner;
    public TextArea konacni_ispis;
    ArrayList<Artikal> lista = new ArrayList<Artikal>();

    public TextArea Ispis;
    private ObservableList<Artikal> lista_konacna = FXCollections.observableArrayList();

    private ArrayList<Artikal> result;

    private racun racun;


    public void dodajartikle(ActionEvent actionEvent) {

        String article = Unos.getText();
        String[] artiklii = article.split("\n");
        ArrayList<Artikal> lista_artikala = new ArrayList<>();

        for (String element: artiklii){
            lista_artikala.add(new Artikal(element));
        }
        lista = Artikal.izbaciDuplikate(lista_artikala);
        String rezultat = "";
        for(Artikal element : lista){
            rezultat = rezultat + element + "\n";
        }

        Ispis.setText(rezultat);

        racun = new racun();
        result = new ArrayList<>(lista_artikala);
        lista_konacna.addAll(result);

        izbor.setItems(lista_konacna);        // za choicebox

    }

    public void dodajracune(ActionEvent actionEvent) {
        racun.dodajStavku(izbor.getSelectionModel().getSelectedItem(),(Integer)spinner.getValue());
        konacni_ispis.setText(racun.toString());

    }
}





