package alber;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class DatosReporte {
    /*id viaje, descripcionViaje, numViajeros, list Clientes*/
    //clase auxiliar para exportar los datos en el informe del tercer ejercicio.

    @JsonProperty("ID Viaje")
    int idViaje;
    @JsonProperty("Descripcion Viaje")
    String descViaje;
    @JsonProperty("Numero de viajeros")
    int numViajeros;
    @JsonProperty("Clientes")
    ArrayList<Cliente> clientes;

    public DatosReporte(int idViaje, String descViaje, int numViajeros, ArrayList<Cliente> clientes) {
        this.idViaje = idViaje;
        this.descViaje = descViaje;
        this.numViajeros = numViajeros;
        this.clientes = clientes;
    }

    public DatosReporte() {
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public String getDescViaje() {
        return descViaje;
    }

    public void setDescViaje(String descViaje) {
        this.descViaje = descViaje;
    }

    public int getNumViajeros() {
        return numViajeros;
    }

    public void setNumViajeros(int numViajeros) {
        this.numViajeros = numViajeros;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}
