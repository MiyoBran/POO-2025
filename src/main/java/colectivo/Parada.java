package colectivo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Parada {
    private int id;
    private String direccion;
    private List<Pasajero> pasajerosEnLaParada;

    public Parada(int id, String direccion) {
        this.id = id;
        this.direccion = direccion;
        this.pasajerosEnLaParada = new ArrayList<>();
    }

    public void agregarPasajero(Pasajero pasajero) {
        this.pasajerosEnLaParada.add(pasajero);
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    // --- equals() y toString() ---
    @Override
    public String toString() {
        return "Parada [id=" + id + ", direccion=" + direccion + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Parada otra = (Parada) obj;
        return id == otra.id;
    }
}