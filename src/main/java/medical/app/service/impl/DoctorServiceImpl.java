package medical.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import medical.app.models.Doctor;
import medical.app.models.Persona;
import medical.app.repository.DoctorRepositorio;
import medical.app.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepositorio doctorRepositorio;
	
	@Override
	@Transactional(readOnly = false)
	public Doctor registrar(Doctor doctor) {
		return doctorRepositorio.save(doctor);
	}

	@Override
	@Transactional(readOnly = false)
	public Doctor modificar(Doctor doctor) {
		return doctorRepositorio.save(doctor);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Doctor> listar() {
		return doctorRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean eliminar(Long id) {
		if(doctorRepositorio.existsById(id)) {
			doctorRepositorio.deleteById(id);
			return true;
		}else return false;
	}

	@Override
	@Transactional(readOnly = true)
	public Doctor obtenerPorPersona(Long id) {
		Persona persona = new Persona();
		persona.setId(id);
		return doctorRepositorio.findByPersona(persona);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Doctor> obtenerPorEstado(String estado) {
		return doctorRepositorio.findByEstado(estado);
	}

}
