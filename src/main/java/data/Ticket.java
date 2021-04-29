package data;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Ticket{
	
	private String codigo;
	private String date;
	private String origen;
	private String destino;
	private float precio;
	
	public Ticket(String codigo, String date, String origen, String destino, float precio) {
		super();
		this.codigo = codigo;
		this.date = date;
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
	}
	
	public Ticket() {
		super();
		this.codigo = "";
		this.date = "";
		this.origen = "";
		this.destino = "";
		this.precio = 0;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Ticket [codigo=" + codigo + ", date=" + date + ", origen=" + origen + ", destino=" + destino
				+ ", precio=" + precio + "]";
	}
	
	
	
	
	
}
