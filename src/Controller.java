import java.util.Scanner;

/**
 * Clase principal que actúa como el controlador de la aplicación.
 * Coordina la interacción entre la vista y el modelo, y maneja la lógica de la interfaz de usuario.
 * @author Sofia Otero Gil
 */
public class Controller {
    /**
     * Método principal donde comienza la ejecución de la aplicación.
     * Gestiona el menú de opciones para el usuario y delega las operaciones al modelo y la vista.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        View miView = new View();
        Model miModel = new Model();
        Scanner scanner = new Scanner(System.in);

        // Crear algunos coches iniciales para pruebas
        miModel.crearCoche("LaFerrari", "SBC 1234");
        miModel.crearCoche("Alpine", "HYU 4567");
        miModel.crearCoche("Aston Martin", "FGH 3333");

        int opcion;
        String matricula;
        int velocidad;
        Coche cocheEncontrado;

        do {
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("1. Crear coche");
            System.out.println("2. Aumentar velocidad");
            System.out.println("3. Disminuir velocidad");
            System.out.println("4. Mostrar todos los coches");
            System.out.println("5. Ver coche (por matrícula)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el modelo del coche: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese la matrícula del coche: ");
                    matricula = scanner.nextLine();
                    miModel.crearCoche(modelo, matricula);
                    System.out.println("Coche creado exitosamente.");
                    break;
                case 2:
                    System.out.print("Ingrese la matrícula del coche para aumentar velocidad: ");
                    matricula = scanner.nextLine();
                    System.out.print("Ingrese la cantidad a aumentar la velocidad: ");
                    velocidad = scanner.nextInt();
                    scanner.nextLine();
                    int nuevaVelocidadAumento = miModel.aumentarVelocidad(matricula, velocidad);
                    if (nuevaVelocidadAumento != -1) {
                        miView.muestraVelocidad(matricula, nuevaVelocidadAumento);
                    } else {
                        System.out.println("Coche con matrícula " + matricula + " no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la matrícula del coche para disminuir velocidad: ");
                    matricula = scanner.nextLine();
                    System.out.print("Ingrese la cantidad a disminuir la velocidad: ");
                    velocidad = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    int nuevaVelocidadDisminucion = miModel.disminuirVelocidad(matricula, velocidad);
                    if (nuevaVelocidadDisminucion != -1) {
                        miView.muestraVelocidad(matricula, nuevaVelocidadDisminucion);
                    } else {
                        System.out.println("Coche con matrícula " + matricula + " no encontrado.");
                    }
                    break;
                case 4:
                    miView.mostrarTodosLosCoches(Model.parking);
                    break;
                case 5:
                    System.out.print("Ingrese la matrícula del coche a ver: ");
                    matricula = scanner.nextLine();
                    cocheEncontrado = miModel.getCoche(matricula);
                    if (cocheEncontrado != null) {
                        System.out.println("--- Detalles del Coche ---");
                        System.out.println("Modelo: " + cocheEncontrado.modelo);
                        System.out.println("Matrícula: " + cocheEncontrado.matricula);
                        System.out.println("Velocidad: " + cocheEncontrado.velocidad + "km/hr");
                        System.out.println("--------------------------");
                    } else {
                        System.out.println("Coche con matrícula " + matricula + " no encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
