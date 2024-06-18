### Pasos
1. Crear entity package, luego <ClaseEntidad>
2. Añadir el repositorio, se crea un paquete Dao, y luego un InterfazRepositorio
   Se utiliza un método preconstruido gracias al JpaRepository.
3. Crear Service.
4. Se crea la implementación del service.
   Se puede implementar más de una vez a una interfaz:
   Si se tiene: PersonaService,
   Entonces se puede tener PersonaServiceImpl1, PersonaServiceImpl2...;
5. Se crean las constantes
6. se crea el controller

# Estereotipos
* Son palabras reservada de Spring para definir Beans(@Service, @Configuration, @Component, @Bean).
* @Bean y @Component aplican a clases.
* @Bean aplica para métodos, pero la clase debe tener su @Configuration
* Los Beans van proveeder servicios(operaciones) a un controlador, por ejemplo buscarPorId, actualizar, eliminar
*

## Tipos de inyección:
*  **Inyección por construcctor:**
   Cuando se tenga una interfaz con más de una implementación no se debe usar inyección por construcctor.
```java
public class PersonaServiceImpl implements PersonaService {
    private final PersonaRepository personaRepository2;

    public PersonaServiceImpl(PersonaRepository personaRepository2) {
        this.personaRepository2 = personaRepository2;
    }
}
```

* **Inyección por Autowired:**
```java
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
}
```
* **Constantes:**
    * El Static en java: No e necesita instanciar porque son valores FINALES.
    * El static y el final, hace que sea un variable y un valor único.
    * También se usan los enums


Herramientas de calidad de código, a-quue , X-Ray, Fortifive.

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
</dependency>
```

# Consumo de APIs externas
* **Package Response**: 
Almacenar la respuesta del api que se va a consultar.

# Redis
Es una base de datos de almacenamiento en memoria, 
* Tienen un tiempo de uso limitado
* El tiempo de respuesta es mucho más rápido
* Para poner cosas relevantes

**Añdir la dependencia para manejar REDIS**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

# Retrofit
Hacer consumo de Apis externas a través de Retrofit.
## Síncrono o Asincrono
Síncrono: Esperando una respuesta.


### Asíncrono:
* No entrega respuesta inmediata.
* Ejemplo: se hace una validación por un periodo de tiempo.
* Ejemplo: las entidades bancarias.




* ¿Qué son las interfases funcionales?
* 


