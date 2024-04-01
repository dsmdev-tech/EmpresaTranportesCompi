public class Coche extends Vehiculo{

    private int plazasMax;
    private int puertas;
    private int Maletero;
    private TipoCoche tipo;


    public Coche(String matricula, String modelo, String marca, int kmRecorridos, int precioDia, TipoMotor tipomotor, int plazasMax, int puertas, int maletero, TipoCoche tipo) {
        super(matricula, modelo, marca, kmRecorridos, precioDia, tipomotor);
        this.plazasMax = plazasMax;
        this.puertas = puertas;
        Maletero = maletero;
        this.tipo = tipo;
    }

    public int getPlazasMax() {
        return plazasMax;
    }


}
