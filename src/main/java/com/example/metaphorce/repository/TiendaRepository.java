package com.example.demo.repository;

import com.example.demo.model.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
//import org.springframework.data.jpa.repository.JpaRepository;

public class TiendaRepository{
    @Autowired
    JdbcTemplateAutoConfiguration jbc;

    /*
    public List<Tienda> getAll(){
        String sqlQuery = "SELECT * FROM tienda"

    }

     */
}
