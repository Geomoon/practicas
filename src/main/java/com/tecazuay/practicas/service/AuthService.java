package com.tecazuay.practicas.service;

import com.tecazuay.practicas.dto.RegisterRequest;
import com.tecazuay.practicas.dto.UserRequest;
import com.tecazuay.practicas.dto.UserResponse;
import com.tecazuay.practicas.exception.ResponseNotFoundException;
import com.tecazuay.practicas.model.Primary.Usuario;
import com.tecazuay.practicas.model.Secondary.Docentes;
import com.tecazuay.practicas.model.Secondary.FenixUsers;
import com.tecazuay.practicas.repository.Primary.UsuarioRepository;
import com.tecazuay.practicas.repository.Secondary.DocenteRepository;
import com.tecazuay.practicas.repository.Secondary.FenixUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
            getDocenteRepository();
            usuario.setUrlFoto(userRequest.getUrlFoto());

            usuarioRepository.save(usuario);

            return new UserResponse(usuario.getId(), usuario.getEmail(), usuario.getUrlFoto(), usuario.getCedula());
        }
        throw new ResponseNotFoundException("Usuario", "email", (String) userRequest.getEmail());
    }


    //PRIMERA VEZ QUE INGRESA SE REGISTRA
    @Transactional
    public UserResponse signup(RegisterRequest registerRequest) {
        Usuario newUser = new Usuario();
        newUser.setCedula(registerRequest.getCedula());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setUrlFoto(registerRequest.getUrlFoto());

        if(getfenixUsersRepository(registerRequest.getCedula())){
            Usuario usuario = usuarioRepository.save(newUser);
            if (usuario != null)
                return new UserResponse(usuario.getId(), usuario.getEmail(), usuario.getUrlFoto(), usuario.getCedula());
            return null;
        }else{
            throw new ResponseNotFoundException("Usuario", "cedula", (String) registerRequest.getCedula());
        }


    }
    @Autowired
    private DocenteRepository docenteRepository;
    public void getDocenteRepository() {
        List<Docentes> listadocentes= docenteRepository.findAll();
        listadocentes.stream().forEach(docentes -> {
            System.out.println(docentes.getPer_celular()+" "+docentes.getPer_primerapellido() +" "+docentes.getPer_correo());

        });


    }


    //Obtener usuario de tabla roles_personas medinate cedula
    @Autowired
    private FenixUsersRepository fenixUsersRepository;
    private boolean getfenixUsersRepository(String cedula){
        return fenixUsersRepository.existsByCedula(cedula);

    }


}
