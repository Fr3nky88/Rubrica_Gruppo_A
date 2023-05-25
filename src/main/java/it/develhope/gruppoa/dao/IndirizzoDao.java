package it.develhope.gruppoa.dao;

import it.develhope.gruppoa.models.Indirizzo;

import java.sql.Connection;
import java.util.List;

public class IndirizzoDao implements IIndirizzoDao{
    private Connection connection;

    public IndirizzoDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Indirizzo> getAllIndirizzi() {
        return null;
    }

    @Override
    public Indirizzo getIndirizzo(Integer id) {
        return null;
    }

    @Override
    public void salvaIndirizzo(Indirizzo i) {

    }

    @Override
    public void deleteIndirizzo(Integer id) {

    }
}
