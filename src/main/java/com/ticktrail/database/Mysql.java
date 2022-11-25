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

import com.mysql.cj.protocol.Resultset;

public class Mysql {
    Connection con = null;

    /**
     * Connection to the mysql database and initialize the con variable
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
     * Execute a query without return.
     * 
     * @param String query
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
     * Execute a query with return.
     * 
     * @param String query
     * @return Map<String, Object>
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
     * Execute a query with a return.
     * 
     * @param String query
     * @return the query result in a map
     *
     */
    public Map<String, Object> getQuery(String query) {
        try {
            Statement st = this.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData metadata = rs.getMetaData();
            int columns = metadata.getColumnCount();
            Map<String, Object> result_in_map = new HashMap<>();
            while (rs.next()) {
                for (int i = 1; i <= columns; ++i) {
                    result_in_map.put(metadata.getColumnName(i), rs.getObject(i));
                    System.out.println(metadata.getColumnName(i) + " " + rs.getObject(i));
                }
            }
            return result_in_map;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

    public static void main(String[] args) throws SQLException {
        Mysql test = new Mysql();
        // Map<String, Object> test_query = test.getQuery("SELECT * FROM user WHERE id =
        // \"717729969395990548\"");
        // System.out.println(test_query.get("alt"));
        System.out.println(test.getSingleQuery("SELECT * FROM users WHERE id = \"879139649497477140\""));
    }
}
