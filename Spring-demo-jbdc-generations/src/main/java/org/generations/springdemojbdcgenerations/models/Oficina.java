package org.generations.springdemojbdcgenerations.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Oficina {
    private String codigo_oficina;
    private String ciudad;
    private String telefono;
    private String linea_direccion1;
    private String linea_direccion2;
}
