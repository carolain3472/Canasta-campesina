package com.canastacampesina.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.canastacampesina.model.Sesion;
import com.canastacampesina.services.SesionService;

@RestController
@RequestMapping("/canasta/usuarios")
public class SesionController {
    
    private SesionService service;

    public SesionController(){
        service=new SesionService();
    }

    @PostMapping
    public String crearUsuario(@RequestBody Sesion sesionObj){
        return service.crearUsuario(sesionObj);
    }

    @GetMapping
    public List<Sesion> obtenerUsuarios(){
        return service.obtenerUsuarios();
    }

    @RequestMapping("/login")
    @CrossOrigin("*")
    public @ResponseBody Map<String, Boolean> login(@RequestParam String usuario, String contrasena){
        return service.login(usuario, contrasena);
    }    
}

