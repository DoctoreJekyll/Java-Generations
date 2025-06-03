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

    /*
------------------------------------------------------
📝 APUNTE: EXPLICACIÓN DE LA QUERY DE TOTAL VENTAS
------------------------------------------------------

Esta consulta obtiene el total de ventas por categoría (gama) de producto para cada empleado,
incluyendo información personal del empleado y su oficina.

🔍 ¿Qué devuelve?
- Código, nombre y apellidos del empleado.
- Puesto que ocupa.
- Ciudad de la oficina a la que pertenece.
- Gama del producto (categoría).
- Total de ventas realizadas por ese empleado para esa gama.

📦 SELECT:
- Se seleccionan los datos del empleado (e), la oficina (o), el producto (p)
  y se calcula el total de ventas con: SUM(dp.cantidad * dp.precio_unidad)

🔗 FROM y JOINs:
- empleado e
- JOIN oficina o             → para obtener la ciudad de la oficina.
- JOIN cliente c             → para saber qué clientes representa ese empleado.
- JOIN pedido pe             → para obtener los pedidos de esos clientes.
- JOIN detalle_pedido dp     → para obtener el detalle de cada pedido (precio y cantidad).
- JOIN producto p            → para obtener la gama (categoría) del producto.

📊 GROUP BY:
- Se agrupa por empleado y gama para poder sumar las ventas de cada categoría
  para cada empleado.

📋 ORDER BY:
- Ordena la lista por código del empleado y luego por gama.

✅ Resultado:
Una fila por empleado y gama, con su total de ventas acumuladas.

*/
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
