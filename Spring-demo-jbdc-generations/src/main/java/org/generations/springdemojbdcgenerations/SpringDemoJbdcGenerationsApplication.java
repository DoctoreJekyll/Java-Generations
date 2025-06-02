package org.generations.springdemojbdcgenerations;

import org.generations.springdemojbdcgenerations.Services.JardineriaServices;
import org.generations.springdemojbdcgenerations.dto.EmpleadoOficinaDTO;
import org.generations.springdemojbdcgenerations.dto.VentasDTO;
import org.generations.springdemojbdcgenerations.mappers.OficinaMapper;
import org.generations.springdemojbdcgenerations.dto.Empleado;
import org.generations.springdemojbdcgenerations.models.Oficina;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class SpringDemoJbdcGenerationsApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringDemoJbdcGenerationsApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(SpringDemoJbdcGenerationsApplication.class, args);
        JardineriaServices jardineriaServices = context.getBean(JardineriaServices.class);

        System.out.println("----------------EJERCICIO DATOS EMPLEADOS");
        List<Empleado> empleados = jardineriaServices.getEmpleados();
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }

        System.out.println("------------------------------------------------------");
        System.out.println("------------EJERCICIO EMPLEADO/OFICINAS--------------");

        List<EmpleadoOficinaDTO> empleadoOficinaDTOS = jardineriaServices.getEmpleadoByOficina();
        for (EmpleadoOficinaDTO emp : empleadoOficinaDTOS) {
            System.out.println(emp);
        }

        System.out.println("----------------------------------------------");
        System.out.println("--------------EJERCICIO VENTAS---------------");

        List<VentasDTO> totalVentasList = jardineriaServices.getTotalVentasByEmpleado();
        for (VentasDTO ventasDTO : totalVentasList) {
            System.out.println(ventasDTO);
        }

    }

}


