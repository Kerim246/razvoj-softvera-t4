package sample;

import java.util.ArrayList;

public class Artikal {
    private String sifra;
    private String naziv;
    private double cijena;

    @Override
    public String toString() {
        return "Artikal{"
                + sifra + ','
                + naziv + ','
                + cijena +
                '}';
    }

    public Artikal() {
    }


    public String getNaziv() {

        return naziv;
    }

    public String getSifra() {
        return sifra;
    }

    public double getCijena() {
        return cijena;
    }

    public void setNaziv(String naziv) {
        if(naziv.isEmpty()){
            throw new IllegalArgumentException("Naziv je prazan! ");
        }
        this.naziv = naziv;
    }

    public void setCijena(double Cijena) {
        if (cijena <= 0 ) {
            throw new IllegalArgumentException("Cijena je manja od 0!");
        }
        this.cijena = cijena;
    }

    public void setSifra(String cijena) {
        if (sifra.isEmpty()) {
            throw new IllegalArgumentException("Sifra je prazna !");
        }
        this.sifra = cijena;
    }


    public Artikal(String recenica){
        String [] c = recenica.split(",");
        sifra = c[0];
        naziv = c[1];
        cijena = Double.parseDouble(c[2]);

    }

    public boolean equals(Object o){
        Artikal artikal = (Artikal)o;

        if(!naziv.equals(artikal.getNaziv())) return false;

        if(!sifra.equals(artikal.getSifra())) return false;
        
        if(cijena != artikal.cijena) return false;

        return true;

    }

    public static ArrayList<Artikal> izbaciDuplikate(ArrayList<Artikal> artikli){

        for ( int i=0 ; i<artikli.size() ; i++){
            for(int j=i+1 ; j<artikli.size() ; j++){
                if(artikli.get(i).equals(artikli.get(j)))
                artikli.remove(j);
            }


        }
        return artikli;
    }


}
