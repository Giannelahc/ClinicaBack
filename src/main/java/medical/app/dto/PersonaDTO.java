package medical.app.dto;

import java.io.Serializable;
import java.util.List;

import medical.app.models.Role;

public class PersonaDTO implements Serializable{

	private Long id;
	
	private String nombreCompleto;
	
	private String dni;
	
	private String email;
	
	private String password;
	
	private List<Role> roles;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	private static final long serialVersionUID = 1L;

}
