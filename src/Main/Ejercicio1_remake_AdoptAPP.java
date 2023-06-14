/*
OBJETIVO
Realizar un programa para que una Persona pueda adoptar un Perro. 

PASOS
Vamos a contar de dos clases. 
    1) Perro, que tendrá como atributos: 
            nombre, 
            raza, 
            edad y 
            tamaño;  
    2)la clase Persona con atributos: 
            nombre, 
            apellido, 
            edad, 
            documento y 
            Perro.

Ahora deberemos en el main crear dos Personas y dos Perros. 
Después, vamos a tener que pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, 
mostrar desde la clase Persona, la información del Perro y de la Persona.

 */
package main;

import Servicios.ServicioAdopcion;

public class Ejercicio1_remake_AdoptAPP {
    public static void main(String[] args) {
        ServicioAdopcion servicioAdopcion = new ServicioAdopcion();
        servicioAdopcion.menuPrincipal();
    }
}