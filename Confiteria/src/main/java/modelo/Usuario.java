package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Usuario
 *
 */

@Entity

public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	private String Nombre;
	private String Apellido;
	private String Correo;
	private String Clave;
	private static final long serialVersionUID = 1L;

	public Usuario() {
	}

	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}

	public String getApellido() {
		return this.Apellido;
	}

	public void setApellido(String Apellido) {
		this.Apellido = Apellido;
	}

	public String getCorreo() {
		return this.Correo;
	}

	public void setCorreo(String Correo) {
		this.Correo = Correo;
	}

	public String getClave() {
		return this.Clave;
	}

	public void setClave(String Clave) {
		this.Clave = Clave;
	}
}
