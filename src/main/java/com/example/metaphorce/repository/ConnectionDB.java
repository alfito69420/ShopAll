package com.example.metaphorce.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 *Credenciales de la base de datos
 * SGDB: MySQL
 * DBNAME: maven
 * USERNAME: maven
 * PASSWORD: Sandra22Mane10Alfre99Gera22Braulio10
 */
public class ConnectionDB {
    private static final String URL_CONNECTION = "jdbc:mysql://localhost/maven?"
            + "user=maven&password=Sandra22Mane10Alfre99Gera22Braulio10";

    public Connection createConnection() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL_CONNECTION);
            System.out.println("Conexión a la base de datos exitosa.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            throw e;
        }
        return con;
    }

    public void closeConnection(final Connection con) throws SQLException {
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexión cerrada con éxito.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
                throw e;
            }
        }
    }
}
