package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "produto")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "compra"})
public class ProdutosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double valor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="compra_id")
    private ComprasEntity compra;

}
