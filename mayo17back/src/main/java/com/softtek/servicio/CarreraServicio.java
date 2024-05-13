package com.softtek.servicio;

import com.softtek.modelo.Carrera;
import com.softtek.repositorio.ICarreraRepo;
import com.softtek.repositorio.IGenericoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraServicio extends CRUDImpl<Carrera, Integer> implements ICarreraServicio{
    @Autowired
    private ICarreraRepo repo;

    @Override
    protected IGenericoRepository<Carrera, Integer> getRepo() {
        return repo;
    }
}
