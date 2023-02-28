package com.practica01.service;

import com.practica01.domain.Pais;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practica01.dao.PaisDao;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaisServiceImpl implements PaisService{
    
    @Autowired
    PaisDao PaisDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pais> getPaises() {
        return (List<Pais>) PaisDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pais getPais(Pais pais) {
        return PaisDao.findById(pais.getIdPais()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Pais pais) {
        PaisDao.save(pais);
        
    }

    @Override
    @Transactional
    public void delete(Pais pais) {
        PaisDao.deleteById(pais.getIdPais());
        
    }
    
}
