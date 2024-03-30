package com.applicaction.rest.controller.dto;

import com.applicaction.rest.entities.Producto;
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
@Builder
public class MakerDTO {

    private Long id;
    private String nombre;
    private List<Producto> productoList = new ArrayList<>();

}
