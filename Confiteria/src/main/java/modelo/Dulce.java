package modelo;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Dulce
 *
 */
@Entity
@Table(name = "dulce")

public class Dulce implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	private String Nombre;
	private double Cantidad;
	private double Precio;
	private static final long serialVersionUID = 1L;

	public Dulce() {
		super();
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

	public double getCantidad() {
		return this.Cantidad;
	}

	public void setCantidad(double Cantidad) {
		this.Cantidad = Cantidad;
	}

	public double getPrecio() {
		return this.Precio;
	}

	public void setPrecio(double Precio) {
		this.Precio = Precio;
	}
}
