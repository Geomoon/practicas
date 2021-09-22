package com.tecazuay.practicas.service;

import com.tecazuay.practicas.dto.RegisterRequest;
import com.tecazuay.practicas.dto.UserRequest;
import com.tecazuay.practicas.dto.UserResponse;
import com.tecazuay.practicas.exception.BadRequestException;
import com.tecazuay.practicas.exception.ResponseNotFoundException;
import com.tecazuay.practicas.model.Usuario;
import com.tecazuay.practicas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public UserResponse login(UserRequest userRequest) {
        Optional<Usuario> optional = usuarioRepository.findByEmail(userRequest.getEmail());

        if (optional.isPresent()) {
            Usuario usuario = optional.get();
            System.out.println(usuario);

            usuario.setUrlFoto(userRequest.getUrlFoto());

            usuarioRepository.save(usuario);
            return new UserResponse(usuario.getId(), usuario.getEmail(), usuario.getUrlFoto(), usuario.getCedula());
        }
        throw new ResponseNotFoundException("Usuario", "email", (String) userRequest.getEmail());
    }

    @Transactional
    public UserResponse signup(RegisterRequest registerRequest) {
        Usuario newUser = new Usuario();
        newUser.setCedula(registerRequest.getCedula());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setUrlFoto(registerRequest.getUrlFoto());

        Usuario usuario = usuarioRepository.save(newUser);
        if (usuario != null)
            return new UserResponse(usuario.getId(), usuario.getEmail(), usuario.getUrlFoto(), usuario.getCedula());
        return null;
    }

}
