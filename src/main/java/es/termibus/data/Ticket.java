package es.termibus.data;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Ticket{
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int codigo; // Trip ID
	
	private String date; 
	private String destino;
	private String hour;
	private int bus;
	private int precio;
	
	public Ticket(int codigo, String date, String destino, String hour, int bus, int precio) {
		super();
		this.codigo = codigo;
		this.date = date;
		this.destino = destino;
		this.hour = hour;
		this.bus = bus;
		this.precio = precio;
	}
	
	public Ticket() {
		super();
		this.codigo = 0;
		this.date = "";
		this.destino = "";
		this.hour = "";
		this.bus = 0;
		this.precio = 0;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
	

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public int getBus() {
		return bus;
	}

	public void setBus(int bus) {
		this.bus = bus;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Ticket [codigo=" + codigo + ", date=" + date + ", destino=" + destino + ", hour=" + hour + ", bus="
				+ bus + ", precio=" + precio + "]";
	}
}
