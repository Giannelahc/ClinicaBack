package medical.app.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "registro_medico")
public class RegistroMedico implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_registro")
	private Long id;
	
	@Column(name = "diagnostico")
	private String diagnostico;
	
	@Column(name = "receta")
	private String receta;
	
	@Column(name = "talla")
	private Integer talla;
	
	@Column(name = "peso")
	private Double peso;
	
	@Column(name = "presion_sanguinea")
	private Double presionSanguinea;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public Integer getTalla() {
		return talla;
	}

	public void setTalla(Integer talla) {
		this.talla = talla;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getPresionSanguinea() {
		return presionSanguinea;
	}

	public void setPresionSanguinea(Double presionSanguinea) {
		this.presionSanguinea = presionSanguinea;
	}

	private static final long serialVersionUID = 1L;

}
