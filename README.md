API REST para Gestión de Productos y Fabricantes
Este proyecto consiste en una API REST desarrollada en Spring Boot para gestionar productos y fabricantes. Utiliza MySQL como base de datos para almacenar la información. Se han empleado diversas tecnologías y patrones de diseño para facilitar el desarrollo y mantener un código limpio y estructurado.

Tecnologías Utilizadas
Spring Boot: Framework de desarrollo de aplicaciones en Java que facilita la creación de aplicaciones robustas y escalables.
Lombok: Biblioteca que simplifica la escritura de código en Java eliminando la necesidad de escribir código boilerplate como getters, setters y constructores.
MySQL: Sistema de gestión de bases de datos relacional utilizado para almacenar la información de productos y fabricantes.
DTO (Data Transfer Object): Patrón de diseño utilizado para transferir datos entre el cliente y el servidor de manera eficiente.
Builder Pattern: Patrón de diseño utilizado para construir objetos complejos paso a paso.
Estructura del Proyecto
El proyecto se estructura en los siguientes paquetes:

controller: Contiene los controladores REST que gestionan las peticiones HTTP.
service: Contiene la lógica de negocio de la aplicación.
repository: Contiene las interfaces que definen las operaciones CRUD sobre la base de datos.
model: Contiene las clases que representan los modelos de datos de la aplicación.
dto: Contiene las clases que representan los DTO (Data Transfer Objects) utilizados para transferir datos entre el cliente y el servidor.
