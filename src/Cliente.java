public class Cliente {
    private String nombre, apellidos, email, dni;
    private int telefono;
    //hacer String el telefono
    private double tarjetaCredito;
    //hacer String la tarjeta de credito

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

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono=" + telefono +
                ", tarjetaCredito=" + tarjetaCredito +
                '}';
    }
}
