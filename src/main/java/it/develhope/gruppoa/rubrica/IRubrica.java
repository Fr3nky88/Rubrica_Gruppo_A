package it.develhope.gruppoa.rubrica;

import it.develhope.gruppoa.models.Contatto;

import java.util.List;

public interface IRubrica {

    public void init() throws Exception;

    public List<Contatto> readContatti() throws Exception;

    public void saveContatto(Contatto c) throws Exception;
}
