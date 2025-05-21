/**
 * Representa un coche con sus propiedades básicas.
 * @author Sofia Otero Gil
 */
public class Coche {
    String matricula;
    String modelo;
    Integer velocidad;

    /**
     * Constructor para crear una nueva instancia de Coche.
     * La velocidad inicial del coche se establece en 0.
     * @param modelo El modelo del coche.
     * @param matricula La matrícula única del coche.
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
    }
}
