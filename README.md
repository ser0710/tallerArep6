# Taller 6

Aplicación que recibe una cadena cualquiera, 
esta es recibida y es guardada en una base de datos Mongo, 
esta acción puede ser realizada por 3 instancias diferentes, 
presentes en los puertos 34000, 34001 y 34002. Una vez esta es recibida 
se muestra un json con las ultimas 10 cadenas enviadas junto con la fecha y 
hora en que se enviaron.
Cada una de las funcionalidades se encuentra en una instancia independiente
en AWS.

## Getting Started

### Prerequisites

Git: permite el control de versiones del proyecto

Java: lenguaje en el cual esta desarrollado la totalidad del proyecto

Maven: Software que gestiona proyectos java


### Arquitectura

En este caso primero tenemos una imagen de Mongo, seguido de esto 
tenemos 3 instancias diferentes las cuales consultan dicha base de datos además 
de realizar ciertas operaciones con la cadena que llega, finalmente un balanceador 
de cargas que se encarga de determinar la instancia a la cual enviar la cadena recibida. 
Una vez tenemos las imágenes de todo lo descrito con anterioridad estan en
instancias diferentes en un servicio de EC2 de AWS, herramienta que
permite configurar servidores virtuales.

## Diseño de clases

Para las 3 instancias se emplea la clase de SparkWebServer el cual 
por medio del framework de Spark es capaz de hacer peticiones 
a la base de datos, para la conexión en si se emplea la clase 
de MongoServiceImpl el cual es un singleton que permite consultar 
la información almacenada.
Para el balanceador de cargas se emplea la clase 
App que también usa el framework de Spark para hacer peticiones 
a alguno de las 3 instancias mencionadas. 



### Pruebas

![image](https://user-images.githubusercontent.com/90010904/224424706-eef33817-aaa6-474f-aeff-9510aef524b3.png)

![image](https://user-images.githubusercontent.com/90010904/224424741-9be69bf7-abea-4e9b-af49-1c71e408734c.png)

![image](https://user-images.githubusercontent.com/90010904/224424778-ce6bde77-fd88-4206-a01f-c48ed7b79db8.png)

![image](https://user-images.githubusercontent.com/90010904/224424820-a672e4c1-3d85-4576-b47c-07a67a48e518.png)

![image](https://user-images.githubusercontent.com/90010904/224424872-f0647606-a4a6-4281-a60d-942e28e75c79.png)

![image](https://user-images.githubusercontent.com/90010904/224424913-3f783cc1-d1d2-4e60-ab08-5a19cb2ff24e.png)

Podemos ver las diferentes pruebas realizadas, vemos que cada vez que se ingresa una nueva cadena esta
se va presentando en las diferentes instancias.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Versioning

version 1.0

## Authors

Sergio Andres Rozo Pulido




