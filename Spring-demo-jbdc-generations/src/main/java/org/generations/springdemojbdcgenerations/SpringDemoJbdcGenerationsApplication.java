package org.generations.springdemojbdcgenerations;

import org.generations.springdemojbdcgenerations.mappers.EmpleadoMapper;
import org.generations.springdemojbdcgenerations.mappers.OficinaMapper;
import org.generations.springdemojbdcgenerations.models.Empleado;
import org.generations.springdemojbdcgenerations.models.Oficina;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class SpringDemoJbdcGenerationsApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringDemoJbdcGenerationsApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(SpringDemoJbdcGenerationsApplication.class, args);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        String qry = "SELECT * FROM oficina";

        System.out.println("---------------DATOS OFICINA----------------");
        //Leemos datos de oficina
        List<Oficina> oficinaList = jdbcTemplate.query(qry, new OficinaMapper());
        for (Oficina oficina : oficinaList) {
            System.out.println(oficina);
        }



        System.out.println("----------DATOS EMPLEADOS-----------");
        //Leemos datos de empleado
        String qry2 = "SELECT * FROM empleado";
        List<Empleado> empleados = jdbcTemplate.query(qry2, new EmpleadoMapper());
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }

        System.out.println("------------EJERCICIO EMPLEADO--------------");
        String sql = "SELECT e.codigo_empleado, e.nombre, e.apellido1, e.apellido2, e.email, o.codigo_oficina " +
                "FROM empleado e " +
                "JOIN oficina o ON e.codigo_oficina = o.codigo_oficina " +
                "ORDER BY o.codigo_oficina, e.codigo_empleado";

        List<Empleado> empleadosList = jdbcTemplate.query(sql, new EmpleadoMapper());

        for (Empleado emp : empleadosList) {
            System.out.println(emp);
        }
    }

}
