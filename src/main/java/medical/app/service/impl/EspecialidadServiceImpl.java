package medical.app.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import medical.app.models.Especialidad;
import medical.app.repository.EspecialidadRepositorio;
import medical.app.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{

	@Autowired
	private EspecialidadRepositorio especialidadRepositorio;
	
	@Override
	@Transactional(readOnly = false)
	public Especialidad registrar(Especialidad especialidad) {
		return especialidadRepositorio.save(especialidad);
	}

	@Override
	@Transactional(readOnly = false)
	public Especialidad modificar(Especialidad especialidad) {
		return especialidadRepositorio.save(especialidad);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Especialidad> listar() {
		return especialidadRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean eliminar(Long id) {
		if(especialidadRepositorio.existsById(id)) {
			especialidadRepositorio.deleteById(id);
			return true;
		}
		else return false;
	}

}
