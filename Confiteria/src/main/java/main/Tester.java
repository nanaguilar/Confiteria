package main;

import modelo.Dulce;
import servicio.Servicio;
import servicio.ServicioDulce;

public class Tester {

	public static void main(String[] args) {
		// Inicializar la EntityManagerFactory
		Servicio.startEntityManagerFactory("Confiteria");

		// Crear una instancia de ServicioDulce
		ServicioDulce servicioDulce = new ServicioDulce();

		// Crear un nuevo dulce (Create)
		Dulce nuevoDulce = new Dulce();
		nuevoDulce.setNombre("Lindor");
		nuevoDulce.setCantidad(6);
		nuevoDulce.setPrecio(2500);

		servicioDulce.crearDulce(nuevoDulce);
		System.out.println("Dulce creado: " + nuevoDulce);

		// Cerrar la EntityManagerFactory
		Servicio.stopEntityManagerFactory();
	}
}
