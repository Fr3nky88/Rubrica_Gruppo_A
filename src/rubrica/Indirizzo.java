package rubrica;

public class Indirizzo {
    private String via;
    private int numeroCivico;
    private String cap;

    Indirizzo (String via, int numeroCivico, String cap) {
        this.via = via;
        this.numeroCivico = numeroCivico;
        this.cap = cap;

    }
    String getVia () {
        return this.via;
    }

    int getNumeroCivico () {
        return this.numeroCivico;
    }

    String getCap () {
        return this.cap;
    }


}
