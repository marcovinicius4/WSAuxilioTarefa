package br.com.activity.modelo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class class_Professor {
	private int idProfessor;
	private String Name;
	private String Email;
	private String Password;

	
	public int getIDProfessor() {
		return idProfessor;
	}
	
	public void setIDProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String Password) {
		this.Password = Password;
	}
	
}
