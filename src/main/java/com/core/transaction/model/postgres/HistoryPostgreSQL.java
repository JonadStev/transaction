package com.core.transaction.model.postgres;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "info_history")
public class HistoryPostgreSQL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String provincia;
    private String ciudad;
    private String edad;
    private String genero;
    private String motivo_desaparicion;
    private String observacion;
    private String fecha_desaparicion;
    private String estado;
    private String fecha_localizacion;
}
