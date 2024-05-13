package com.softtek.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "carreras")
public class Carrera {
    @Id
    int id_carrera;

    @Column(length = 20, nullable = false)
    String nombre_carrera;

    @Column(length = 20, nullable = false)
    String fecha;

    @Column(length = 20, nullable = false)
    String ubicacion;

    @Column(length = 20, nullable = false)
    String cantridad_vueltas;
}
