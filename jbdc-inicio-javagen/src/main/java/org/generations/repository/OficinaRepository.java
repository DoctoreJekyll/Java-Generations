package org.generations.repository;

import org.generations.model.Oficina;
import org.generations.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OficinaRepository {

    //Creamos la query o querys
    private final String SELECT_OFICINAS = "SELECT * FROM oficina";

    //Creamos la conexion
    private Connection getConnection() throws SQLException {
        return DBConnection.connection();
    }

    //Creamos el Statement poara hacer las consultas
    private Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }

    //Generamos el primer metodo donde vamos a sacar todos los datos de la tabla oficinas
    //Dada nuestra query
    public List<Oficina> getOficinas(){
        //Creamos la lista para rellenarla
        List<Oficina> oficinas = new ArrayList<>();

        //Hacemos el try con resources usando nuestros metodos anteriores
        try(Statement statement = getStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_OFICINAS))
        {
            while (resultSet.next()) {
                //Rellenamos la informacion creando un nuevo objeto que añadiremos a nuestra lsita
                Oficina oficina = new Oficina();
                loadOficina(oficina, resultSet);

                oficinas.add(oficina);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return oficinas;
    }

    public Optional<Oficina> readOficina(String id) {
        String query = "SELECT * FROM oficina WHERE codigo_oficina = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Oficina oficina = new Oficina();
                loadOficina(oficina, rs);
                return Optional.of(oficina);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private void loadOficina(Oficina oficina, ResultSet resultSet) throws SQLException {
        oficina.setCodigoOficina(resultSet.getString("codigo_oficina"));
        oficina.setCiudad(resultSet.getString("ciudad"));
        oficina.setPais(resultSet.getString("pais"));
        oficina.setRegion(resultSet.getString("region"));
        oficina.setCodigoPostal(resultSet.getString("codigo_postal"));
        oficina.setTelefono(resultSet.getString("telefono"));
        oficina.setLineaDireccion1(resultSet.getString("linea_direccion1"));
        oficina.setLineaDireccion2(resultSet.getString("linea_direccion2"));
    }

    public void createOficina(Oficina oficina) {
        String query = "INSERT INTO oficina (codigo_oficina, ciudad, pais, region, codigo_postal, telefono, linea_direccion1, linea_direccion2) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, oficina.getCodigoOficina());
            statement.setString(2, oficina.getCiudad());
            statement.setString(3, oficina.getPais());
            statement.setString(4, oficina.getRegion());
            statement.setString(5, oficina.getCodigoPostal());
            statement.setString(6, oficina.getTelefono());
            statement.setString(7, oficina.getLineaDireccion1());
            statement.setString(8, oficina.getLineaDireccion2());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void updateOficina(Oficina oficina) {
        String query = "UPDATE oficina SET ciudad = ?, pais = ?, region = ?, codigo_postal = ?, telefono = ?, linea_direccion1 = ?, linea_direccion2 = ? WHERE codigo_oficina = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, oficina.getCiudad());
            statement.setString(2, oficina.getPais());
            statement.setString(3, oficina.getRegion());
            statement.setString(4, oficina.getCodigoPostal());
            statement.setString(5, oficina.getTelefono());
            statement.setString(6, oficina.getLineaDireccion1());
            statement.setString(7, oficina.getLineaDireccion2());
            statement.setString(8, oficina.getCodigoOficina());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteOficina(String codigo) {
        String query = "DELETE FROM oficina WHERE codigo_oficina = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
