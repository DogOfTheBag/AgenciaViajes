package alber;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Viaje {
    @JsonProperty("ID")
    private int id;
    @JsonProperty("Descripcion")
    private String descripcion;
    @JsonProperty("Fecha Salida")
    private String fechaSalida;
    @JsonProperty("Precio")
    private double pvp;
    @JsonProperty("Dias")
    private int dias;
    @JsonProperty("Numero de viajeros")
    private int viajeros;

    public Viaje(int id, String descripcion, String fechaSalida, double pvp, int dias, int viajeros) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaSalida = fechaSalida;
        this.pvp = pvp;
        this.dias = dias;
        this.viajeros = viajeros;
    }

    public Viaje() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getViajeros() {
        return viajeros;
    }

    public void setViajeros(int viajeros) {
        this.viajeros = viajeros;
    }

    @Override
    public String toString() {
        return "Viaje: " + id +
                ", descripcion: '" + descripcion +  "', Numero de viajeros: " + viajeros;
    }
}
