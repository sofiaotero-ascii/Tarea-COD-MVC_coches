# Arquitectura MVC

Aplicación que trabaja con objetos coches, modifica la velocidad y la muestra

---
## Diagrama de clases:

```mermaid
classDiagram
    class Coche {
        -matricula: string
        -modelo: string
        -velocidad: int
        +getVelocidad(): int
        +setVelocidad(int): void
    }

    class Controller {
        +main(): void
    }

    class View {
        +muestraVelocidad(nombre: string, velocidad: int): boolean
        +mostrarTodosLosCoches(coches: List): void
    }

    class Model {
        -parking: List
        +crearCoche(modelo: string, matricula: string): Coche
        +getCoche(matricula: string): Coche
        +aumentarVelocidad(matricula: string, cantidad: int): int
        +disminuirVelocidad(matricula: string, cantidad: int): int
        +getVelocidad(matricula: string): int
    }

    Controller --> Model : usa
    Controller --> View : usa
    Model --> Coche : contiene

      
```

---

## Diagrama de Secuencia

Creación y visualización


```mermaid
sequenceDiagram
    participant Controller
    participant Model
    participant View
    participant Coche
    
    Controller->>Model: crearCoche("Alpine", "HYU 4567")
    activate Model
    Model->>Coche: new Coche("Alpine", "HYU 4567")
    Model->>Model.parking: add(coche)
    Model-->>Controller: Coche
    deactivate Model
    
    Controller->>Model: aumentarVelocidad("HYU 4567", 30)
    activate Model
    Model->>Coche: velocidad += 30
    Model-->>Controller: nueva velocidad (30)
    deactivate Model
    
    Controller->>View: muestraVelocidad("HYU 4567", 30)
    activate View
    View->>View: System.out.println("HYU 4567: 30km/hr")
    View-->>Controller: true
    deactivate View
```


