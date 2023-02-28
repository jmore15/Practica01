package com.practica01.dao;

import com.practica01.domain.Pais;
import org.springframework.data.repository.CrudRepository;


public interface PaisDao extends  CrudRepository<Pais, Long>{
    
}
