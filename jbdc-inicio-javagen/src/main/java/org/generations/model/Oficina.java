package org.generations.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Representación de la información de la tabla oficina jardineria, estas clases representa el model de MVC
//Etiquetas: Getters y setters para ahorrar los getters, los otros 2 inserta el constructor vacio y el cons con parametros
//CADA ENTIDAD TIENE SU PROPIO REPOSITORIO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Oficina {
    //Todos estos valores pertenecen a la tabla oficina de nuestra bd Jardineria
    private String codigoOficina;
    private String ciudad;
    private String pais;
    private String region;
    private String codigoPostal;
    private String telefono;
    private String lineaDireccion1;
    private String lineaDireccion2;

    @Override
    public String toString() {
        return "Oficina{" +
                "codigoOficina='" + codigoOficina + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", region='" + region + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", telefono='" + telefono + '\'' +
                ", lineaDireccion1='" + lineaDireccion1 + '\'' +
                ", lineaDireccion2='" + lineaDireccion2 + '\'' +
                '}';
    }
}
