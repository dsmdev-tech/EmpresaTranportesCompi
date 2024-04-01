import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    private static String op, s1, s2, s3;
    private static int s6, s8;
    private static double s10;
    private static TipoMotor s7;
    private static LocalDate fechaInicio;

    public static void main(String[] args) {

        // Creamos datos para simular la base de datos

        Empresa e = new Empresa("Daniels");
        Cliente cliente1 = new Cliente("Juan", "Pérez", "juan@example.com", "12345678A", 123456789, 1234567890);
        Cliente cliente2 = new Cliente("María", "González", "maria@example.com", "87654321B", 987654321, 658765421);
        Cliente cliente3 = new Cliente("Pedro", "Sánchez", "pedro@example.com", "56789012C", 567890123, 980123456);
        Cliente cliente4 = new Cliente("Laura", "Martínez", "laura@example.com", "34567890D", 345678901, 321321098);
        Cliente cliente5 = new Cliente("Ana", "López", "ana@example.com", "33", 901234567, 2109210987);
        e.addCliente(cliente1);
        e.addCliente(cliente2);
        e.addCliente(cliente3);
        e.addCliente(cliente4);
        e.addCliente(cliente5);
        Coche coche1 = new Coche("22", "Corsa", "Opel", 50000, 50, TipoMotor.GASOLINA, 5, 5, 300, TipoCoche.UTILITARIO);
        Coche coche2 = new Coche("5678XYZ", "Astra", "Opel", 70000, 60, TipoMotor.DIESEL, 5, 5, 350, TipoCoche.UTILITARIO);
        Coche coche3 = new Coche("9876ZYX", "Golf", "Volkswagen", 60000, 70, TipoMotor.ELECTRICO, 5, 5, 320, TipoCoche.BERLINA);
        Coche coche4 = new Coche("4321CBA", "Civic", "Honda", 80000, 65, TipoMotor.HIBRIDO, 5, 5, 310, TipoCoche.SUV);
        Coche coche5 = new Coche("2468DFG", "3 Series", "BMW", 55000, 80, TipoMotor.GASOLINA, 5, 5, 330, TipoCoche.MONOVOLUMEN);
        e.addVehiculo(coche1);
        e.addVehiculo(coche2);
        e.addVehiculo(coche3);
        e.addVehiculo(coche4);
        e.addVehiculo(coche5);
        Furgon furgon1 = new Furgon("1111AAA", "Transit", "Ford", 100000, 80, TipoMotor.DIESEL, 1500, 3);
        Furgon furgon2 = new Furgon("2222BBB", "Boxer", "Peugeot", 90000, 75, TipoMotor.GASOLINA, 1800, 2);
        Furgon furgon3 = new Furgon("3333CCC", "Sprinter", "Mercedes-Benz", 120000, 90, TipoMotor.ELECTRICO, 2000, 2);
        Furgon furgon4 = new Furgon("4444DDD", "Ducato", "Fiat", 95000, 70, TipoMotor.DIESEL, 1700, 2);
        Furgon furgon5 = new Furgon("5555EEE", "Jumper", "Citroen", 110000, 85, TipoMotor.HIBRIDO, 1900, 3);
        e.addVehiculo(furgon1);
        e.addVehiculo(furgon2);
        e.addVehiculo(furgon3);
        e.addVehiculo(furgon4);
        e.addVehiculo(furgon5);
        Camion camion1 = new Camion("6666TTT", "FH16", "Volvo", 200000, 150, TipoMotor.DIESEL, 20000, 10);
        Camion camion2 = new Camion("6789CVC", "Actros", "Mercedes-Benz", 180000, 140, TipoMotor.GASOLINA, 18000, 9);
        Camion camion3 = new Camion("6768CFH", "Stralis", "Iveco", 220000, 160, TipoMotor.DIESEL, 22000, 11);
        Camion camion4 = new Camion("4509BNM", "TGS", "MAN", 190000, 145, TipoMotor.HIBRIDO, 19000, 9);
        Camion camion5 = new Camion("6542GYZ", "Quon", "UD Trucks", 210000, 155, TipoMotor.ELECTRICO, 21000, 12);
        e.addVehiculo(camion1);
        e.addVehiculo(camion2);
        e.addVehiculo(camion3);
        e.addVehiculo(camion4);
        e.addVehiculo(camion5);
// Terminamos de introducir datos...


        boolean continuar = true;
        int teclado;

        while (continuar) {
            System.out.println("\n\n*****************************************************************");
            System.out.println("             MENÚ:\n");
            System.out.println("1. Dar de alta un vehículo");
            System.out.println("2. Dar de alta un cliente");
            System.out.println("3. Alquilar un vehículo para un cliente determinado");
            System.out.println("4. Mostrar una lista de vehículos");
            System.out.println("5. Entrega de vehículo");
            System.out.println("6. Salir");
            System.out.println("Selecciona una opción (1-6): ");
            System.out.println("\n*****************************************************************\n");
            teclado = Integer.parseInt(sc.nextLine());

            switch (teclado) {
                case 1:
                    System.out.println("\nHas seleccionado la opción 1. Dar de alta un vehículo");
                    e.addVehiculo(nuevoVehiculo());
                    System.out.println("\nEl vehículo ha sido dado de alta con éxito");
                    break;
                case 2:
                    System.out.println("\nHas seleccionado la opción 2. Dar de alta un cliente");
                    e.addCliente(nuevoCLiente());
                    System.out.println("\nEl cliente ha sido añadido correctamente");
                    break;
                case 3:
                    System.out.println("\nHas seleccionado la opción 3. Alquilar un vehículo para un cliente determinado");
                    alquilarVehiculo();
                    e.alquilarVehiculoCliente(op, s1, s6, fechaInicio);
                    System.out.println("\nVehiculo reservado correctamente");
                    break;
                case 4:
                    System.out.println("\nHas seleccionado la opción 4. Buscar producto por código");
                    boolean intWrong=true;
                    int i=0;
                    while (intWrong) {
                        System.out.println("\nElije una opción: ");
                        System.out.println("\n1. Buscar coche:");
                        System.out.println("\n2. Buscar furgón:");
                        System.out.println("\n3. Buscar camión:");
                        op = sc.nextLine();
                        Vehiculo[] veh;
                        if (op.equalsIgnoreCase("1")) {
                            listadoCoche();
                            veh = e.listaCoches(s6, s7);
                            System.out.println("\nEstos son los furgones disponibles: \n");
                            for (Vehiculo v : veh) {
                                if (v != null) {
                                    System.out.println(v);
                                }
                            }
                            veh = null;
                            intWrong = false;
                        } else if (op.equalsIgnoreCase("2")) {
                            listadoFurgon();
                            veh = e.listaFurgon(s6, s8);
                            System.out.println("\nEstos son los furgones disponibles: \n");
                            for (Vehiculo v : veh) {
                                if (v != null) {
                                    System.out.println(v);
                                }
                            }
                            //System.out.println(Arrays.toString(e.listaFurgon(s6, s8)));
                            veh = null;
                            intWrong = false;
                        } else if (op.equalsIgnoreCase("3")) {
                            listadoCamion();
                            veh = e.listaCamiones(s6, s8);
                            System.out.println("\nEstos son los caminones disponibles: \n");
                            for (Vehiculo v : veh) {
                                if (v != null) {
                                    System.out.println(v);
                                }
                            }
                            veh = null;
                            intWrong = false;
                        } else
                            System.out.println("\nOpción no válida. Por favor, selecciona una opción del 1 al 3.");
                        i++;
                    }
                    break;
                case 5:
                    System.out.println("\nHas seleccionado la opción 5. Entrega de vehículo");
                    precioAPagar();
                    float precioFinal = e.price(op, s3, s6);
                    System.out.println("\n\nEl precio a pagar es de " + precioFinal + " €");
                    break;
                case 6:
                    System.out.println("\nSaliendo del programa. ¡Hasta luego!");
                    continuar=false;
                    break;
                default:
                    System.out.println("\nOpción no válida. Por favor, selecciona una opción del 1 al 7.");
            }
        }
    }

    private static Vehiculo nuevoVehiculo() {
        Vehiculo nuevoVehiculo;

        System.out.print("\nEscribe la matricula del vehículo: ");
        op = sc.nextLine();
        System.out.print("\nEscribe el modelo del vehículo: ");
        s1 = sc.nextLine();
        System.out.print("\nEscribe la marca del vehículo: ");
        s2 = sc.nextLine();
        System.out.print("\nEscribe los kilometros del vehículo: ");
        s6 = Integer.parseInt(sc.nextLine());
        System.out.print("\nEscribe el precio diario del vehículo: ");
        s8 = Integer.parseInt(sc.nextLine());
        System.out.print("\nIndica el tipo de motor del vehículo: ");
        s7 = TipoMotor.valueOf(sc.nextLine());

        nuevoVehiculo = new Vehiculo(op, s1, s2, s6, s8, s7);
        return nuevoVehiculo;
    }

    private static Cliente nuevoCLiente() {
        Cliente nuevoCliente;

        System.out.print("\nEscribe el nombre del cliente: ");
        op = sc.nextLine();
        System.out.print("\nEscribe los apellidos del cliente: ");
        s1 = sc.nextLine();
        System.out.print("\nEscribe el correo electronico del cliente: ");
        s2 = sc.nextLine();
        System.out.print("\nEscribe el dni del cliente: ");
        s3 = sc.nextLine();
        System.out.print("\nEscribe el telefono de contacto del cliente: ");
        s6 = Integer.parseInt(sc.nextLine());
        System.out.print("\nIntroduce el número de la tarjeta del cliente: ");
        s10 = Integer.parseInt(sc.nextLine());

        nuevoCliente = new Cliente(op, s1, s2, s3, s6, s10);
        return nuevoCliente;
    }

    private static void alquilarVehiculo() {
        Cliente nuevoCliente;

        System.out.print("\nIntroduce la matricula del vehículo: ");
        op = sc.nextLine();
        System.out.print("\nIntroduce el dni del cliente: ");
        s1 = sc.nextLine();
        System.out.print("\nIntroduce los días que necesitas alquilar el coche: ");
        s6 = Integer.parseInt(sc.nextLine());
        System.out.print("\nIntroduce la fecha de inicio del alquiler (dd-MM-yyyy): ");
        fechaInicio = LocalDate.parse((sc.nextLine()), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    private static void listadoCoche() {
        System.out.print("\nIntroduce las plazas minimas que necesitas en el coche : ");
        s6 = Integer.parseInt(sc.nextLine());
        System.out.print("\nIntroduce el tipo de motor que deseas: ");
        System.out.print("ELECTRICO, HIBRIDO ENCHUFABLE, HIBRIDO, GASOLINA, DIESEL");
        //necesito pedir una opción de un enum
        s7 = TipoMotor.valueOf(sc.nextLine());
    }

    private static void listadoFurgon() {
        System.out.print("\nIntroduce la carga máxima que necesitas que soporte el furgón: ");
        s6 = Integer.parseInt(sc.nextLine());
        System.out.print("\nIntroduce las plazas que necesitas en el coche : ");
        s8 = Integer.parseInt(sc.nextLine());
    }

    private static void listadoCamion() {
        System.out.print("\nIntroduce la carga máxima que necesitas que soporte el camión: ");
        s6 = Integer.parseInt(sc.nextLine());
        System.out.print("\nIntroduce la longuitud del vehículo que necesitas: ");
        s8 = Integer.parseInt(sc.nextLine());
    }

    private static void precioAPagar() {
        System.out.print("\nEscribe la matricula del vehículo: ");
        op = sc.nextLine();
        System.out.print("\nEscribe el dni del cliente: ");
        s3 = sc.nextLine();
        System.out.print("\nIntroduce los kilometros recorridos: ");
        s6 = Integer.parseInt(sc.nextLine());
        System.out.print("\nIntroduce los días que ha sido alquilado el vehículo: ");
        s8 = Integer.parseInt(sc.nextLine());
    }

}