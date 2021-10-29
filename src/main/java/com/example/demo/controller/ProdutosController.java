package com.example.demo.controller;

import com.example.demo.model.ProdutosEntity;
import com.example.demo.repository.ComprasRepository;
import com.example.demo.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosRepository repository;

    @Autowired
    private ComprasRepository comprasRepository;

    @GetMapping(value = "/")
    public List<ProdutosEntity> getAll(){
        return repository.findAll();
    }

    @PostMapping(value = "/add/{compraId}/{name}")
    public ProdutosEntity addNew(
            @PathVariable("name") String name,
            @PathVariable("compraId") Long compraId
    ){

        ProdutosEntity produto = new ProdutosEntity();
        produto.setName(name);
        produto.setValor(30.00);
        produto.setCompra(comprasRepository.findById(compraId).get());

        return repository.save(produto);
    }

}
