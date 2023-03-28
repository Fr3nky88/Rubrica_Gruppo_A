package rubrica.models;

import java.util.ArrayList;
import java.util.List;

public class Indirizzo {

    private String via;
    private String numeroCivico;
    private String cap;
    private String citta;
    private String provincia;

    private static List<String> province = new ArrayList<>();

    public Indirizzo() {

        province = populateProvince();

    }

//    public Indirizzo (String via, int numeroCivico, String cap) {
//        this.via = via;
//        this.numeroCivico = numeroCivico;
//        this.cap = cap;
//
//    }

    private List<String> populateProvince() {
        List<String> province = new ArrayList<>();
        province.add("PA");
        province.add("MI");
        province.add("RM");
        return province;
    }


    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(String numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        if (province.contains(provincia)) {
            this.provincia = provincia;
        } else {
            System.out.println("Hai inserito una provincia non valida");
        }
    }

    @Override
    public String toString() {
        return "Indirizzo{" +
                "via='" + via + '\'' +
                ", numeroCivico='" + numeroCivico + '\'' +
                ", cap='" + cap + '\'' +
                ", citta='" + citta + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Indirizzo indirizzo = (Indirizzo) o;

        if (!via.equals(indirizzo.via)) return false;
        if (!numeroCivico.equals(indirizzo.numeroCivico)) return false;
        if (!cap.equals(indirizzo.cap)) return false;
        if (!citta.equals(indirizzo.citta)) return false;
        return provincia.equals(indirizzo.provincia);
    }
}
