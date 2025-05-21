import java.util.ArrayList;

/**
 * Clase encargada de la interacción con el usuario, mostrando información.
 * @author Sofia Otero Gil
 */
public class View {
    /**
     * Muestra la velocidad de un coche en la consola.
     * @param matricula La matrícula del coche.
     * @param v La velocidad del coche.
     * @return true si la velocidad se mostró correctamente.
     */
    public boolean muestraVelocidad(String matricula, Integer v){
        System.out.println(matricula + ": " + v + "km/hr");
        return true;
    }

    /**
     * Muestra una lista de todos los coches presentes en el parking.
     * @param parking La lista de objetos Coche a mostrar.
     */
    public void mostrarTodosLosCoches(ArrayList<Coche> parking) {
        System.out.println("\n--- Coches en el parking ---");
        for (Coche coche : parking) {
            System.out.println("Modelo: " + coche.modelo + ", Matrícula: " + coche.matricula + ", Velocidad: " + coche.velocidad + "km/hr");
        }
        System.out.println("----------------------------");
    }
}
