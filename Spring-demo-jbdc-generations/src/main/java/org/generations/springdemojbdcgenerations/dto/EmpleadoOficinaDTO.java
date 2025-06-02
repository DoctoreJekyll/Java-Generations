package org.generations.springdemojbdcgenerations.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoOficinaDTO {
    private String codigo_empleado;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String puesto;
    private String ciudad;
}
