import java.util.ArrayList;

/**
 * Clase encargada de manejar los datos y la lógica de negocio de los coches.
 * Almacena y gestiona la colección de objetos Coche.
 * @author Sofia Otero Gil
 */
public class Model {
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un nuevo coche y lo añade a la colección de coches en el parking.
     * @param modelo El modelo del coche a crear.
     * @param matricula La matrícula única para el coche.
     * @return El objeto Coche recién creado.
     */
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca un coche en la colección por su matrícula.
     * @param matricula La matrícula del coche a buscar.
     * @return El objeto Coche si se encuentra, o null si no existe.
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
                break;
            }
        }
        return aux;
    }

    /**
     * Aumenta la velocidad de un coche específico.
     * La velocidad se incrementa por la cantidad especificada.
     * @param matricula La matrícula del coche a modificar.
     * @param v La cantidad en la que se aumentará la velocidad.
     * @return La nueva velocidad del coche, o -1 si el coche no fue encontrado.
     */
    public int aumentarVelocidad(String matricula, Integer v) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.velocidad += v;
            return coche.velocidad;
        }
        return -1;
    }

    /**
     * Disminuye la velocidad de un coche específico.
     * La velocidad se decrementa por la cantidad especificada y no puede ser inferior a 0.
     * @param matricula La matrícula del coche a modificar.
     * @param v La cantidad en la que se disminuirá la velocidad.
     * @return La nueva velocidad del coche, o -1 si el coche no fue encontrado.
     */
    public int disminuirVelocidad(String matricula, Integer v) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.velocidad -= v;
            if (coche.velocidad < 0) {
                coche.velocidad = 0; // La velocidad no puede ser negativa
            }
            return coche.velocidad;
        }
        return -1;
    }

    /**
     * Obtiene la velocidad actual de un coche dado su matrícula.
     * @param matricula La matrícula del coche.
     * @return La velocidad del coche, o -1 si el coche no fue encontrado.
     */
    public int getVelocidad(String matricula) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            return coche.velocidad;
        }
        return -1;
    }
}
