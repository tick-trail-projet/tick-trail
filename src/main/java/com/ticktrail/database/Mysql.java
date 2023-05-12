package com.ticktrail.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * classe decrivant la gestion de la relation a la base de donnees
 */
public class Mysql {
    Connection con = null;
	
    /**
     * connection a la base de donnees et initialisation de la connection
     */
    public Mysql() {
        String url = "jdbc:mysql://localhost:3306/ticktrail?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Connection connect = DriverManager.getConnection(url, "root", "");
            this.con = connect;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Execution d une requete sans resultat
     * 
     * @param query requete
     * @return void
     */

    public void runQuery(String query) {
        try {
            Statement st = this.con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Execution d une requete avec resultat.
     * 
     * @param query requete
     * @return Map<String, Object> resultat de la requete sous forme de map
     *
     */
    public Map<String, Object> getSingleQuery(String query) {
        try {
            Statement st = this.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData metadata = rs.getMetaData();
            int columns = metadata.getColumnCount();
            Map<String, Object> result_in_map = new HashMap<>();
            while (rs.next()) {
                for (int i = 1; i <= columns; ++i) {
                    result_in_map.put(metadata.getColumnName(i), rs.getObject(i));
                }
            }
            return result_in_map;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

    /**
     * EExecution d une requete avec resultat.
     * 
     * @param query requete
     * @return resultat de la requete sous forme de resultset
     */
    public ResultSet getQuery(String query) {
        try {
            Statement st = this.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
