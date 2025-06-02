package org.generations.springdemojbdcgenerations.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VentasDTO {
    private String codigo_empleado;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String puesto;
    private String ciudad;
    private String gama;
    private double totalVentas;
}
