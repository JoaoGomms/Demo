package com.example.demo.controller;

import com.example.demo.model.ComprasEntity;
import com.example.demo.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api/v1/compras")
        public class ComprasController {

    @Autowired
    private ComprasRepository repository;

    @GetMapping(value = "/")
    public List<ComprasEntity> getAll(){
        return repository.findAll();
    }

    @PostMapping(value = "/add/{name}")
    public ComprasEntity addNew(@PathVariable("name") String name){

        ComprasEntity compra = new ComprasEntity();
        compra.setName(name);

        return repository.save(compra);
    }


}
