package medical.app.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	
	@Column(name = "dni", nullable = false, unique = true, length = 8)
	private String dni;
	
	@Column(name = "tipo_usuario", nullable = false)
	private String tipoUsuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_role", nullable = false)
	private Role role;

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Persona() {}
	
	private Persona(PersonaBuilder builder) {
		this.id = builder.id;
		this.email = builder.email;
		this.password = builder.password;
		this.role = builder.role;
		this.nombre = builder.nombre;
		this.apellidos = builder.apellidos;
		this.tipoUsuario = builder.tipoUsuario;
		this.dni = builder.dni;
	}
	
	private static final long serialVersionUID = 1L;
	
	public static class PersonaBuilder{
		
		private Long id;
		
		private String email;
		
		private String password;
		
		private String nombre;
		
		private String apellidos;
		
		private String dni;
		
		private Role role;
		
		private String tipoUsuario;
		
		public PersonaBuilder() {}
		
		public PersonaBuilder credenciales(String email, String password, Role role, String tipoUsuario) {
			this.email = email;
			this.password = password;
			this.role = role;
			this.tipoUsuario = tipoUsuario;
			return this;
		}
		
		public PersonaBuilder nombreCompleto(String nombre, String apellidos) {
			this.nombre = nombre;
			this.apellidos = apellidos;
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
