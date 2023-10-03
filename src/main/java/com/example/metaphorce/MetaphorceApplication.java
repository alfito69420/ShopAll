package com.example.metaphorce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.metaphorce.repository.ConnectionDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

@SpringBootApplication
@RestController
public class MetaphorceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MetaphorceApplication.class, args);
		}
	@GetMapping(path="/hola")
	public String hello_word(){
		return "helloWord desde maven";
		/*
		*Test para la base de datos
		*Es solo para comprobar la conexion a la base de datos
		 */
		
		/*
		ConnectionDB connectionDB = new ConnectionDB();
		try {
			//Para comprobar que esta cnectado
			Connection connection = connectionDB.createConnection();
			//Para cerrarlo
			//connectionDB.closeConnection(connection);
		} catch (Exception e) {
			System.err.println("Error al conectar a la base de datos: " + e.getMessage());
		}
		*/

	}

}
