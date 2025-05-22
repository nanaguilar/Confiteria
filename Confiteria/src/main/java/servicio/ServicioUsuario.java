package servicio;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;

import modelo.Usuario;

public class ServicioUsuario extends Servicio {

	public void crearUsuario(Usuario usuario) {
		startTransaction();
		try {
			em.persist(usuario);
			commitTransaction();
		} catch (Exception e) {
			rollbackTransaction();
			e.printStackTrace();
		}
	}

	public Usuario leerUsuario(Integer id) {
		startTransaction();
		Usuario usuario = em.find(Usuario.class, id);
		em.close();
		return usuario;
	}

	public void actualizarUsuario(Usuario usuario) {
		startTransaction();
		try {
			em.merge(usuario);
			commitTransaction();
		} catch (Exception e) {
			rollbackTransaction();
			e.printStackTrace();
		}
	}

	public void eliminarUsuario(Integer id) {
		startTransaction();
		try {
			Usuario usuario = em.find(Usuario.class, id);
			if (usuario != null) {
				em.remove(usuario);
			} else {
				throw new EntityNotFoundException("Usuario no encontrado con ID " + id);
			}
			commitTransaction();
		} catch (Exception e) {
			rollbackTransaction();
			e.printStackTrace();
		}
	}
	
    public Usuario loginUsuario(String correo, String clave) {
        try {
            startTransaction();
            Usuario usuario = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.Correo = :Correo AND u.Clave = :Clave", Usuario.class)
                .setParameter("Correo", correo)
                .setParameter("Clave", clave)
                .getSingleResult();
            em.close();
            return usuario;
        } catch (NoResultException e) {
            em.close();
            return null;
        }
    }
}
