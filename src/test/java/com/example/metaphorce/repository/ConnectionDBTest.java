package com.example.metaphorce.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionDBTest {

    private ConnectionDB connectionDB;
    private Connection connection;

    @BeforeEach
    void setUp() {
        connectionDB = new ConnectionDB();
    }

    @Test
    void createConnection() {
        try {
            connection = connectionDB.createConnection();
            assertNotNull(connection);
            assertFalse(connection.isClosed());
        } catch (SQLException e) {
            fail("Se produjo un error al establecer la conexión: " + e.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        try {
            connectionDB.closeConnection(connection);
            assertTrue(connection.isClosed());
        } catch (SQLException e) {
            fail("Se produjo un error al cerrar la conexión: " + e.getMessage());
        }
    }


}