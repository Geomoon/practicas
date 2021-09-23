package com.tecazuay.practicas.repository.Secondary;

import com.tecazuay.practicas.model.Secondary.FenixUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FenixUsersRepository extends JpaRepository<FenixUsers, Long> {
    @Override
    List<FenixUsers> findAll();
    Boolean existsByCedula(String cedula);
}
