package medical.app.service.impl;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import medical.app.models.Cita;
import medical.app.models.Doctor;
import medical.app.models.HistorialPaciente;
import medical.app.repository.CitaRepositorio;
import medical.app.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService{

	@Autowired
	private CitaRepositorio citaRepositorio;
	
	@Override
	@Transactional(readOnly = false)
	public Cita registrar(Cita cita) {
		cita.setFechaRegistro(new Date());
		return citaRepositorio.save(cita);
	}

	@Override
	@Transactional(readOnly = false)
	public Cita modificar(Cita cita) {
		return citaRepositorio.save(cita);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cita> listar() {
		return citaRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean eliminar(Long id) {
		if(citaRepositorio.existsById(id)) {
			citaRepositorio.deleteById(id);
			return true;
		}else return false;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cita> listarCitaPorPaciente(Long id) {
		HistorialPaciente historialPaciente = new HistorialPaciente();
		historialPaciente.setId(id);
		return citaRepositorio.findByHistorialPaciente(historialPaciente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cita> listarCitaPorDoctor(Long id) {
		Doctor doctor = new Doctor();
		doctor.setId(id);
		return citaRepositorio.findByDoctor(doctor);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cita> listarCitaPorEstado(String estado) {
		return citaRepositorio.findByEstado(estado);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cita> listarCitaPorFechaRegistro(Date fechaRegistro) {
		return citaRepositorio.findByFechaRegistro(fechaRegistro);
	}

}
