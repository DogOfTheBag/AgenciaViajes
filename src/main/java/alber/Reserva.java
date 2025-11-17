package alber;

public class Reserva {
    private int idViaje;
    private int idCliente;
    private int plazas;

    public Reserva(int idViaje, int idCliente, int plazas) {
        this.idViaje = idViaje;
        this.idCliente = idCliente;
        this.plazas = plazas;
    }

    public Reserva() {
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
}
