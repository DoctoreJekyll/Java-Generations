package servicios;

import modelos.GamaProducto;

import java.sql.SQLException;
import java.util.List;

public interface IGamaProducto {
    public void crearGama(GamaProducto gama) throws SQLException;
    public List<GamaProducto> listarGamas() throws SQLException;
    public List<GamaProducto> listarGamasByURL() throws SQLException;
    public GamaProducto leerGama(String id) throws SQLException;
    public void actualizarGama(GamaProducto gama) throws SQLException;
    public void eliminarGama(String id) throws SQLException;
}
