package alber;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {
        /*Cositas para guardar la tabla en un archivo txt*/
        File archivoSalida = new File("viajes.txt");
        FileWriter writer = new FileWriter(archivoSalida);
        writer.write(generarTablaDatos());
        writer.flush();
        writer.close();
        System.out.println(generarTablaDatos());
    }

    public static String generarTablaDatos() throws IOException {
        File viajesJSON = new File("Viajes.json");
        ObjectMapper mapperViajes = new ObjectMapper();
        Map<Integer,Viaje> viajesMap = mapperViajes.readValue(viajesJSON, new TypeReference<Map<Integer, Viaje>>() {});

        //podriamos pasar el mapa a una lista y hacer sort con un comparador de enteros

        /*Vamos a hacer un StringBuilder para que sea mas sencillo juntar cosas y luego devolverle todo junto con toString*/
        StringBuilder sb = new StringBuilder();

        /*Podemos hacer String.format para darle espacios automaticamente a campos, si quieres ampliar algun campo respectivamente
        * cambia los numeros del campo que corresponda*/
        String cabecera = String.format("%-5s %-35s %-12s %-10s %-5s", "ID", "DESCRIPCION", "FECHA", "VIAJEROS", "DIAS");
       //lineSeparator es el separador de línea estandar del sistema, como \n pero ajustandose a cada sistema operativo
        sb.append(cabecera).append(System.lineSeparator());

        //quiza aqui pudiese hacer un .length de la cadena de antes y cambiar automaticamente lo largo de la barra
        String lineaHorizontal = "-------------------------------------------------------------------------";

        sb.append(lineaHorizontal).append(System.lineSeparator());
        for (Viaje v : viajesMap.values()) {
            //lo mismo de antes pero con barras, cogiendo los datos de los viajes
            sb.append("|");
            String linea = String.format("%-5d %-35s %-12s %-10d %-5d", v.getId(), v.getDescripcion(), v.getFechaSalida(), v.getViajeros(), v.getDias()
            );
            sb.append(linea).append("|").append(System.lineSeparator());
        }
        sb.append(lineaHorizontal).append(System.lineSeparator());
        return sb.toString();
    }
}
