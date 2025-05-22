package servicio;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import modelo.Dulce;

public class ServicioDulce extends Servicio {

	public void crearDulce(Dulce dulce) {
		startTransaction();
		try {
			em.persist(dulce);
			commitTransaction();
		} catch (Exception e) {
			rollbackTransaction();
			e.printStackTrace();
		}
	}
	
    public List<Dulce> listarDulces() {
        startTransaction();  
        List<Dulce> dulce = em.createQuery("SELECT d FROM Dulce d", Dulce.class).getResultList(); 
        em.close();
        return dulce; 
    }

	public Dulce leerDulce(Integer id) {
		startTransaction();
		Dulce dulce = em.find(Dulce.class, id);
		em.close();
		return dulce;
	}

	public boolean actualizarDulce(Dulce dulce) {
		startTransaction();
		try {
			em.merge(dulce);
			commitTransaction();
			return true;
		} catch (Exception e) {
			rollbackTransaction();
			e.printStackTrace();
			return false;
		}
	}

	public void eliminarDulce(Integer id) {
		startTransaction();
		try {
			Dulce dulce = em.find(Dulce.class, id);
			if (dulce != null) {
				em.remove(dulce);
			} else {
				throw new EntityNotFoundException("Dulce no encontrado con ID " + id);
			}
			commitTransaction();
		} catch (Exception e) {
			rollbackTransaction();
			e.printStackTrace();
		}
	}
}
