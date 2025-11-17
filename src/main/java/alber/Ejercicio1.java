package alber;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ejercicio1 {


    public static void main(String[] args) throws IOException {
        //arhcivos, mappers, colecciones...
        File clienteJSON = new File("Clientes.json");
        File clienteXML = new File("Clientes.xml");
        File viajesJSON = new File("Viajes.json");
        File viajesXML = new File("Viajes.xml");
        File reservasJSON = new File("Reservas.json");
        ObjectMapper mapperCliente = new ObjectMapper();
        ObjectMapper mapperViajes = new ObjectMapper();
        ObjectMapper mapperReservas = new ObjectMapper();
        XmlMapper xmlMapperCliente = new XmlMapper();
        XmlMapper xmlMapperViaje = new XmlMapper();

        Reserva[] reservas = mapperReservas.readValue(reservasJSON,Reserva[].class);

        Map<Integer,Cliente> clientesMap = mapperCliente.readValue(clienteJSON, new TypeReference<Map<Integer, Cliente>>() {});
        Map<Integer,Viaje> viajesMap = mapperViajes.readValue(viajesJSON, new TypeReference<Map<Integer, Viaje>>() {});

        for (Reserva r : reservas) {
            /*para esto hemos hecho los maps, para poder buscar clientes y viajes por id mas facilmente*/
            Viaje v = viajesMap.get(r.getIdViaje());
            Cliente c = clientesMap.get(r.getIdCliente());

            //en caso de que no exista alguna de las dos chapamos para evitar errores
            if(v == null || c == null){
                if (v == null)
                    System.out.println("No existe el viaje con ID: " + r.getIdViaje());
                if(c == null)
                    System.out.println("No existe el cliente con ID: " + r.getIdCliente());
                continue;
            }

            //añadimos los viajeros de la reserva al viaje
            v.setViajeros(v.getViajeros() + r.getPlazas());
            //añadimos al cliente que ha reservado un viaje al contador
            c.setViajesContratados(c.getViajesContratados() + 1);
            //precio total = numPlazas * precio de plaza
            double importeAdicional = v.getPvp() * r.getPlazas();
            c.setImporteTotal(c.getImporteTotal() + importeAdicional);
        }

        mapperCliente.writerWithDefaultPrettyPrinter().writeValue(clienteJSON,clientesMap);
        mapperCliente.writerWithDefaultPrettyPrinter().writeValue(viajesJSON,viajesMap);

        xmlMapperCliente.writerWithDefaultPrettyPrinter().writeValue(clienteXML,clientesMap);
        xmlMapperViaje.writerWithDefaultPrettyPrinter().writeValue(viajesXML,viajesMap);
    }

}
