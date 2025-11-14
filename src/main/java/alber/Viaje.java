package alber;

public class Viaje {
    private int id;
    private String descripcion;
    private String fechaSalida;
    private double pvp;
    private int dias;
    private int viajeros;

    public Viaje(int id, String descripcion, String fechaSalida, double pvp, int dias, int viajeros) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaSalida = fechaSalida;
        this.pvp = pvp;
        this.dias = dias;
        this.viajeros = viajeros;
    }

    public Viaje(int id, String descripcion, String fechaSalida, double pvp) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaSalida = fechaSalida;
        this.pvp = pvp;
        this.dias = 0;
        this.viajeros = 0;
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
}
