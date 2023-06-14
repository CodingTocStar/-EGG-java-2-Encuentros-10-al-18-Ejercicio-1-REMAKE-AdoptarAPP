/*
    1) Perro, que tendrá como atributos: 
            nombre, 
            raza, 
            edad y 
            tamaño;  
 */
package Entidades;

/**
 *
 * @author MiriamNahuel
 */
public class Perro {
    //ATRIBUTOS
    private String nombre;
    private String raza;
    private int edad;
    private String tamano;
    
    //CONSTRUCTORES
    
    public Perro(){}

    public Perro(String nombre, String raza, int edad, String tamano) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tamano = tamano;
    }
    
    //GETTER & SETTER

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
    
    
    
}
