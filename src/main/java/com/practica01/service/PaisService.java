package com.practica01.service;

import com.practica01.domain.Pais;
import java.util.List;
import ch.qos.logback.core.net.server.Client;

public interface PaisService {

    public List<Pais> getPaises();

    public Pais getPais(Pais pais);

    public void save(Pais pais);

    public void delete(Pais pais);

}
