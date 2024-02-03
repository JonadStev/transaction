package com.core.transaction.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HistoryDTO {
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
