package medical.app.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria")
public class Auditoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_audit")
	private Long id;
	
	@Column(name = "tabla")
	private String tabla;
	
	@Column(name = "id_registro")
	private Long idRegistro;
	
	@Column(name = "fecha_registro")
	private Date fechaRegistro;
	
	@Column(name = "metodo")
	private String metodo;

	public Auditoria(String tabla, Long idRegistro, Date fechaRegistro, String metodo) {
		super();
		this.tabla = tabla;
		this.idRegistro = idRegistro;
		this.fechaRegistro = fechaRegistro;
		this.metodo = metodo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public Long getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(Long idRegistro) {
		this.idRegistro = idRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	
}
