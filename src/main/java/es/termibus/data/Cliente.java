package es.termibus.data;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)

public class Cliente {
	@PrimaryKey
	private String DNI;
	private String name;
	private String mail;
	private String pw;
	private int age;

	public Cliente(String DNI, String name, String mail, String pw) {
		super();
		this.DNI = DNI;
		this.name = name;
		this.mail = mail;
		this.pw = pw;

	}

	public Cliente() {
		super();
		this.DNI = "";
		this.name = "";
		this.mail = "";
		this.pw = "";
		this.age = 0;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	@Override
	public String toString() {
		return "Cliente [DNI=" + DNI + ", name=" + name + ", mail=" + mail + ", pw=" + pw + ", age=" + age + "]";
	}
}
