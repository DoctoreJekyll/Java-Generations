package org.cplcursos.springdata.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
        @Id
        private Integer codigoEmpleado;
        private String nombre;
        private String apellido1;
        private String apellido2;
        private String extension;
        private String email;
        private String codigoOficina;
        private Integer codigoJefe; // Puede ser null
        private String puesto;

        public String toString() {
            return "Empleado [codigoEmpleado=" + codigoEmpleado + ", nombre=" + nombre + ", apellido1=" + apellido1 +
                    ", apellido2=" + apellido2 + "]";
        }


}
