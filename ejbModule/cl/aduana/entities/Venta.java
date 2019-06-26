package cl.aduana.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the VENTA database table.
 * 
 */
@Entity
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codigoventa;

	private BigDecimal estado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private BigDecimal total;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="venta")
	private List<Detalle> detalles;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="RUTCLIENTE")
	private Usuario usuario;

	public Venta() {
	}

	public long getCodigoventa() {
		return this.codigoventa;
	}

	public void setCodigoventa(long codigoventa) {
		this.codigoventa = codigoventa;
	}

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<Detalle> getDetalles() {
		return this.detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public Detalle addDetalle(Detalle detalle) {
		getDetalles().add(detalle);
		detalle.setVenta(this);

		return detalle;
	}

	public Detalle removeDetalle(Detalle detalle) {
		getDetalles().remove(detalle);
		detalle.setVenta(null);

		return detalle;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}