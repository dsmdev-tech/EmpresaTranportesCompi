public class Vehiculo {

    protected String matricula;
    protected String modelo;
    protected String marca;
    protected int kmRecorridos;
    protected int precioDia;
    protected TipoMotor tipomotor;
    //Dias alquilados
    protected int diasAlquilados;
    protected String dniCliente;

    public Vehiculo(String matricula, String modelo, String marca, int kmRecorridos, int precioDia, TipoMotor tipomotor) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.kmRecorridos = kmRecorridos;
        this.precioDia = precioDia;
        this.tipomotor = tipomotor;
        diasAlquilados = 0;
        dniCliente = "";
    }

    public int getDiasAlquilados() {
        return diasAlquilados;
    }

    public void setDiasAlquilados(int diasAlquilados) {
        this.diasAlquilados = diasAlquilados;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public TipoMotor getTipomotor() {
        return tipomotor;
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
                ", dniCliente='" + dniCliente + '\'' +
                '}';
    }
}
