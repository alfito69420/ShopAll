package com.example.metaphorce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.metaphorce.repository.ConnectionDB;

import java.sql.Connection;

@SpringBootApplication
public class MetaphorceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MetaphorceApplication.class, args);



		/*
		*Test para la base de datos
		*Es solo para comprobar la conexion a la base de datos
		 */
		ConnectionDB connectionDB = new ConnectionDB();
		try {
			//Para comprobar que esta cnectado
			Connection connection = connectionDB.createConnection();
			//Para cerrarlo
			//connectionDB.closeConnection(connection);
		} catch (Exception e) {
			System.err.println("Error al conectar a la base de datos: " + e.getMessage());
		}
	}

}
