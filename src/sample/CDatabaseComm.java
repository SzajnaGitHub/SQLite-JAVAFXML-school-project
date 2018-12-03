package sample;

import javafx.stage.Stage;
import sun.management.jmxremote.ConnectorBootstrap;

import javax.swing.plaf.nimbus.State;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CDatabaseComm {
    private static String dbpath;
    private String file = new File("").getAbsolutePath();

    public CDatabaseComm(String Name) {
        dbpath = "jdbc:sqlite:" + file + "\\" + Name;
        //Connection conn = Connect();
        CreateNewDB();
        CreateNewTable();
    }

    private static void CreateNewDB() {
        try (Connection conn = DriverManager.getConnection(dbpath)) {
            if (conn != null) {
                System.out.print("DB created successfully" + "\n");
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    private static Connection Connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbpath);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private static void CreateNewTable() {
        String sql1 = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "price real, \n "
                + "	capacity real\n"
                + ");";
        String sql2 = "CREATE TABLE IF NOT EXISTS balance (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	income real\n"
                + ");";
        try (Connection conn = DriverManager.getConnection(dbpath);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
            stmt.execute(sql2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void InsertProduct(String Name, double price, double capacity) {
        String sql = "INSERT INTO warehouses(name,price,capacity) VALUES(?,?,?)";

        try (Connection conn = Connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Name);
            pstmt.setDouble(2, price);
            pstmt.setDouble(3, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void InsertIncome(String Name, double income) {
        String sql = "INSERT INTO balance(name,income) VALUES(?,?)";

        try (Connection conn = Connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Name);
            pstmt.setDouble(2, income);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void ViewDB(String tabname) {
        String sql = "SElECT * FROM " + tabname;

        try (Connection conn = Connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (tabname == "warehouses")
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getString("price") + "\t" +
                            rs.getString("capacity"));
                }
            else
                while (rs.next()) {
                    System.out.println("\n" + rs.getInt("id") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getString("income"));
                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<String> getXsFromDB(String tabname, String column) {
        String sql = "SELECT " + column + " FROM " + tabname;
        List X = new ArrayList<>();
        try (Connection conn = Connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                X.add(rs.getString(column));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return X;
    }
    public static List<Double> getYsFromDB(String tabname, String column) {
        String sql = "SELECT " + column + " FROM " + tabname;
        List X = new ArrayList<>();
        try (Connection conn = Connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                X.add(rs.getDouble(column));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return X;
    }

    public static void UpdateDB(String tabname, int id, String name, double income) {
        String sql = "UPDATE " + tabname + " SET name =? ,"
                + "income = ?"
                + "WHERE id = ?";

        try (Connection conn = Connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, income);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public static void Delete(int id) {
        String sql = "DELETE FROM warehouses WHERE id =?";
        try (Connection conn = Connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Update(int id, String name, double price, double capacity) {
        String sql = "update warehouses set name =?,"
                + "price = ?,"
                + "capacity = ?"
                + "where id =?";
        try (Connection conn = Connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setDouble(3, capacity);
            pstmt.setInt(4, id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
