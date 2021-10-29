package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "compra")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ComprasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "compra", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ProdutosEntity> produtos;

}
