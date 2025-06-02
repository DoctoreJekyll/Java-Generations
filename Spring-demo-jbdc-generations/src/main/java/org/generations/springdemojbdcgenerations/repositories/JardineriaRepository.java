package org.generations.springdemojbdcgenerations.repositories;

import org.generations.springdemojbdcgenerations.dto.EmpleadoOficinaDTO;
import org.generations.springdemojbdcgenerations.dto.VentasDTO;
import org.generations.springdemojbdcgenerations.mappers.EmpleadoMapper;
import org.generations.springdemojbdcgenerations.mappers.EmpleadoOficinaMapper;
import org.generations.springdemojbdcgenerations.mappers.VentasMapper;
import org.generations.springdemojbdcgenerations.dto.Empleado;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JardineriaRepository {

    private final JdbcTemplate jdbcTemplate;

    public JardineriaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Empleado> getEmpleados(){
        String qry2 = "SELECT * FROM empleado";
        List<Empleado> empleados = jdbcTemplate.query(qry2, new EmpleadoMapper());
        return empleados;
    }

    public List<EmpleadoOficinaDTO> getEmpleadoByOficina() {
        String sql = """
            SELECT
             e.codigo_empleado,
             e.nombre,
             e.apellido1,
             e.apellido2,
             e.email,
             e.puesto,
             o.ciudad
            FROM empleado e
            JOIN oficina o ON e.codigo_oficina = o.codigo_oficina
            ORDER BY o.ciudad, e.codigo_empleado;
        """;

        List<EmpleadoOficinaDTO> empleadosList = jdbcTemplate.query(sql, new EmpleadoOficinaMapper());
        return empleadosList;
    }

    public List<VentasDTO> getTotalVentasByEmpleado() {
        String qry3= """
                SELECT
                    e.codigo_empleado,
                    e.nombre,
                    e.apellido1,
                    e.apellido2,
                    e.puesto,
                    o.ciudad,
                    p.gama,
                    SUM(dp.cantidad * dp.precio_unidad) AS total_ventas
                FROM empleado e
                JOIN oficina o ON e.codigo_oficina = o.codigo_oficina
                JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas
                JOIN pedido pe ON c.codigo_cliente = pe.codigo_cliente
                JOIN detalle_pedido dp ON pe.codigo_pedido = dp.codigo_pedido
                JOIN producto p ON dp.codigo_producto = p.codigo_producto
                GROUP BY
                    e.codigo_empleado,
                    e.nombre,
                    e.apellido1,
                    e.apellido2,
                    e.puesto,
                    o.ciudad,
                    p.gama
                ORDER BY
                    e.codigo_empleado,
                    p.gama
                """;

        List<VentasDTO> totalVentasList = jdbcTemplate.query(qry3, new VentasMapper());
        return totalVentasList;
    }


}
