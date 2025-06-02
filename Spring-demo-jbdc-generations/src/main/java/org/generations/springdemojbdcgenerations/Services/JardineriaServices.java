package org.generations.springdemojbdcgenerations.Services;

import org.generations.springdemojbdcgenerations.dto.EmpleadoOficinaDTO;
import org.generations.springdemojbdcgenerations.dto.VentasDTO;
import org.generations.springdemojbdcgenerations.dto.Empleado;
import org.generations.springdemojbdcgenerations.repositories.JardineriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JardineriaServices {
    private final JardineriaRepository jardineriaRepository;

    public JardineriaServices(JardineriaRepository jardineriaRepository) {
        this.jardineriaRepository = jardineriaRepository;
    }

    public List<Empleado> getEmpleados()
    {
        return  jardineriaRepository.getEmpleados();
    }

    public List<EmpleadoOficinaDTO> getEmpleadoByOficina()
    {
        return  jardineriaRepository.getEmpleadoByOficina();
    }

    public List<VentasDTO> getTotalVentasByEmpleado()
    {
        return  jardineriaRepository.getTotalVentasByEmpleado();
    }
}
