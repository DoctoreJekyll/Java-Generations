package servicios;

import modelos.Oficina;
import repositorios.OficinaRepo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OficinaSrvc {

    OficinaRepo ofiRepo = new OficinaRepo();

    public List<Oficina> listaOficinas() throws SQLException {
        List<Oficina> oficinas = new ArrayList<Oficina>();
        oficinas = ofiRepo.listarOficinas();
        return oficinas;
    }
}
