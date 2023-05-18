package it.develhope.gruppoa.rubrica;

import it.develhope.gruppoa.models.Contatto;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RubricaDatabase extends RubricaAbstract {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/rubrica_a?user=root&password=root";

    public RubricaDatabase() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        super();
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    }

    @Override
    public void init() throws Exception {
        super.isInit = true;
        rubrica = readContatti();
    }

    @Override
    public List<Contatto> readContatti() throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Contatto> res = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Contatto");

            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...

            if (stmt.execute("SELECT * FROM Contatto")) {
                rs = stmt.getResultSet();

            }

            while (rs.next()) {
                Contatto c = new Contatto();
                c.setId(BigInteger.valueOf(rs.getInt("id")));
                c.setNome(rs.getString("nome"));
                c.setCognome(rs.getString("cognome"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
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
            if (conn != null) {
                try {
                    closeConnection(conn);
                } catch (SQLException sqlEx) { } // ignore

                conn = null;
            }
        }
        return res;
    }

    @Override
    public void saveContatto(Contatto c) throws Exception {

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_STRING);
    }

    private void closeConnection(Connection c) throws SQLException {
        c.close();
    }

}
