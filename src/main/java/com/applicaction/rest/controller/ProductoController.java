package com.applicaction.rest.controller;

import com.applicaction.rest.controller.dto.MakerDTO;
import com.applicaction.rest.controller.dto.ProductoDTO;
import com.applicaction.rest.entities.Producto;
import com.applicaction.rest.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    @Autowired
    private IProductoService productoService;
    /**METODOS HTTP*/
    @GetMapping("/listar")
    public ResponseEntity<?> listarProductos(){
        List<ProductoDTO> listProducto = productoService.findAllProducts()
                .stream()
                .map(producto -> ProductoDTO.builder()
                        .idProducto(producto.getIdProducto())
                        .nombre(producto.getNombre())
                        .precio(producto.getPrecio())
                        .maker(producto.getMaker())
                        .build()
                ).toList();
        if(listProducto.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listProducto);
    }

    @GetMapping("/save")
    public ResponseEntity<?> createProducto(@RequestBody ProductoDTO productoDto) throws URISyntaxException {
        if(productoDto == null){
            return ResponseEntity.notFound().build();
        }else {
            Producto product = Producto.builder()
                    .precio(productoDto.getPrecio())
                    .nombre(productoDto.getNombre())
                    .maker(productoDto.getMaker())
                    .build();
            productoService.save(product);
        }
        return ResponseEntity.created(new URI("/api/producto/save")).build();

    }

    @PostMapping("/update/{id}/")
    public ResponseEntity<?> updateProducto(@RequestBody ProductoDTO productoDTO, @PathVariable Long id){
        //buscar el id y actualizarlo
        Optional<Producto> idProducto = productoService.findById(id);
        if(idProducto.isPresent()){
            Producto producto = idProducto.get();
            //aqui los productos a actualizar
            producto.setPrecio(productoDTO.getPrecio());
            //mandar el objeto final
            productoService.save(producto);
            return ResponseEntity.ok(producto);

        }
        return ResponseEntity.notFound().build();

    }


    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        if(id != null){
            Optional<Producto> idBusqueda = productoService.findById(id);
            if(idBusqueda.isPresent()){
                //obteniedo el valro del optional
                Producto producto = idBusqueda.get();
                return ResponseEntity.ok(producto);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
