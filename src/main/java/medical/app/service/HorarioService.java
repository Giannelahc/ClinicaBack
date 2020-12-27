package medical.app.service;

import java.util.List;

import medical.app.models.Horario;

public interface HorarioService{

	Horario modificar(Horario horario);
	List<Horario> listarPorEspecialidad(Long id);
	List<Horario> listarPorDoctor(Long id);
	List<Horario> listarPorEspecialidadYEstado(Long id, String estado);
}
