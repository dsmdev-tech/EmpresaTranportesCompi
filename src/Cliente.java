public class Cliente {
    private String nombre, apellidos, email, dni;
    private int telefono;
    private double tarjetaCredito;

    public Cliente(String nombre, String apellidos, String email, String dni, int telefono, double tarjetaCredito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getDni() {
        return dni;
    }
}
