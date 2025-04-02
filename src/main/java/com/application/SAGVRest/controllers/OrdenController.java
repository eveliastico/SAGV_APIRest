package com.application.SAGVRest.controllers;

import com.application.SAGVRest.Service.IOrdenService;
import com.application.SAGVRest.controllers.dto.OrdenDTO;
import com.application.SAGVRest.entidades.Orden;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orden")
public class OrdenController {

    @Autowired
    private IOrdenService ordenService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        try{
            Optional<Orden> ordenOptional = ordenService.findById(id);

            if(ordenOptional.isPresent()){

                Orden orden = ordenOptional.get();
                OrdenDTO ordenDTO = OrdenDTO.builder()
                        .id(orden.getId())
                        .fechaHora(orden.getFechaHora())
                        .numMesa(orden.getNumMesa())
                        .listaContenidosOrdenes(orden.getListaContenidosOrdenes())
                        .build();
                return ResponseEntity.ok(ordenDTO);
            }else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al consultar la orden: " + e.getMessage());
        }
    }

    @GetMapping("/find/all")
    public ResponseEntity<?> findAll(){
        try{
            List<OrdenDTO> ordenDTOList = ordenService.findAll()
                    .stream()
                    .map(orden -> OrdenDTO.builder()
                            .id(orden.getId())
                            .fechaHora(orden.getFechaHora())
                            .numMesa(orden.getNumMesa())
                            .pagoPendiente(orden.isPagoPendiente())
                            .listaContenidosOrdenes(orden.getListaContenidosOrdenes())
                            .build())
                    .toList();
            return ResponseEntity.ok(ordenDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al consultar (All) ordenes: " + e.getMessage());
        }
    }

    @GetMapping("/find/mesa/{numMesa}")
    public ResponseEntity<?> findByMesa(@PathVariable int numMesa){
        //NOTA: Pon validacion por si el numero de mesa es < 1
        try{
            List<OrdenDTO> ordenDTOList = ordenService.findOrdenByNumMesa(numMesa)
                    .stream()
                    .map(orden -> OrdenDTO.builder()
                            .id(orden.getId())
                            .fechaHora(orden.getFechaHora())
                            .numMesa(orden.getNumMesa())
                            .pagoPendiente(orden.isPagoPendiente())
                            .listaContenidosOrdenes(orden.getListaContenidosOrdenes())
                            .build())
                    .toList();
            return ResponseEntity.ok(ordenDTOList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al consultar las ordenes asociadas a la mesa: "+ numMesa+" "+ e.getMessage());
        }
    }

    @GetMapping("/find/by_fecha/{fechaMin}/{fechaMax}")
    public ResponseEntity<?> findByMesa(
            @PathVariable LocalDateTime fechaMin,
            @PathVariable LocalDateTime fechaMax){
        //NOTA: Pon validacion por si el numero de mesa es < 1
        try{
            List<OrdenDTO> ordenDTOList = ordenService.findOrdenByFechaHoraBetween(fechaMin, fechaMax)
                    .stream()
                    .map(orden -> OrdenDTO.builder()
                            .id(orden.getId())
                            .fechaHora(orden.getFechaHora())
                            .numMesa(orden.getNumMesa())
                            .pagoPendiente(orden.isPagoPendiente())
                            .listaContenidosOrdenes(orden.getListaContenidosOrdenes())
                            .build())
                    .toList();
            return ResponseEntity.ok(ordenDTOList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al consultar las ordenes entre las fechas brindadas"
                            + e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody OrdenDTO ordenDTO){
        try{
            Orden orden = new Orden();

            //AQUI TENGO QUE PONER UNA VALIDACION PARA CUANDO LA MESA QUE SE INGRESA YA EXISTE EN
            //EL SISTEMA.
            orden.setFechaHora(ordenDTO.getFechaHora());
            orden.setNumMesa(ordenDTO.getNumMesa());
            ordenService.save(orden);
            OrdenDTO ordenResponseDTO = OrdenDTO.builder()
                    .id(orden.getId())
                    .fechaHora(orden.getFechaHora())
                    .numMesa(orden.getNumMesa())
                    .build();
            return ResponseEntity.status(HttpStatus.CREATED).body(ordenResponseDTO);

//            return ResponseEntity.status(HttpStatus.CONFLICT).body("La orden ya existe");

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar la orden: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            if (ordenService.findById(id).isPresent()) {
                ordenService.deleteById(id);
                return ResponseEntity.ok("Orden con ID " + id + " eliminado correctamente.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Orden con ID " + id + " no encontrado.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar orden: " + e.getMessage());
        }
    }




}
