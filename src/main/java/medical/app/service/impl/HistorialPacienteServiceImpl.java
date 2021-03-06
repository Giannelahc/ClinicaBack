package medical.app.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import medical.app.models.HistorialPaciente;
import medical.app.models.Persona;
import medical.app.repository.HistorialPacienteRepositorio;
import medical.app.service.HistorialPacienteService;
import medical.app.util.Funciones;

@Service
public class HistorialPacienteServiceImpl implements HistorialPacienteService{

	@Autowired
	private HistorialPacienteRepositorio pacienteRepositorio;
	
	@Override
	@Transactional(readOnly = false)
	public HistorialPaciente registrar(HistorialPaciente historialPaciente) {
		historialPaciente.setFechaCreacion(Funciones.convertirFecha(new Date()));
		return pacienteRepositorio.save(historialPaciente);
	}

	@Override
	@Transactional(readOnly = false)
	public HistorialPaciente modificar(HistorialPaciente historialPaciente) {
		return pacienteRepositorio.save(historialPaciente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<HistorialPaciente> listar() {
		return pacienteRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean eliminar(Long id) {
		if(pacienteRepositorio.existsById(id)) {
			pacienteRepositorio.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public HistorialPaciente obtenerPorPersona(Long id) {
		Persona persona = new Persona();
		persona.setId(id);
		return pacienteRepositorio.findByPersona(persona);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existePorId(Long id) {
		return pacienteRepositorio.existsById(id);
	}

}
