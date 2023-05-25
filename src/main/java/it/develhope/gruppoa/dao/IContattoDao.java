package it.develhope.gruppoa.dao;

import it.develhope.gruppoa.models.Contatto;

import java.util.List;

public interface IContattoDao {

    public List<Contatto> getAllContatti();

    public Contatto getContatto(Integer id);

    public void salvaContatto(Contatto c);

    public void deleteContatto(Integer id);
}
