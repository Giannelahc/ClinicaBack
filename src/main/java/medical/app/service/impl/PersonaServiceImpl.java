package medical.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import medical.app.models.Persona;
import medical.app.repository.PersonaRepositorio;
import medical.app.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaRepositorio personaRepositorio;
	
	@Override
	@Transactional(readOnly = false)
	public Persona registrar(Persona persona) {
		return personaRepositorio.save(persona);
	}

	@Override
	@Transactional(readOnly = false)
	public Persona modificar(Persona persona) {
		return personaRepositorio.save(persona);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persona> listar() {
		return personaRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean eliminar(Long id) {
		if(personaRepositorio.existsById(id)) {
			personaRepositorio.deleteById(id);
			return true;
		}else
			return false;
	}

	@Override
	public boolean existePorEmail(String email) {
		return personaRepositorio.existsByEmail(email);
	}

	@Override
	public boolean existePorDni(String dni) {
		return personaRepositorio.existsByDni(dni);
	}

}
