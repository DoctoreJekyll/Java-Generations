package org.generations.repository;

import org.generations.model.Oficina;
import org.generations.util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OficinaRepository {

    //Creamos la query o querys
    private static final String SELECT_OFICINAS = "SELECT * FROM oficina";

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
                oficina.setCodigoOficina(resultSet.getString("codigo_oficina"));
                oficina.setCiudad(resultSet.getString("ciudad"));
                oficina.setPais(resultSet.getString("pais"));
                oficina.setLineaDireccion1(resultSet.getString("linea_direccion1"));
                oficina.setLineaDireccion2(resultSet.getString("linea_direccion2"));
                oficina.setRegion(resultSet.getString("region"));

                oficinas.add(oficina);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return oficinas;
    }




}
