package medical.app.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "persona")
public class Persona implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "nombre", nullable = false, length = 20)
	private String nombre;
	
	@Column(name = "apellido_paterno", nullable = false)
	private String apellidoPaterno;
	
	@Column(name = "apellido_materno", nullable = false)
	private String apellidoMaterno;
	
	@Column(name = "dni", nullable = false, unique = true, length = 8)
	private String dni;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_persona")
	@Column(name = "roles")
	private List<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Persona() {}
	
	private Persona(PersonaBuilder builder) {
		this.id = builder.id;
		this.email = builder.email;
		this.password = builder.password;
		this.roles = builder.roles;
		this.nombre = builder.nombre;
		this.apellidoPaterno = builder.apellidoPaterno;
		this.apellidoMaterno = builder.apellidoMaterno;
		this.dni = builder.dni;
	}
	
	private static final long serialVersionUID = 1L;
	
	public static class PersonaBuilder{
		
		private Long id;
		
		private String email;
		
		private String password;
		
		private String nombre;
		
		private String apellidoPaterno;
		
		private String apellidoMaterno;
		
		private String dni;
		
		private List<Role> roles;
		
		public PersonaBuilder() {}
		
		public PersonaBuilder credenciales(String email, String password, List<Role> roles) {
			this.email = email;
			this.password = password;
			this.roles = roles;
			return this;
		}
		
		public PersonaBuilder nombreCompleto(String nombre, String apellidoPaterno, String apellidoMaterno) {
			this.nombre = nombre;
			this.apellidoPaterno = apellidoPaterno;
			this.apellidoMaterno = apellidoMaterno;
			return this;
		}
		
		public PersonaBuilder dni(String dni) {
			this.dni = dni;
			return this;
		}
		
		public PersonaBuilder id(Long id) {
			this.id = id;
			return this;
		}
		
		public Persona build() {
			return new Persona(this);
		}
	}

}
