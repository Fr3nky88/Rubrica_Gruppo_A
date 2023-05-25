package it.develhope.gruppoa.dao;

import it.develhope.gruppoa.models.Indirizzo;

import java.util.List;

public interface IIndirizzoDao {

    public List<Indirizzo> getAllIndirizzi();

    public Indirizzo getIndirizzo(Integer id);

    public void salvaIndirizzo(Indirizzo i);

    public void deleteIndirizzo(Integer id);
}
