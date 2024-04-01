import java.time.Period;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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

    public boolean alquilarVehiculoCliente(String matricula, String dni, int diasAlquilados, LocalDate fechaDeInicio){
        //Necesitamos dias alquilados y fecha de inicio
        Vehiculo v = existeVehiculo(matricula);
        //LocalDate fechaInicioAlquiler = LocalDate.now();

        if(v != null && misClientes.containsKey(dni)){
            if(v.getDiasAlquilados() == 0){
                v.setDiasAlquilados(diasAlquilados);
                v.setFechaInicioAlquiler(fechaDeInicio);
                v.setMiCliente(misClientes.get(dni));
                //v.setDniCliente(dni);
                return true;
            }
            return false;
        }
        return false;
    }

    public Coche[] listaCoches(int plazas, TipoMotor tipoMotor) {
        //Poner arraylist y devolver array
        ArrayList<Coche> coche = new ArrayList<>();
        //Vehiculo[] veh = new Vehiculo[misVehiculos.size()];
        //int j=0;
        for (int i=0; i< misVehiculos.size(); i++) {
            if(misVehiculos.get(i) instanceof Coche) {
                if (((Coche) misVehiculos.get(i)).getPlazasMax() >= plazas && (misVehiculos.get(i)).getTipomotor() == tipoMotor) {
                    coche.add((Coche) misVehiculos.get(i));
                    //veh[j] = misVehiculos.get(i);
                    //j++;
                }
            }
        }
        Coche[] arrayCoches = new Coche[coche.size()];
        arrayCoches = coche.toArray(arrayCoches);
        return arrayCoches;
    }

    public Furgon[] listaFurgon(int cargaMax, int  plazasAsiento) {
        //Poner arraylist y devolver array
        //Vehiculo[] veh = new Vehiculo[misVehiculos.size()];
        ArrayList<Furgon> furgon = new ArrayList<>();
        //int j =0;
        for (int i=0; i< misVehiculos.size(); i++) {
            if(misVehiculos.get(i) instanceof Furgon) {
                if (((Furgon) misVehiculos.get(i)).getPlazasAsiento() >= plazasAsiento &&  ((Furgon) misVehiculos.get(i)).getCargaMax() >= cargaMax) {
                    furgon.add((Furgon) misVehiculos.get(i));
                    //veh[j] = misVehiculos.get(i);
                    //j++;
                }
            }
        }
        Furgon[] arrayFurgon = new Furgon[furgon.size()];
        arrayFurgon = furgon.toArray(arrayFurgon);
        return arrayFurgon;
    }

    public Camion[] listaCamiones(int cargaMax, int longitud) {
        //Poner arraylist y devolver array
        //Vehiculo[] veh = new Vehiculo[misVehiculos.size()];
        ArrayList<Camion> camion = new ArrayList<>();
        //int j =0;
        for (int i=0; i< misVehiculos.size(); i++) {
            if(misVehiculos.get(i) instanceof Camion) {
                if (((Camion) misVehiculos.get(i)).getCargaMax() >= cargaMax && ((Camion) misVehiculos.get(i)).getLonguitud() >= longitud) {
                    camion.add((Camion) misVehiculos.get(i));
                    //veh[j] = misVehiculos.get(i);
                    //j++;
                }
            }
        }
        Camion[] arrayCamion = new Camion[camion.size()];
        arrayCamion = camion.toArray(arrayCamion);
        return arrayCamion;
    }

    public float price(String matricula, String dni, int kmRecorridos) {
        Vehiculo v = existeVehiculo(matricula);
        long diasExtra = 0;
        float precioExtra = 0;
        float precio = 0;

        if (v != null) {
            // Obtenemos la fecha actual
            LocalDate fechaEntrega = LocalDate.now();
            LocalDate fechaInicioAlquiler = v.getFechaInicioAlquiler();

            v.kmRecorridos += kmRecorridos;

            if (kmRecorridos > 500) {
                precio = (float) (v.precioDia * v.getDiasAlquilados() * 1.20);
            } else {
                precio = (float) (v.precioDia * v.getDiasAlquilados());
            }

            // Calculamos los días extra
            diasExtra = ChronoUnit.DAYS.between(fechaInicioAlquiler, fechaEntrega) - v.getDiasAlquilados();

            //Period periodo = Period.between(fechaInicioAlquiler, fechaEntrega);
            //diasExtra = periodo.getDays() - diasAlquilados;

            if (diasExtra > 0) {
                precioExtra = (float) (diasExtra * v.precioDia * 1.50);
                precio += precioExtra;
            }
        }

        v.setDiasAlquilados(0);
        v.setMiCliente(null);

        return precio;
    }


}