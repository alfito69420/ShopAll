# Curso de Spint Boot Metaphorce
Este es creado para generar APIS mediante Sprintboot, mediante la capacitación del curso de Metaphorce impartido por el mentor Adrian FLores como del Maestro José Guillermo Fierro Mendoza

## Métodología
Se desarrollo el proyecto en base de 5 secciones principales las cuales son (de manera secuendial):

- **Model** : Entidades equivalentes a tablas dentro del modelo de base de datos


- **Respository**: Recursos para consumo y lógica para administrar los datos de una entidad


- **Domain**: Entidades para definir los mensajes de entrada y salida de la API como son los request y response
(En nuestro caso hicimos una general la cual hereda a las demás)

- **Service**: Recursos para la lógica del negocio y proceso de datos después del consumo del recurso repositorio; es decir, después de obtener o manejar datos de una base de datos o tabla


- **Controller**: Recursos expuestos para consumo externo, métodos de la API, endpoint, métodos y verbos 

### Script 
El script se encuntra en la ruta **Scripts/metaphorce.sql** , la cual cuenta con el sql de la base de datos como unos inserts de prueba.
Sobre las licencias de la base de datos, decidimos hacer un estandar con esta configuración en el archivo **application.properties**

``` 
spring.datasource.url=jdbc:mysql://localhost/maven
spring.datasource.username=maven
spring.datasource.password=Sandra22Mane10Alfre99Gera22Braulio10
``` 

### Formato de Respuestas de las APIS

## Apis para consumir 
this
## Vesiones de Dependencias de maven
this
## Colaboradores 
- Sandra Paola Gutiérrez Marcial
- Alfredo Alejandro Aramburo Carreño
- José Manuel Cerritos González  
- Braulio Baltazar Andrade Medina
- Luis Gerardo López Ruiz
