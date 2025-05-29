package servicios;

import modelos.Oficina;
import repositorios.OficinaRepo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OficinaSrvc implements IOficinaSrvc{

    OficinaRepo ofiRepo = new OficinaRepo();

    @Override
    public List<Oficina> listarOficinas() throws SQLException {
        List<Oficina> oficinas;
        oficinas = ofiRepo.listarOficinas();
        return oficinas;
    }

    @Override
    public Optional<Oficina> listarOficina(String idOficina) throws SQLException {
       return ofiRepo.leerOficinaxId(idOficina);
    }

    @Override
    public void crearOficina(Oficina oficina) throws IllegalAccessException, SQLException {
        ofiRepo.CrearOficina(oficina);
    }

    @Override
    public boolean actualizarOficina(Oficina oficina) throws SQLException {
        return ofiRepo.actualizarOficina(oficina);
    }

    @Override
    public void eliminarOficina(String codigo) throws SQLException {
        ofiRepo.eliminarOficina(codigo);
    }
}
