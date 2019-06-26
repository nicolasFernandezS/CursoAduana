package cl.aduana.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the DETALLE database table.
 * 
 */
@Entity
@NamedQuery(name="Detalle.findAll", query="SELECT d FROM Detalle d")
public class Detalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codigodetalle;

	private Integer estado;

	private Integer precio;

	private Integer stock;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="CODIGOPRODUCTO")
	private Producto producto;

	//bi-directional many-to-one association to Venta
	@ManyToOne
	@JoinColumn(name="CODIGOVENTA")
	private Venta venta;

	public Detalle() {
	}

	public long getCodigodetalle() {
		return this.codigodetalle;
	}

	public void setCodigodetalle(long codigodetalle) {
		this.codigodetalle = codigodetalle;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getPrecio() {
		return this.precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}