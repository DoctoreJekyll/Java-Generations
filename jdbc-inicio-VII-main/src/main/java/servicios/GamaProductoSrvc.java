package servicios;

import modelos.GamaProducto;
import repositorios.GamaRepo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GamaProductoSrvc implements IGamaProducto {

    GamaRepo gamaRepo = new GamaRepo();

    @Override
    public void crearGama(GamaProducto gama) throws SQLException {
        gamaRepo.crearGama(gama);
    }

    @Override
    public List<GamaProducto> listarGamas() throws SQLException {
        List<GamaProducto> gamas = new ArrayList<>();
        gamas = gamaRepo.listarGamas();

        return gamas;
    }

    @Override
    public List<GamaProducto> listarGamasByURL() throws SQLException {
        List<GamaProducto> gamas = new ArrayList<>();
        gamas= gamaRepo.listarUrlImagenesGama();
        return gamas;
    }

    @Override
    public GamaProducto leerGama(String id) throws SQLException {
        GamaProducto gama = new GamaProducto();
        gama = gamaRepo.leerGama(id);
        return gama;
    }

    @Override
    public void actualizarGama(GamaProducto gama) throws SQLException {
        gamaRepo.actualizarGama(gama);
    }

    @Override
    public void eliminarGama(String id) throws SQLException {
        gamaRepo.eliminarGama(id);
    }
}
