/*
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
package Servicios;

import Entidades.Perro;
import Entidades.Persona;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MiriamNahuel
 */
public class ServicioAdopcion {

    //  HERRAMIENTAS
    Scanner lector = new Scanner(System.in).useDelimiter("\n");

    public ArrayList<Persona> crearPersona() {
        ArrayList<Persona> personas = new ArrayList();

        String continuar;
        do {
            System.out.println("Inserte los datos de la persona:");

            System.out.println("Nombre: ");
            String nombre = lector.next();

            System.out.println("Apellido: ");
            String apellido = lector.next();

            System.out.println("Edad: ");
            int edad = lector.nextInt();

            System.out.println("Documento de identidad: ");
            int documento = lector.nextInt();

            Persona nuevaPersona = new Persona(nombre, apellido, edad, documento, null);
            personas.add(nuevaPersona);

            System.out.println("¿Desea agregar otra persona? (s/n)");
            continuar = lector.next();

        } while (continuar.equalsIgnoreCase("s"));

        return personas;
    }

    public ArrayList<Perro> crearPerros() {
        ArrayList<Perro> perros = new ArrayList();

        String continuar;
        do {
            System.out.println("Inserte los datos del perro:");

            System.out.println("Nombre: ");
            String nombre = lector.next();

            System.out.println("Raza: ");
            String raza = lector.next();

            System.out.println("Edad: ");
            int edad = lector.nextInt();

            System.out.println("Tamaño (Pequeño, Mediano, Grande): ");
            String tamano = lector.next();

            Perro nuevoPerro = new Perro(nombre, raza, edad, tamano);
            perros.add(nuevoPerro);

            System.out.println("¿Desea agregar otro perro? (s/n)");
            continuar = lector.next();

        } while (continuar.equalsIgnoreCase("s"));

        return perros;
    }

    public void adoptarPerro(ArrayList<Persona> personas, ArrayList<Perro> perrosDisponibles) {

        if (personas.isEmpty() || perrosDisponibles.isEmpty()) {
            System.out.println("No hay personas o perros disponibles para adopción.");
            return;
        }

        System.out.println("Seleccione la persona que desea adoptar un perro (ingrese el número correspondiente):");
        for (int i = 0; i < personas.size(); i++) {
            System.out.println((i + 1) + ". " + personas.get(i).getNombre() + " " + personas.get(i).getApellido());
        }

        int indicePersona = lector.nextInt() - 1;
        Persona personaElegida = personas.get(indicePersona);

        System.out.println("Seleccione el perro que desea adoptar (ingrese el número correspondiente):");
        for (int i = 0; i < perrosDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + perrosDisponibles.get(i).getNombre());
        }

        int indicePerro = lector.nextInt() - 1;
        Perro perroElegido = perrosDisponibles.get(indicePerro);

        // Asignamos el perro elegido a la persona
        personaElegida.setPerro(perroElegido);

        // Quitamos el perro de la lista de perros disponibles para adopción
        perrosDisponibles.remove(indicePerro);

        System.out.println(personaElegida.getNombre() + " ha adoptado a " + perroElegido.getNombre() + ".");
    }

    public void mostrarPersonasYPerros(ArrayList<Persona> personas) {
        // Recorremos el ArrayList de personas
        for (Persona persona : personas) {
            // Mostramos los atributos de la persona
            System.out.println("Nombre de la persona: " + persona.getNombre());
            System.out.println("Apellido: " + persona.getApellido());
            System.out.println("Edad: " + persona.getEdad());
            System.out.println("Documento: " + persona.getDocumento());
            System.out.println("Adoptó a:");

            // Mostramos los atributos del perro de la persona
            Perro perro = persona.getPerro();
            if (perro != null) {
                System.out.println("Nombre del perro: " + perro.getNombre());
                System.out.println("Raza: " + perro.getRaza());
                System.out.println("Edad: " + perro.getEdad());
                System.out.println("Tamaño: " + perro.getTamano());
            } else {
                System.out.println("Esta persona no ha adoptado un perro.");
            }
            System.out.println("-------------------------");

        }
    }

    public void menuPrincipal() {
        ArrayList<Persona> personas = new ArrayList<>();
        ArrayList<Perro> perros = new ArrayList<>();
        int opcion;

        do {
            System.out.println("1. Crear persona");
            System.out.println("2. Crear perro");
            System.out.println("3. Adoptar perro");
            System.out.println("4. Mostrar personas y perros");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = lector.nextInt();

            System.out.println("");
            switch (opcion) {
                case 1:
                    personas.addAll(crearPersona());
                    break;
                case 2:
                    perros.addAll(crearPerros());
                    break;
                case 3:
                    adoptarPerro(personas, perros);
                    break;
                case 4:
                    mostrarPersonasYPerros(personas);
                    break;
                case 0:
                    System.out.println("Gracias por visitar nuestra aplicación de adopción. \n"
                            + "Cada perro merece un hogar amoroso y cada hogar merece un maravilloso perro. \n"
                            + "Al adoptar, no sólo estás trayendo una nueva mascota a tu casa, sino que también estás dando la bienvenida a un nuevo miembro de tu familia,"
                            + "\na un amigo incondicional que te acompañará en todos los momentos de tu vida. \n"
                            + "Recuerda siempre, adoptar es un acto de amor. \n"
                            + "¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida, inténtalo de nuevo.");
            }

            System.out.println("-------------------------");

        } while (opcion != 0);

    }

}
