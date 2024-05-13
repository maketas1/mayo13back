package com.softtek.dto;

import com.softtek.modelo.Carrera;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarreraDto {
    int id_carrera;

    String nombre_carrera;

    String fecha;

    String ubicacion;

    String cantridad_vueltas;

    public Carrera castCarrera() {
        Carrera c = new Carrera();
        c.setId_carrera(id_carrera);
        c.setNombre_carrera(nombre_carrera);
        c.setFecha(fecha);
        c.setUbicacion(ubicacion);
        c.setCantridad_vueltas(cantridad_vueltas);
        return  c;
    }

    public CarreraDto castCarreraADto(Carrera c) {
        id_carrera = c.getId_carrera();
        nombre_carrera = c.getNombre_carrera();
        fecha = c.getFecha();
        ubicacion = c.getUbicacion();
        cantridad_vueltas = c.getCantridad_vueltas();
        return this;
    }
}
