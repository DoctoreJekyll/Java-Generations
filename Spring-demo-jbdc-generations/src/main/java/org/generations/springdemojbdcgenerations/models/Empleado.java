package org.generations.springdemojbdcgenerations.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Empleado {
    private Integer id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String extension;
    private String email;
    private String codigo_Oficina;
    private String codigo_jefe;
    private String puesto;
}
