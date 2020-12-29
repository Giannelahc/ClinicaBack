package medical.app.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "historial_paciente")
public class HistorialPaciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historial", nullable = false)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;
	
	@OneToOne
	@JoinColumn(name = "id_direccion")
	private Direccion direccion;
	
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	private Date fechaNacimiento;
	
	@Column(name = "lugar_nacimiento")
	private String lugarNacimiento;
	
	@Column(name = "alergias")
	private String alergias;
	
	@Column(name = "edad")
	private Integer edad;
	
	@Column(name = "estado_civil")
	private String estadoCivil;
	
	@Column(name = "tipo_sangre")
	private String tipoSangre;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "celular")
	private String celular;
	
	@Column(name = "antecedentes_familiares")
	private String antecedentesFamiliares;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	public HistorialPaciente() {}
	
	private HistorialPaciente(HistorialPacienteBuilder historialBuilder) {
		this.id = historialBuilder.id;
		this.persona = historialBuilder.persona;
		this.direccion = historialBuilder.direccion;
		this.fechaNacimiento = historialBuilder.fechaNacimiento;
		this.lugarNacimiento = historialBuilder.lugarNacimiento;
		this.alergias = historialBuilder.alergias;
		this.edad = historialBuilder.edad;
		this.estadoCivil = historialBuilder.estadoCivil;
		this.tipoSangre = historialBuilder.tipoSangre;
		this.sexo = historialBuilder.sexo;
		this.celular = historialBuilder.celular;
		this.antecedentesFamiliares = historialBuilder.antecedentesFamiliares;
		this.observaciones = historialBuilder.observaciones;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getLugarNacimiento() {
		return lugarNacimiento;
	}


	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}


	public String getAlergias() {
		return alergias;
	}


	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public String getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public String getTipoSangre() {
		return tipoSangre;
	}


	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getAntecedentesFamiliares() {
		return antecedentesFamiliares;
	}


	public void setAntecedentesFamiliares(String antecedentesFamiliares) {
		this.antecedentesFamiliares = antecedentesFamiliares;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public static class HistorialPacienteBuilder{
		
		private Long id;
		
		private Persona persona;
		
		private Direccion direccion;
		
		private Date fechaNacimiento;
		
		private String lugarNacimiento;
		
		private String alergias;
		
		private Integer edad;
		
		private String estadoCivil;
		
		private String tipoSangre;
		
		private String sexo;
		
		private String celular;
		
		private String antecedentesFamiliares;
		
		private String observaciones;
		
		public HistorialPacienteBuilder(Persona persona) {
			this.persona = persona;
		}
		
		public HistorialPacienteBuilder direccionActualYnacim(Direccion direccion, String lugarNacimiento) {
			this.direccion = direccion;
			this.lugarNacimiento = lugarNacimiento;
			return this;
		}
		
		public HistorialPacienteBuilder datosPersonales(Integer edad, String estadoCivil, String sexo, String celular) {
			this.edad = edad;
			this.estadoCivil = estadoCivil;
			this.sexo = sexo;
			this.celular = celular;
			return this;
		}
		
		public HistorialPacienteBuilder datosClinicos(String alergias, String tipoSangre, String antecedentesFamiliares, String observaciones) {
			this.alergias = alergias;
			this.tipoSangre = tipoSangre;
			this.antecedentesFamiliares = antecedentesFamiliares;
			this.observaciones = observaciones;
			return this;
		}
		
		public HistorialPacienteBuilder fechaNacimiento(Date fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
			return this;
		}
		
		public HistorialPacienteBuilder id(Long id) {
			this.id = id;
			return this;
		}
		
		public HistorialPaciente build() {
			return new HistorialPaciente(this);
		}
	}
}
