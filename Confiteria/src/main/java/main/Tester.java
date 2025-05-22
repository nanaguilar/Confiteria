package main;

import modelo.Dulce;
import servicio.Servicio;
import servicio.ServicioDulce;

public class Tester {

	public static void main(String[] args) {
		try {
			System.out.println("Iniciando");
			
			// Inicializamos el EntityManagerFactory
			Servicio.startEntityManagerFactory("Confiteria");

			 // Creamos instancia del servicio
            ServicioDulce servicioDulce = new ServicioDulce();

            // Crear 
            Dulce nuevoDulce = new Dulce();
            nuevoDulce.setNombre("Kiss");
            nuevoDulce.setCantidad(12);
            nuevoDulce.setPrecio(50);
            servicioDulce.crearDulce(nuevoDulce);
            System.out.println("Dulce creado: " + nuevoDulce.getNombre());

            // Leer
            Dulce dulceLeido = servicioDulce.leerDulce(nuevoDulce.getId());
            System.out.println("Dulce leído: " + dulceLeido.getNombre());

            // Actualizar
            dulceLeido.setPrecio(100);
            servicioDulce.actualizarDulce(dulceLeido);
            System.out.println("Dulce actualizado con precio: " + dulceLeido.getPrecio());

            // Eliminar
            servicioDulce.eliminarDulce(dulceLeido.getId());
            System.out.println("Dulce eliminado con ID: " + dulceLeido.getId());

            // Cerramos EntityManagerFactory
            servicio.Servicio.stopEntityManagerFactory();

            System.out.println("Finalizado");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}