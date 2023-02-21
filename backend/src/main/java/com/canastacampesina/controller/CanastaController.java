package com.canastacampesina.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.canastacampesina.model.Canasta;
import com.canastacampesina.services.CanastaService;


@RestController
@RequestMapping("/canasta/productos")
public class CanastaController {

    private CanastaService service;

    private CanastaController(){
        service = new CanastaService();
    }

    @PostMapping
    public boolean crearProducto(@RequestBody Canasta canastaObj){
        return service.crearProducto(canastaObj);
    }

    @GetMapping
    @CrossOrigin("*")
    public List<Canasta> consultarProductos(){
        return service.consultarProductos();
    }

    @CrossOrigin("*")
    @PatchMapping("/compra")
    public boolean comprarProducto(@RequestParam int id, @RequestParam int cantidadCompra){
        return service.comprarProducto(id, cantidadCompra);
    } 

    @CrossOrigin("*")
    @PatchMapping("/venta")
    public boolean venderProducto(@RequestParam int id, @RequestParam int cantidadVenta){
        return service.venderProducto(id, cantidadVenta);
    }
}
