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
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringDemoJbdcGenerationsApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringDemoJbdcGenerationsApplication.class, args);
        //ConfigurableApplicationContext context = SpringApplication.run(SpringDemoJbdcGenerationsApplication.class, args);

        SpringApplication.run(SpringDemoJbdcGenerationsApplication.class, args);

    }

}


