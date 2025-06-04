package org.generations.springdemojbdcgenerations.Controllers;

import org.generations.springdemojbdcgenerations.Services.JardineriaServices;
import org.generations.springdemojbdcgenerations.dto.Empleado;
import org.generations.springdemojbdcgenerations.dto.EmpleadoOficinaDTO;
import org.generations.springdemojbdcgenerations.dto.VentasDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api")
public class JardineriaController {

    private final JardineriaServices jardineriaServices;

    public JardineriaController(JardineriaServices jardineriaServices) {
        this.jardineriaServices = jardineriaServices;
    }

    @GetMapping("/test")
    public String home(Model model)
    {
        // Puedes pasar atributos al HTML si quieres
        model.addAttribute("mensaje", "¡Bienvenido a Jardinería!");
        return "index";
    }

    // ✅ GET empleados
    @GetMapping("/empleados")
    public List<Empleado> getEmpleados() {
        return jardineriaServices.getEmpleados();
    }

    // ✅ GET empleados con oficina
    @GetMapping("/oficinas")
    public String getEmpleadosPorOficina(Model model) {

        List<EmpleadoOficinaDTO> empleadoByOficina = jardineriaServices.getEmpleadoByOficina();
        model.addAttribute("empleadoByOficina", empleadoByOficina);

        return "listaOficinas";
    }

    // ✅ GET total de ventas por gama
    @GetMapping("/ventas")
    public Map<String, List<VentasDTO>> getVentasAgrupadasPorGama() {
        List<VentasDTO> totalVentasList = jardineriaServices.getTotalVentasByEmpleado();
        return totalVentasList.stream()
                .collect(Collectors.groupingBy(VentasDTO::getGama));
    }
}
