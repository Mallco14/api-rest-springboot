package com.applicaction.rest.controller;

import com.applicaction.rest.controller.dto.MakerDTO;
import com.applicaction.rest.entities.Maker;
import com.applicaction.rest.services.IMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/maker")
public class MakeController {
    @Autowired
    private IMakeService makeService;

    @GetMapping("find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        // Se llama al servicio para buscar un fabricante por su ID
        Optional<Maker> makerOptional = makeService.findById(id);

        // Se verifica si el fabricante está presente en la base de datos
        if(makerOptional.isPresent()) {
            // Se obtiene el objeto Maker del Optional
            Maker maker = makerOptional.get();

            // Se crea un objeto MakerDTO con los datos del Maker
            MakerDTO makerDTO = MakerDTO.builder()
                    .id(maker.getId())
                    .nombre(maker.getNombre())
                    .productoList(maker.getProductoList())
                    .build();

            // Se devuelve una respuesta HTTP con el objeto MakerDTO y código de estado 200 (OK)
            return ResponseEntity.ok(makerDTO);
        }
        // Si el fabricante no está presente, se devuelve una respuesta HTTP con código de estado 404 (Not Found)
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        //Recordemos que siempre devolveremos un DTO, nunca directamente la entity.

        //Convertiendo a un listado de MakerDTO
        List<MakerDTO> list = makeService.findAll()
                //esto permite procesar los datos de la lista
                .stream()
                //.map : tranforma cada objeto de Tipo Maker a un objeto MakerDTO
                .map(maker -> MakerDTO.builder()
                        .id(maker.getId())
                        .nombre(maker.getNombre())
                        .productoList(maker.getProductoList())
                        .build())
                .toList();
        //el ok, indica que es un codigo de estado 200(ok)
        return ResponseEntity.ok(list);
    }
    //metodo para guardar un Maker

    @PostMapping("/save/")
    public ResponseEntity<?> save(@RequestBody MakerDTO makerDTO) throws URISyntaxException {
        if(makerDTO.getNombre().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        if(makerDTO.getProductoList().isEmpty()){
            //aqui no nos interesa la lista
            makeService.save(Maker.builder()
                    .nombre(makerDTO.getNombre())
                    .build());
        }else{
            //aqui si mandan de manera completa
            makeService.save(Maker.builder()
                    .nombre(makerDTO.getNombre())
                    .productoList(makerDTO.getProductoList())
                    .build());
        }
        return ResponseEntity
                .ok("Creado Correctamente")
                .created(new URI("/api/maker/save/")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMaker(@PathVariable Long id, @RequestBody MakerDTO makerDTO){
        ///validmos si el id ya existe
        Optional<Maker> makerOptional = makeService.findById(id);
        if(makerOptional.isPresent()){
            //recuperando el objeto Maker
            Maker maker = makerOptional.get();
            maker.setNombre(makerDTO.getNombre());
            makeService.save(maker);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if(id != null){
            makeService.deleteById(id);
            return ResponseEntity.ok("Eliminado correctamente");
        }
        return  ResponseEntity.badRequest().build();
    }

}
