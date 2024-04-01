public class Furgon extends Vehiculo{

    private int cargaMax;
    private int plazasAsiento;


    public Furgon(String matricula, String modelo, String marca, int kmRecorridos, int precioDia, TipoMotor tipomotor, int cargaMax, int plazasAsiento) {
        super(matricula, modelo, marca, kmRecorridos, precioDia, tipomotor);
        this.cargaMax = cargaMax;
        this.plazasAsiento = plazasAsiento;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getPlazasAsiento() {
        return plazasAsiento;
    }

    public void setPlazasAsiento(int plazasAsiento) {
        this.plazasAsiento = plazasAsiento;
    }
}
