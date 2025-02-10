package com.application.SAGVRest.controllers;

import com.application.SAGVRest.Service.IContenidoOrdenService;
import com.application.SAGVRest.Service.IOrdenService;
import com.application.SAGVRest.Service.IProductoService;
import com.application.SAGVRest.controllers.dto.ContenidoOrdenDTO;
import com.application.SAGVRest.entidades.ContenidoOrden;
import com.application.SAGVRest.entidades.Orden;
import com.application.SAGVRest.entidades.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contenido_orden")
public class ContenidoOrdenController {

    @Autowired
    private IContenidoOrdenService contenidoOrdenService;
    @Autowired
    private IOrdenService ordenService;
    @Autowired
    private IProductoService productoService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<ContenidoOrden> contenidoOrdenOptional = contenidoOrdenService.findById(id);

        if(contenidoOrdenOptional.isPresent()){
            ContenidoOrden contenidoOrden = contenidoOrdenOptional.get();
            ContenidoOrdenDTO contenidoOrdenDTO = ContenidoOrdenDTO.builder()
                    .id(contenidoOrden.getId())
                    .cantidadProducto(contenidoOrden.getCantidadProducto())
                    .notas(contenidoOrden.getNotas())
                    .idOrden(contenidoOrden.getOrden().getId())
                    .idProducto(contenidoOrden.getProducto().getId())
                    .build();
            return ResponseEntity.ok(contenidoOrdenDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find/all")
    public ResponseEntity<?> findAll(){
        List<ContenidoOrdenDTO> contenidoOrdenDTOList = contenidoOrdenService.findAll()
                .stream()
                .map(contenidoOrden -> ContenidoOrdenDTO.builder()
                        .id(contenidoOrden.getId())
                        .cantidadProducto(contenidoOrden.getCantidadProducto())
                        .notas(contenidoOrden.getNotas())
                        .idOrden(contenidoOrden.getOrden().getId())
                        .idProducto(contenidoOrden.getProducto().getId())
                        .build())
                .toList();
        return ResponseEntity.ok(contenidoOrdenDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ContenidoOrdenDTO contenidoOrdenDTO) {
        try {
            Orden orden = ordenService.findById(contenidoOrdenDTO.getIdOrden())
                    .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
            System.out.println("ORDEN_ID"+orden.getId());

            Producto producto = productoService.findById(contenidoOrdenDTO.getIdProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            System.out.println("PRODUCTO_ID"+producto.getId());
            ContenidoOrden contenidoOrden = new ContenidoOrden();
            contenidoOrden.setCantidadProducto(contenidoOrdenDTO.getCantidadProducto());
            contenidoOrden.setNotas(contenidoOrdenDTO.getNotas());
            contenidoOrden.setOrden(orden);
            contenidoOrden.setProducto(producto);

            contenidoOrdenService.save(contenidoOrden);

            ContenidoOrdenDTO responseDTO = ContenidoOrdenDTO.builder()
                    .id(contenidoOrden.getId())
                    .cantidadProducto(contenidoOrden.getCantidadProducto())
                    .notas(contenidoOrden.getNotas())
                    .idOrden(contenidoOrden.getOrden().getId())
                    .idProducto(contenidoOrden.getProducto().getId())
                    .build();

            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar contenido_orden: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            if (contenidoOrdenService.findById(id).isPresent()) {
                contenidoOrdenService.deleteById(id);
                return ResponseEntity.ok("ContenidoOrden con ID " + id + " eliminado correctamente.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("ContenidoOrden con ID " + id + " no encontrado.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar contenido_orden: " + e.getMessage());
        }
    }



}
