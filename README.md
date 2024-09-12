# Curso de Spring Boot Metaphorce
Este es creado para generar APIS mediante Springboot, mediante la capacitación del curso de Metaphorce impartido por el mentor Adrian FLores como del Maestro José Guillermo Fierro Mendoza

## Metodología
Se desarrolló el proyecto en base de 5 secciones principales las cuales son (de manera secuencial):

- **Model**: Entidades equivalentes a tablas dentro del modelo de base de datos


- **Repository**: Recursos para consumo y lógica para administrar los datos de una entidad


- **Domain**: Entidades para definir los mensajes de entrada y salida de la API como son los request y response
(En nuestro caso hicimos una general la cual hereda a las demás)

- **Service**: Recursos para la lógica del negocio y proceso de datos después del consumo del recurso repositorio; es decir, después de obtener o manejar datos de una base de datos o tabla


- **Controller**: Recursos expuestos para consumo externo, métodos de la API, endpoint, métodos y verbos 

### Script 
El script se encuentra en la ruta **Scripts/metaphorce.sql**, la cual cuenta con el sql de la base de datos como unos inserts de prueba.
Sobre las licencias de la base de datos, decidimos hacer un standard con esta configuración en el archivo **application.properties**

``` 
spring.datasource.url=jdbc:mysql://localhost/maven
spring.datasource.username=maven
spring.datasource.password=Sandra22Mane10Alfre99Gera22Braulio10
``` 

### Formato de Respuestas de las APIS
Las respuestas de las APIS TODAS tienen la misma estructura y esto ayudaría para que aquellas personas que las consuman obtengan más información para poder trabajar ***(Ya sean Good Request o Bad Request)***
El formato JSON que envían son con los siguientes encabezados:
**Status**: Envía el código HTTP de la respuesta
**Message**: Mensaje acerca de la respuesta de la petition
**Flag**: Es true oh false es para indicar si fue buena o mala petition
**Data**: Obtiene los datos begun la petición

***Ejemplo (Obtiene todas las tiendas)***
``` 
{
    "Status": 200,
    "Message": "Obtención de todas las tiendas",
    "Data": [
        {
            "tienda_id": 2,
            "nombre": "Tienda B",
            "descripcion": "Descripción de la Tienda B"
        },
        {
            "tienda_id": 3,
            "nombre": "Tienda C",
            "descripcion": "Descripción de la Tienda C"
        },
        {
            "tienda_id": 4,
            "nombre": "Tienda D",
            "descripcion": "Descripción de la Tienda D"
        },
        {
            "tienda_id": 9,
            "nombre": "Xbox",
            "descripcion": "Gears of war es la mejor saga del videojuegos"
        },
        
    ],
    "Flag": true
}
``` 


## Apis para consumir 
En este caso se puede consumir cada una de las apis de las tablas del proyecto,
para estas API todas se rigen sobre el mismo esquema y planteamiento para su uso, ya que todas 
siguen la estructura "http://localhost:8080/api/v1/[tabla]/[accion]", donde se sabe que las acciones son **all** para
obtener todos los valores, **getOne/id** para solo obtener el valor de uno de
los registros, **create** para un nuevo registro, **update** para 
actualización de un registro existente y **delete** para 
la eliminación.

La lista de APIs contenidas son: 
<ol>
<li>Tienda</li>
<li>Venta</li>
<li>User</li>
<li>TipoPago</li>
<li>Categorías</li>
<li>Pedido</li>
<li>Tipo producto</li>
<li>VentaDetalle</li>
<li>EstadoPedido</li>
<li>Producto</li>
<li>Reseña</li>
<li>Rol</li>
<li>Rol Usuario</li>
<li>Notificación de pedido</li>
</ol>

## Tienda 
### List All tienda
*Ruta:* 
``` 
http://localhost:8080/api/v1/tienda/all
``` 
*Nombre de la Ruta:* Listar Tienda

***Información:*** Obtiene todas las tiendas

*Requerimientos:*   
- En la ruta: 
> Ninguno
- En el body: 
> Ninguno

## Versiones de Dependencias de maven

| Dependencias                    | Version       |
|---------------------------------|:--------------|
| `spring-boot-starter`           |               |
| `spring-boot-starter-data-rest` |               |
| `spring-boot-starter-data-jpa`  |               |
| `mysql-connector-j`             |               |
| `lombok`                        |               |
| `spring-boot-starter-test`      |               |
| `spring-boot-devtools`          | 3.1.4         |
| `spring-web`                    | 6.0.12        |
| `spring-ws`                     | 4.0.6         |
| `thymeleaf`                     | 3.1.2.RELEASE |
| `spring-boot-starter-web`       |               |

## Colaboradores 
- Sandra Paola Gutiérrez Marcial
- Alfredo Alejandro Aramburo Carreño
- José Manuel Cerritos González  
- Luis Gerardo López Ruiz
