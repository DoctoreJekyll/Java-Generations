package org.generations.springdemojbdcgenerations.Controllers;

import org.generations.springdemojbdcgenerations.Services.JardineriaServices;
import org.generations.springdemojbdcgenerations.dto.Empleado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    private final JardineriaServices jardineriaServices;

    public EmpleadoController(JardineriaServices jardineriaServices) {
        this.jardineriaServices = jardineriaServices;
    }

    // ✅ GET empleados
    @GetMapping()
    public String getEmpleados(Model model) {
        List<Empleado> empleadoList =  jardineriaServices.getEmpleados();
        model.addAttribute("empleadoList", empleadoList);
        return "listaEmpleados";
    }

}
