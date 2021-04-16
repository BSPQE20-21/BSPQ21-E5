package Classes;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)

public class Cliente {
	private String name;
	private int age;
	private int id;
	
	public Cliente(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	public Cliente() {
		super();
		this.name = " ";
		this.age = 0;
		this.id = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Cliente [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	
	
}
