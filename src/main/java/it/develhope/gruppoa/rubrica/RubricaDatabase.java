package it.develhope.gruppoa.rubrica;

import it.develhope.gruppoa.dao.ContattoDao;
import it.develhope.gruppoa.dao.IndirizzoDao;
import it.develhope.gruppoa.models.Contatto;
import it.develhope.gruppoa.models.Indirizzo;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RubricaDatabase extends RubricaAbstract {

    private static final String CONNECTION_STRING = "jdbc:mysql://raspberrypi:3306/rubrica_a";

    private static final String USER = "root";

    private static final String PASSWORD = "Fr3nky88?";

    private Connection conn = null;

    private ContattoDao contattoDao;

    private IndirizzoDao indirizzoDao;

    public RubricaDatabase() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        super();
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        conn = getConnection();
        contattoDao = new ContattoDao(conn);
        indirizzoDao = new IndirizzoDao(conn);
    }

    @Override
    public void close() throws SQLException {
        closeConnection(conn);
    }

    @Override
    public void init() throws Exception {
        super.isInit = true;
        rubrica = readContatti();
    }

    @Override
    public List<Contatto> readContatti() throws Exception {
        return contattoDao.getAllContatti();
    }

    @Override
    public void saveContatto(Contatto c) throws Exception {

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
    }

    private void closeConnection(Connection c) throws SQLException {
        c.close();
    }

}
