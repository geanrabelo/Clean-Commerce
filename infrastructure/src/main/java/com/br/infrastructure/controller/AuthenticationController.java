package com.br.infrastructure.controller;

import com.br.core.exceptions.UserNotFound;
import com.br.infrastructure.domain.User;
import com.br.infrastructure.dto.user.*;
import com.br.infrastructure.repositories.UserRepository;
import com.br.infrastructure.service.TokenService;
import com.br.usecases.user.CreateUserEntityUseCase;
import com.br.usecases.user.DeleteByIdUserEntityUseCase;
import com.br.usecases.user.FindByIdUserEntityUseCase;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/commerce/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CreateUserEntityUseCase createUserEntityUseCase;

    @Autowired
    private DeleteByIdUserEntityUseCase deleteByIdUserEntityUseCase;

    @Autowired
    private FindByIdUserEntityUseCase findByIdUserEntityUseCase;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    @Transactional
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        var user = new UsernamePasswordAuthenticationToken(authenticationDTO.login(), authenticationDTO.password());
        var authentication = authenticationManager.authenticate(user);

        var token = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO registerDTO){
        if(userRepository.findByLogin(registerDTO.login()) != null) return ResponseEntity.badRequest().body("Login already exists");

        var passwordCrypt = new BCryptPasswordEncoder().encode(registerDTO.password());
        createUserEntityUseCase.create(registerDTO.login(), passwordCrypt, registerDTO.roles());

        return ResponseEntity.ok(new ResponseDTO("User registered sucessfull!"));
    }

    @GetMapping
    public ResponseEntity<?> findById(@RequestParam(value = "id") Long id) throws UserNotFound {
        var userEntity = findByIdUserEntityUseCase.findById(id);
        return ResponseEntity.ok(new UserFindDTO(id, userEntity));
    }


    @DeleteMapping
    @Transactional
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        deleteByIdUserEntityUseCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
