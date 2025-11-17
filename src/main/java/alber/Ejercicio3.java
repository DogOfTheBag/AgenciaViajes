package alber;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        //creacion de ficheros JSON y XML, mappers y colecciones
        File clienteJSON = new File("Clientes.json");
        File clienteXML = new File("Clientes.xml");

        File viajesJSON = new File("Viajes.json");
        File viajesXML = new File("Viajes.xml");

        File datosJSON = new File("datos.json");
        File datosXML = new File("datos.xml");

        File reservasJSON = new File("Reservas.json");

        ObjectMapper mapperCliente = new ObjectMapper();
        ObjectMapper mapperViajes = new ObjectMapper();
        ObjectMapper mapperReservas = new ObjectMapper();
        ObjectMapper mapperDatos = new ObjectMapper();

        XmlMapper xmlMapperCliente = new XmlMapper();
        XmlMapper xmlMapperViaje = new XmlMapper();
        XmlMapper xmlMapperReservas = new XmlMapper();
        XmlMapper xmlMapperDatos = new XmlMapper();

        Reserva[] reservas = mapperReservas.readValue(reservasJSON,Reserva[].class);
        Map<Integer,Cliente> clientesMap = mapperCliente.readValue(clienteJSON, new TypeReference<Map<Integer, Cliente>>() {});
        Map<Integer,Viaje> viajesMap = mapperViajes.readValue(viajesJSON, new TypeReference<Map<Integer, Viaje>>() {});
        ArrayList<DatosReporte> informe = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int eleccion = 1;
        //hasta que no metamos un 0 no salimos
        while(eleccion != 0) {
            System.out.println("Introduzca un ID de viaje");
            eleccion = sc.nextInt();
            /*Creamos una lista cada vez que metamos un viaje para que no se mezclen datos de clientes entre viajes*/
            ArrayList<Cliente> clientes = new ArrayList<>();
            if(eleccion == 0) break; //si es 0 salimos
            /*Recorremos todos los viajes hasta que encontremos el que hemos introducido*/
            for (Viaje v : viajesMap.values()) {
                if (eleccion == v.getId()) {
                    for (Reserva r : reservas) {
                        //si el viaje existe, comprobamos desde las reservas que clientes tienen una a ese viaje
                        Cliente c = clientesMap.get(r.getIdCliente());
                        if (c == null)
                            continue;
                        if (v.getId() == r.getIdViaje()) {
                            clientes.add(c);
                        }
                    }
                    //creamos el reporte que imprimiremos por pantalla y en ficheros
                    DatosReporte d = new DatosReporte(v.getId(), v.getDescripcion(), v.getViajeros(), clientes);
                    informe.add(d);
                    System.out.println("Datos correctamente introducidos");
                }
            }
        }


        mapperDatos.writerWithDefaultPrettyPrinter().writeValue(datosJSON,informe);
        System.out.println(mapperDatos.writerWithDefaultPrettyPrinter().writeValueAsString(informe) + "\n");
        xmlMapperDatos.writerWithDefaultPrettyPrinter().writeValue(datosXML,informe);
        System.out.println(xmlMapperDatos.writerWithDefaultPrettyPrinter().writeValueAsString(informe));


    }
}
