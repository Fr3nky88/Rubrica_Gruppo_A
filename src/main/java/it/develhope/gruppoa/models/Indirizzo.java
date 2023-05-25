package it.develhope.gruppoa.models;

import it.develhope.gruppoa.enums.Province;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Indirizzo {

    private BigInteger id;

    private String via;
    private String numeroCivico;
    private String cap;
    private String citta;
    private Province provincia;

    public Indirizzo() {

    }

//    public Indirizzo (String via, int numeroCivico, String cap) {
//        this.via = via;
//        this.numeroCivico = numeroCivico;
//        this.cap = cap;
//
//    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public Province getProvincia() {
        return provincia;
    }

    public void setProvincia(Province provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return
                " " + via + '\'' +
                " " + numeroCivico + '\'' +
                " " + cap + '\'' +
                " " + citta + '\'' +
                " " + provincia + '\'';
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
