package medical.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import medical.app.models.Horario;
import medical.app.models.Turno;
import medical.app.repository.TurnoRepositorio;
import medical.app.service.TurnoService;

@Service
public class TurnoServiceImpl implements TurnoService{

	@Autowired
	private TurnoRepositorio turnoRepositorio;
	
	@Override
	@Transactional(readOnly = false)
	public Turno modificar(Turno turno) {
		return turnoRepositorio.save(turno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Turno> listarPorHorarioYEstado(Long id, String estado) {
		Horario horario = new Horario();
		horario.setId(id);
		return turnoRepositorio.findByHorarioAndEstado(horario, estado);
	}

}
