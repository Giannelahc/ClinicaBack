package medical.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import medical.app.models.Doctor;
import medical.app.models.Especialidad;
import medical.app.models.Horario;
import medical.app.repository.HorarioRepositorio;
import medical.app.service.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService{

	@Autowired
	private HorarioRepositorio horarioRepositorio;
	
	@Override
	@Transactional(readOnly = false)
	public Horario modificar(Horario horario) {
		return horarioRepositorio.save(horario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Horario> listarPorEspecialidad(Long id) {
		Especialidad especialidad = new Especialidad();
		especialidad.setId(id);
		return horarioRepositorio.findByEspecialidad(especialidad);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Horario> listarPorDoctor(Long id) {
		Doctor doctor = new Doctor();
		doctor.setId(id);
		return horarioRepositorio.findByDoctor(doctor);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Horario> listarPorEspecialidadYEstado(Long id, String estado) {
		Especialidad especialidad = new Especialidad();
		especialidad.setId(id);
		return horarioRepositorio.findByEspecialidadAndEstado(especialidad, estado);
	}

}
