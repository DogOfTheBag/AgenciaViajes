package alber;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "nombre", "viajes contratados", "Importe total"})
public class Cliente {
    @JsonProperty ("ID")
    private int id;
    @JsonProperty ("Nombre")
    private String nombre;
    @JsonProperty ("Viajes Contratados")
    private int viajesContratados;
    @JsonProperty ("Importe Total")
    private double importeTotal;

    public Cliente(int id, String nombre, int viajesContratados, double importeTotal) {
        this.id = id;
        this.nombre = nombre;
        this.viajesContratados = viajesContratados;
        this.importeTotal = importeTotal;
    }

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.viajesContratados = 0;
        this.importeTotal = 0;
    }

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getViajesContratados() {
        return viajesContratados;
    }

    public void setViajesContratados(int viajesContratados) {
        this.viajesContratados = viajesContratados;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    @Override
    public String toString() {
        return "Cliente " + id + ", de nombre '" + nombre + "'";
    }
}
