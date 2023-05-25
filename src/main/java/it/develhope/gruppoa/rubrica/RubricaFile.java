package it.develhope.gruppoa.rubrica;

import it.develhope.gruppoa.enums.Province;
import it.develhope.gruppoa.models.Contatto;
import it.develhope.gruppoa.models.Indirizzo;
import it.develhope.gruppoa.rubrica.RubricaAbstract;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RubricaFile extends RubricaAbstract {
    private static final Path CARTELLA = Path.of(System.getProperty("user.home"), "rubrica");
    private Path fileRubrica;

    public RubricaFile(String nomeFile) throws IOException {
        this.fileRubrica = Path.of(CARTELLA.toString(), nomeFile);
        this.rubrica = new ArrayList<>();
        this.input = new Scanner(System.in).useDelimiter("\n");

        //TODO scrivere nuova linea contatto nel file creato

    }

    public void createFile() throws IOException {
        try{
            Files.createDirectory(CARTELLA);
            Files.createFile(fileRubrica);
        }
        catch (FileAlreadyExistsException exception)
        {
            System.out.println("il file esiste già");
        }

    }

    public List<Contatto> readContatti() throws IOException {
        List<Contatto> res = new ArrayList<>();
        List<String>linee = Files.readAllLines(fileRubrica);
        for(String linea : linee) {
            String[] campiContatto = linea.split(",");
            Indirizzo i = new Indirizzo();
            i.setVia(campiContatto[3]);
            i.setNumeroCivico(campiContatto[4]);
            i.setCap(campiContatto[5]);
            i.setCitta(campiContatto[6]);
            i.setProvincia(Province.valueOf(campiContatto[7]));
            Contatto c = new Contatto(campiContatto[0], campiContatto[1], campiContatto[2],null, i);
            res.add(c);

        }

        return res;
    }

    @Override
    public void saveContatto(Contatto c) throws Exception {
        //TODO: Sviluppare il salva contatto sul file
    }

    @Override
    public void init() throws IOException {
        super.isInit = true;
        createFile();
        rubrica = readContatti();
    }

    @Override
    public void close() throws Exception {

    }
}
