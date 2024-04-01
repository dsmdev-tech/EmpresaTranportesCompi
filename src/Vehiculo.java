import java.time.LocalDate;

public class Vehiculo {

    protected String matricula;
    protected String modelo;
    protected String marca;
    protected int kmRecorridos;
    protected int precioDia;
    protected TipoMotor tipomotor;
    //Dias alquilados
    protected int diasAlquilados;
    protected LocalDate fechaInicioAlquiler;
    protected  Cliente miCliente;
    //protected Cliente micliente;
    //Cambiar el string por cliente me garantiza tener la referencia

    public Vehiculo(String matricula, String modelo, String marca, int kmRecorridos, int precioDia, TipoMotor tipomotor) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.kmRecorridos = kmRecorridos;
        this.precioDia = precioDia;
        this.tipomotor = tipomotor;
        diasAlquilados = 0;
        //dniCliente = "";
        miCliente = null;
        fechaInicioAlquiler = null;
    }

    public int getDiasAlquilados() {
        return diasAlquilados;
    }

    public void setDiasAlquilados(int diasAlquilados) {
        this.diasAlquilados = diasAlquilados;
    }

    public TipoMotor getTipomotor() {
        return tipomotor;
    }

    public LocalDate getFechaInicioAlquiler() {
        return fechaInicioAlquiler;
    }

    public void setFechaInicioAlquiler(LocalDate fechaInicioAlquiler) {
        this.fechaInicioAlquiler = fechaInicioAlquiler;
    }

    public Cliente getMiCliente() {
        return miCliente;
    }

    public void setMiCliente(Cliente miCliente) {
        this.miCliente = miCliente;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", kmRecorridos=" + kmRecorridos +
                ", precioDia=" + precioDia +
                ", tipomotor=" + tipomotor +
                ", diasAlquilados=" + diasAlquilados +
                ", fechaInicioAlquiler=" + fechaInicioAlquiler +
                ", miCliente=" + miCliente +
                '}';
    }
}
