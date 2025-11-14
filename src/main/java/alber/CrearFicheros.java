package alber;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CrearFicheros {

    private static final String VIAJES_JSON = "Viajes.json";
    private static final String CLIENTES_JSON = "Clientes.json";
    private static final String RESERVAS_JSON = "Reservas.json";
    private static final String VIAJES_XML = "Viajes.xml";
    private static final String CLIENTES_XML = "Clientes.xml";
    private static final String RESERVAS_XML = "Reservas.xml";

    public static void main(String[] args) throws IOException {
        Viaje[] viajes = llenarViajes();
        Cliente[] clientes = llenarClientes();
        Reserva[] reservas = llenarReservas();

        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();


        //Código para crear los ficheros correspondientes
		jsonMapper.writerWithDefaultPrettyPrinter().writeValue((new File(VIAJES_JSON)),viajes);
		jsonMapper.writerWithDefaultPrettyPrinter().writeValue((new File(CLIENTES_JSON)),clientes);
		jsonMapper.writerWithDefaultPrettyPrinter().writeValue((new File(RESERVAS_JSON)),reservas);
		xmlMapper.writerWithDefaultPrettyPrinter().writeValue((new File(VIAJES_XML)),viajes);
		xmlMapper.writerWithDefaultPrettyPrinter().writeValue((new File(CLIENTES_XML)),clientes);
		xmlMapper.writerWithDefaultPrettyPrinter().writeValue((new File(RESERVAS_XML)),reservas);

    }

    private static Viaje[] llenarViajes() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String f1 = LocalDate.of(2025, 8, 1).format(formato);
		String f2 = LocalDate.of(2025, 8, 10).format(formato);
		String f3 = LocalDate.of(2025, 8, 20).format(formato);
		String f4 = LocalDate.of(2025, 9, 1).format(formato);
		String f5 = LocalDate.of(2025, 9, 15).format(formato);
		String f6 = LocalDate.of(2025, 9, 25).format(formato);

        Viaje[] v = new Viaje[18];

		v[0] = new Viaje(14, "Alemania Oeste", f1, 1500, 7, 0);
		v[1] = new Viaje(16, "China Gran Muralla", f6, 2100, 10, 0);
		v[2] = new Viaje(18, "Croacia, Perla del Adriático", f1, 1100, 7, 0);
		v[3] = new Viaje(20, "Crucero por el mar Mediterráneo", f1, 1340, 11, 0);
		v[4] = new Viaje(22, "Cuba y Miami", f5, 900, 7, 0);
		v[5] = new Viaje(26, "Moscu San Petersburgo", f2, 1900, 7, 0);
		v[6] = new Viaje(28, "Noruega Mágica", f3, 2400, 9, 0);
		v[7] = new Viaje(30, "Paises Bajos", f2, 1100, 7, 0);
		v[8] = new Viaje(32, "Praga, Viena, Budapest", f3, 1500, 7, 0);
		v[9] = new Viaje(34, "Costa Brava", f4, 650, 5, 0);
		v[10] = new Viaje(35, "Costa de Almeria", f5, 600, 7, 0);
		v[11] = new Viaje(45, "Paris romántico", f1, 1200, 7, 0);
		v[12] = new Viaje(36, "Extremadura al completo", f6, 500, 6, 0);
		v[13] = new Viaje(37, "Galicia Costa da Morte", f2, 1100, 10, 0);
		v[14] = new Viaje(38, "Huelva", f3, 800, 7, 0);
		v[15] = new Viaje(39, "Oropesa del Mar con balneario", f4, 1400, 8, 0);
		v[16] = new Viaje(40, "Zaragoza y Teruel", f2, 450, 4, 0);
		v[17] = new Viaje(24, "La Toscana", f4, 800, 5, 0);
        return v;
    }

    private static Cliente[] llenarClientes() {
        Cliente[] c = new Cliente[12];
		c[0] = new Cliente(10, "Maria Sanz", 0, 0);
		c[1] = new Cliente(15, "Pedro Martin", 0, 0);
		c[2] = new Cliente(22, "Maria Sanchez", 0, 0);
		c[3] = new Cliente(18, "Maria Jose Perez", 0, 0);
		c[4] = new Cliente(19, "Jesus Rodriguez", 0, 0);
		c[5] = new Cliente(11, "Fernando Alia", 0, 0);
		c[6] = new Cliente(1, "Alicia Sanz", 0, 0);
		c[7] = new Cliente(2, "Raquel Martinez", 0, 0);
		c[8] = new Cliente(4, "Dora Suela", 0, 0);
		c[9] = new Cliente(5, "Julio Reyes", 0, 0);
		c[10] = new Cliente(33, "Manuela Hidalgo", 0, 0);
		c[11] = new Cliente(12, "Daniel Sanchez", 0, 0);
        return c;
    }

    private static Reserva[] llenarReservas() {
        Reserva[] r = new Reserva[32];
		// id viaje idcliente
	    r[0] = new Reserva(14,10,2);		
	    r[1] = new Reserva(14,15,2);		
		r[2] = new Reserva(14,12,1);		
		r[3] = new Reserva(14,18,4);
		
		r[4] = new Reserva(16,1,2);		
		r[5] = new Reserva(16,2,3);		
		r[6] = new Reserva(16,15,1);		
		r[7] = new Reserva(16,10,2);		
		r[8] = new Reserva(16,4,4);
		
		r[9] = new Reserva(20,1,2);		
		r[10] = new Reserva(20,2,1);		
		r[11] = new Reserva(20,11,2);		
		r[12] = new Reserva(20,4,1);		
		r[13] = new Reserva(20,5,3);
		
		r[14] = new Reserva(37,2,1);		
		r[15] = new Reserva(37,1,3);		
		r[16] = new Reserva(37,10,1);
		
		r[17] = new Reserva(24,2,2);		
		r[18] = new Reserva(24,1,2);		
		r[19] = new Reserva(24,11,5);		
		r[20] = new Reserva(24,4,1);		
		r[21] = new Reserva(24,5,2);		
		r[22] = new Reserva(24,10,1);		
		r[23] = new Reserva(24,15,3);		
		r[24] = new Reserva(24,12,2);		
		r[25] = new Reserva(24,18,1);
		
		r[26] = new Reserva(37,5,2);
		
		r[27] = new Reserva(38,5,3);
		
		r[28] = new Reserva(22,5,2);
		
		// PARA ERRORES. crear registros que no existen
		r[29] = new Reserva(138,5,2);
		
		r[30] = new Reserva(220,55,1);
		
		r[31] = new Reserva(30,55,1);
        return r;
    }
}


