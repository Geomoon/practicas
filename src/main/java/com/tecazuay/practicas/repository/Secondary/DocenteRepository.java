package com.tecazuay.practicas.repository.Secondary;


import com.tecazuay.practicas.model.Secondary.Docentes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocenteRepository extends JpaRepository<Docentes, Long> {

    @Override
    List<Docentes> findAll();
}
