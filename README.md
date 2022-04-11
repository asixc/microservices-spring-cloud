## Actividad 17-03-2022:
# Ejercicio 1

Recrear desde cero la arquitectura de microservicios vista en clase. Crear los siguientes proyectos:

* configserver
* config-git
* eurekaserver
* microservicio1
* microservicio2
* gateway (sin config client)

Los microservicios son a elección del alumno, contendrán al menos un controlador para comprobar que cuando entramos al gateway en la url http://localhost:8080 poniendo el endpoint correspondiente nos lleva a un microservicio o a otro.

Intentar que los microservicios (microservicio1 y microservicio2) tengan Spring Data JPA con alguna base de datos y que permitan hacer un CRUD.

### Orden de arranque:
* Configurations 
* Eureka
  * Error *Request execution error. endpoint=DefaultEndpoint{ serviceUrl='http://localhost:8761/eureka/}* Se puede comprobar su funcionamiento desde *http://localhost:8761/*
* Companies || invoices
* Gateway