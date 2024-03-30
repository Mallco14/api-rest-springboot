package com.applicaction.rest.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fabricante")
@Builder
public class Maker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy ="maker", cascade=CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonIgnore//para ignorar al momento de devolver al JSON y no sea largo
    private List<Producto> productoList = new ArrayList<>();

}
