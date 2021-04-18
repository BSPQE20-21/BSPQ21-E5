package Classes;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)

public class Cliente {
	private String name;
	private String mail;
	private String pw;
	private int age;
	private int id;
	
	public Cliente(String name, String mail, String pw) {
		super();
		this.name = name;
		this.mail = mail;
		this.pw = pw;
		
		
	}

	public Cliente() {
		super();
		this.name = "";
		this.mail = "";
		this.pw = "";
		this.age = 0;
		this.id = 0;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cliente [name=" + name + ", mail=" + mail + ", pw=" + pw + ", age=" + age + ", id=" + id + "]";
	}

	
}
	