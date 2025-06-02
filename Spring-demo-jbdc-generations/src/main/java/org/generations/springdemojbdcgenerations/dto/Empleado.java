package org.generations.springdemojbdcgenerations.dto;

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
    private String email;
    private String puesto;
}
