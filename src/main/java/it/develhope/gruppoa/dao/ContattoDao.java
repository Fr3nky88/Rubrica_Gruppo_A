package it.develhope.gruppoa.dao;

import it.develhope.gruppoa.enums.Province;
import it.develhope.gruppoa.models.Contatto;
import it.develhope.gruppoa.models.Indirizzo;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContattoDao implements IContattoDao{

    private Connection connection;

    public ContattoDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Contatto> getAllContatti() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Contatto> res = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            String sql = "SELECT c.id, c.nome, c.cognome, c.telefono, c.email, i.id as id_indirizzo, i.via, i.numero_civico, i.cap, i.citta, i.provincia " +
                    "FROM Contatto c " +
                    "JOIN Indirizzo i ON i.id = c.indirizzo";
            rs = stmt.executeQuery(sql);

            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...

            if (stmt.execute(sql)) {
                rs = stmt.getResultSet();
            }

            while (rs.next()) {
                Contatto c = new Contatto();
                c.setId(BigInteger.valueOf(rs.getInt(1)));
                c.setNome(rs.getString("nome"));
                c.setCognome(rs.getString("cognome"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                Indirizzo i = new Indirizzo();
                i.setId(BigInteger.valueOf(rs.getInt(6)));
                i.setVia(rs.getString("via"));
                i.setNumeroCivico(rs.getString("numero_civico"));
                i.setCap(rs.getString("cap"));
                i.setCitta(rs.getString("citta"));
                i.setProvincia(Province.valueOf(rs.getString("provincia")));
                c.setIndirizzo(i);
                res.add(c);
            }

            // Now do something with the ResultSet ....
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
        return res;
    }

    @Override
    public Contatto getContatto(Integer id) {
        return null;
    }

    @Override
    public void salvaContatto(Contatto c) {

    }

    @Override
    public void deleteContatto(Integer id) {

    }
}
