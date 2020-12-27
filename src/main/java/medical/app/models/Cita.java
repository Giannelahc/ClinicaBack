package medical.app.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "cita")
public class Cita implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cita", nullable=false, unique = true)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_doctor", nullable=false)
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="id_historial", nullable=false)
	private HistorialPaciente historialPaciente;
	
	@OneToOne
	@JoinColumn(name="id_registro", nullable=false)
	private RegistroMedico registroMedico; 
	
	@Column(name = "fecha_registro", nullable=false)
	private Date fechaRegistro;
	
	@Column(name = "fecha_cita", nullable=false)
	private Date fechaCita;
	
	@Column(name = "estado", nullable=false)
	private String estado;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public HistorialPaciente getHistorialPaciente() {
		return historialPaciente;
	}

	public void setHistorialPaciente(HistorialPaciente historialPaciente) {
		this.historialPaciente = historialPaciente;
	}

	public RegistroMedico getRegistroMedico() {
		return registroMedico;
	}

	public void setRegistroMedico(RegistroMedico registroMedico) {
		this.registroMedico = registroMedico;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;

}
