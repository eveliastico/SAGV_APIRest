package com.application.SAGVRest.controllers;

import com.application.SAGVRest.Service.IProductoService;
import com.application.SAGVRest.controllers.dto.ProductoDTO;
import com.application.SAGVRest.entidades.CategoriaProducto;
import com.application.SAGVRest.entidades.Producto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Producto> productoOptional = productoService.findById(id);

        if(productoOptional.isPresent()){
            Producto producto = productoOptional.get();
            ProductoDTO productoDTO = ProductoDTO.builder()
                    .id(producto.getId())
                    .descripcion(producto.getDescripcion())
                    .nombre(producto.getNombre())
                    .categoriaProducto(producto.getCategoriaProducto())
                    .precio(producto.getPrecio())
                    .build();
            return ResponseEntity.ok(productoDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find/all")
    public ResponseEntity<?> findAll(){
        List<ProductoDTO> productoDTOList = productoService.findAll()
                .stream()
                .map(producto -> ProductoDTO.builder()
                        .id(producto.getId())
                        .descripcion(producto.getDescripcion())
                        .nombre(producto.getNombre())
                        .categoriaProducto(producto.getCategoriaProducto())
                        .precio(producto.getPrecio())
                        .build())
                .toList();
        return ResponseEntity.ok(productoDTOList);
    }

    @GetMapping("/categorie/{categoriaProducto}")
    public ResponseEntity<?> findAll(@PathVariable String categoriaProducto) {
        CategoriaProducto categoriaProductoEnum;

        try {
            categoriaProductoEnum = CategoriaProducto.valueOf(categoriaProducto.toUpperCase());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Categoría inválida: " + categoriaProducto);
        }

        List<ProductoDTO> listaProductosCategoria = productoService.findProductosByCategoriaProducto(categoriaProductoEnum)
                .stream()
                .map(producto -> ProductoDTO.builder()
                        .id(producto.getId())
                        .descripcion(producto.getDescripcion())
                        .nombre(producto.getNombre())
                        .categoriaProducto(producto.getCategoriaProducto())
                        .precio(producto.getPrecio())
                        .build())
                .toList();

        return ResponseEntity.ok(listaProductosCategoria);
    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductoDTO productoDTO){
        try {
        //CREAR VALIDACION PARA NO GUARDAR PRODUCTOS CON EL MISMO NOMBRE
            Producto producto = new Producto();

            producto.setNombre(productoDTO.getNombre());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setDescripcion(productoDTO.getDescripcion());
            producto.setCategoriaProducto(productoDTO.getCategoriaProducto());

            productoService.save(producto);

            ProductoDTO productoDTOResponse = ProductoDTO.builder()
                    .id(producto.getId())
                    .nombre(producto.getNombre())
                    .precio(producto.getPrecio())
                    .descripcion(producto.getDescripcion())
                    .categoriaProducto(producto.getCategoriaProducto())
                    .build();

            return ResponseEntity.status(HttpStatus.CREATED).body(productoDTOResponse);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar producto: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            if(productoService.findById(id).isPresent()){
                productoService.deleteById(id);
                return ResponseEntity.ok("Producto con ID " + id + " eliminado correctamente.");
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("ContenidoOrden con ID " + id + " no encontrado.");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar producto: " + e.getMessage());
        }
    }
}
