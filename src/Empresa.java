import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empresa {

    private String nombre;
    private List<Vehiculo> misVehiculos;
    private Map<String, Cliente> misClientes;

    public Empresa(String nombre) {
        this.nombre = nombre;
        misVehiculos = new ArrayList<>();
        misClientes = new HashMap<>();
    }

    public boolean addVehiculo(Vehiculo v) {
        if (v!= null) {
            if (existeVehiculo(v.matricula)==null) {
                misVehiculos.add(v);
                return true;
            }
        }
        return false;
    }



    public Vehiculo existeVehiculo(String matricula) {

        for (Vehiculo v2 : misVehiculos) {
            if (v2.matricula.equals(matricula)) {
                    return v2;
            }
        }
            return null;
    }

    public boolean addCliente(Cliente c){
        if(c != null){
            if(!misClientes.containsKey(c.getDni())){
                misClientes.put(c.getDni(), c);
            }
        }
        return false;
    }

    public boolean alquilarVehiculoCliente(String matricula, String dni, int diasAlquilados){
        //Necesitamos dias alquilados y fecha de inicio
        Vehiculo v = existeVehiculo(matricula);

        if(v != null && misClientes.containsKey(dni)){
            if(v.getDiasAlquilados() == 0){
                v.setDiasAlquilados(diasAlquilados);
                v.setDniCliente(dni);
                return true;
            }
            return false;
        }
        return false;
    }

    public Vehiculo[] listaCoches(int plazas, TipoMotor tipoMotor) {

        Vehiculo[] veh = new Vehiculo[misVehiculos.size()];
        int j=0;
        for (int i=0; i< misVehiculos.size(); i++) {
            if(misVehiculos.get(i) instanceof Coche) {
                if (((Coche) misVehiculos.get(i)).getPlazasMax() >= plazas && (misVehiculos.get(i)).getTipomotor() == tipoMotor) {
                    veh[j] = misVehiculos.get(i);
                    j++;
                }
            }
        }
        return veh;
    }

    public Vehiculo[] listaFurgon(int cargaMax, int  plazasAsiento) {

        Vehiculo[] veh = new Vehiculo[misVehiculos.size()];
        int j =0;
        for (int i=0; i< misVehiculos.size(); i++) {
            if(misVehiculos.get(i) instanceof Furgon) {
                if (((Furgon) misVehiculos.get(i)).getPlazasAsiento() >= plazasAsiento &&  ((Furgon) misVehiculos.get(i)).getCargaMax() >= cargaMax) {
                    veh[j] = misVehiculos.get(i);
                    j++;
                }
            }
        }
        return veh;
    }

    public Vehiculo[] listaCamiones(int cargaMax, int longitud) {

        Vehiculo[] veh = new Vehiculo[misVehiculos.size()];
        int j =0;
        for (int i=0; i< misVehiculos.size(); i++) {
            if(misVehiculos.get(i) instanceof Camion) {
                if (((Camion) misVehiculos.get(i)).getCargaMax() >= cargaMax && ((Camion) misVehiculos.get(i)).getLonguitud() >= longitud) {
                    veh[j] = misVehiculos.get(i);
                    j++;
                }
            }
        }
        return veh;
    }

    public float price(String matricula, String dni, int kmRecorridos, float diasAlquilados) {
        Vehiculo v = existeVehiculo(matricula);
        float precio=0;
        if (v !=null) {
            //if (v.dniCliente.equals(dni)) {
                v.kmRecorridos += kmRecorridos;
                if(kmRecorridos > 500) {
                    precio = (float) (v.precioDia*diasAlquilados*1.20);
                } else {
                    precio = (float) v.precioDia*diasAlquilados;
                }
           // }
        }
        v.setDiasAlquilados(0);
        v.setDniCliente("");

        return precio;
    }


}