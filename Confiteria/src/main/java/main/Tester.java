package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Dulce;

public class Tester {

	private static EntityManager em = null;
	private static EntityManagerFactory entityManagerFactory = null;

	public static void main(String[] args) {
		try {
			System.out.println("Iniciando");
			startEntityManagerFactory("Confiteria");

			em = entityManagerFactory.createEntityManager();

			em.getTransaction().begin();

			Dulce nuevoDulce = new Dulce();
			nuevoDulce.setNombre("Lindor");
			nuevoDulce.setCantidad(6);
			nuevoDulce.setPrecio(2500);

			em.persist(nuevoDulce);
			em.getTransaction().commit();

			stopEntityManagerFactory();
			System.out.println("Finalizado");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void startEntityManagerFactory(String persistenceUnit) throws Exception {
		if (entityManagerFactory == null) {
			try {
				entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void stopEntityManagerFactory() throws Exception {
		if (entityManagerFactory != null) {
			if (entityManagerFactory.isOpen()) {
				try {
					entityManagerFactory.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			entityManagerFactory = null;
		}
	}
}
