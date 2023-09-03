package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:zoo")) {
            getIdAndName(conn);
        }
    }

    public static void getIdAndName(Connection conn) throws SQLException {
        var sql = "SELECT id, name FROM exhibits";
        var idToNameMap = new HashMap<Integer, String>();
        try (var ps = conn.prepareStatement(sql)) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                idToNameMap.put(id, name);
            }
            System.out.println(idToNameMap);
        }
    }

    public static void register(Connection conn, int key, int type, String name) throws SQLException {
        var sql = "INSERT INTO names VALUES(?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, key);
            ps.setInt(2, type);
            ps.setString(3, name);
            ps.executeUpdate();
        }
    }

    private static void preparedStatementsWithoutVars(Connection conn) throws SQLException {
        System.out.println(conn);
        var insertSql = "INSERT INTO exhibits VALUES(10, 'Deer', 3)";
        var updateSql = "UPDATE exhibits SET name = '' WHERE name = 'None'";
        var deleteSql = "DELETE FROM exhibits WHERE id = 10";
        var selectSql = "SELECT * FROM names";
        executeUpdateSql(conn, insertSql);
        executeUpdateSql(conn, updateSql);
        executeUpdateSql(conn, deleteSql);
        executeQuerySql(conn, selectSql);
    }

    private static void executeQuerySql(Connection conn, String sql) throws SQLException {
        try (var ps = conn.prepareStatement(sql)) {
            ResultSet result = ps.executeQuery();
        }
    }

    private static void executeUpdateSql(Connection conn, String sql) throws SQLException {
        try (var ps = conn.prepareStatement(sql)) {
            int result = ps.executeUpdate();
            System.out.println(result);
        }
    }
}