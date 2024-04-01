public class Camion extends Vehiculo{

    private int cargaMax;
    private int longuitud;

    public Camion(String matricula, String modelo, String marca, int kmRecorridos, int precioDia, TipoMotor tipomotor, int cargaMax, int longuitud) {
        super(matricula, modelo, marca, kmRecorridos, precioDia, tipomotor);
        this.cargaMax = cargaMax;
        this.longuitud = longuitud;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getLonguitud() {
        return longuitud;
    }

    public void setLonguitud(int longuitud) {
        this.longuitud = longuitud;
    }
}
