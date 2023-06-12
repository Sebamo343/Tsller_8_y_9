package co.edu.sena.project2687351.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UseConnectionPool {
    private static Connection getConnection() throws SQLException {
        return ConnectionPool.getConnection();
    }

    public static void main(String[] args) throws SQLException {
        try (Connection conn = getConnection()) {
            // Consulta para la tabla "users_tbl"
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM myapp.users_tbl")) {
                while (rs.next()) {
                    System.out.print(rs.getString("user_firstname"));
                    System.out.print(" | ");
                    System.out.println(rs.getString("user_lastname"));
                    System.out.println("-------------");
                }
            }

            // Consulta para la tabla "categories"
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM myapp.categories")) {
                while (rs.next()) {
                    System.out.print(rs.getInt("category_id"));
                    System.out.print(" | ");
                    System.out.println(rs.getString("category_name"));
                    System.out.println("-------------");
                }
            }

            // Consulta para la tabla "products"
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM myapp.products")) {
                while (rs.next()) {
                    System.out.print(rs.getInt("product_id"));
                    System.out.print(" | ");
                    System.out.print(rs.getString("product_name"));
                    System.out.print(" | ");
                    System.out.println(rs.getBigDecimal("product_value"));
                    System.out.println("-------------");
                }
            }
        }
    }
}//Use ConecctionPool