package com.softtek.controlador;

import com.softtek.dto.CarreraDto;
import com.softtek.excepciones.ExcepcionesPersonalizadasNoEncontrado;
import com.softtek.modelo.Carrera;
import com.softtek.servicio.ICarreraServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carreras")
@CrossOrigin(origins = "http://localhost:4200")
public class CarreraControlador {
    @Autowired
    public ICarreraServicio servicio;

    @GetMapping
    public ResponseEntity<List<CarreraDto>> obtenerTodos() {
        List<Carrera> lugaresBBDD = servicio.consultaTodos();
        List<CarreraDto> lugaresDto = new ArrayList<>();

        for (Carrera lugar: lugaresBBDD) {
            CarreraDto lDto = new CarreraDto();
            lugaresDto.add(lDto.castCarreraADto(lugar));
        }
        return new ResponseEntity<>(lugaresDto, HttpStatus.OK);
    }

    @GetMapping("/{id_carrera}")
    public ResponseEntity<CarreraDto> obtenerUno(@PathVariable(name = "id_carrera") int id_carrera) {
        Carrera l1 = servicio.consultaUno(id_carrera);
        if (l1 == null) {
            throw new ExcepcionesPersonalizadasNoEncontrado("CARRERA NO ENCONTRADO " + id_carrera);
        }
        return new ResponseEntity<>((new CarreraDto()).castCarreraADto(l1), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarreraDto> crearProducto(@Valid @RequestBody CarreraDto l) {
        Carrera l1 = l.castCarrera();
        l1 = servicio.crear(l1);
        return new ResponseEntity<>(l.castCarreraADto(l1), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CarreraDto> updateProducto(@Valid @RequestBody CarreraDto l) {
        Carrera l1 = servicio.consultaUno(l.getId_carrera());
        if (l1 == null) {
            throw new ExcepcionesPersonalizadasNoEncontrado("CARRERA NO ENCONTRADO " + l.getId_carrera());
        }
        return new ResponseEntity<>(l.castCarreraADto(l1), HttpStatus.OK);
    }

    @DeleteMapping("/{id_carrera}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable(name = "id_carrera") int id_carrera) {
        Carrera l = servicio.consultaUno(id_carrera);
        if(l == null) {
            throw new ExcepcionesPersonalizadasNoEncontrado("CARRERA NO ENCONTRADO " + id_carrera);
        }
        servicio.eliminar(id_carrera);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
