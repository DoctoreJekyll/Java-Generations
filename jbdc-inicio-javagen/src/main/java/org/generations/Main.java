package org.generations;


import org.generations.model.Empleado;
import org.generations.model.Oficina;
import org.generations.repository.EmpleadoRepository;
import org.generations.repository.OficinaRepository;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //Para acceder a empleadorepo tenemos que "inyectar", tenemos que hacer inyeccion de dependencias
        //Creamos empleadorepository y le pasamos a la clase empleado para que pueda acceder a la base de datos
        EmpleadoRepository empleadoRepository = new EmpleadoRepository();

        //Obtenemos todos los empleados
        List<Empleado> empleadoList = empleadoRepository.getEmpleados();
        for (Empleado e : empleadoList)
        {
            System.out.println(e.toString());
        }

        System.out.println("////////////////EMPLEADO UNICO ////////////////////////");
        //Leemos un empleado concreto
        Optional<Empleado> empleado = empleadoRepository.readEmpleado(3);
        System.out.println(empleado.toString());


        System.out.println("////////////////OFICINAS////////////////////////");

        //Inyeccion dependencia oficina
        OficinaRepository oficinaRepository = new OficinaRepository();
        //Creamos lista para llenar de nuestros datos dado la inyheccion del repo
        List<Oficina> oficinaList = oficinaRepository.getOficinas();

        //Imprimimos todos los datos de la lista(Importante revisar que tenemos un toString en nuestra clase)
        for (Oficina o : oficinaList){
            System.out.println(o.toString());
        }
    }
}