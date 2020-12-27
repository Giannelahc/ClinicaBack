package medical.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import medical.app.models.RegistroMedico;
import medical.app.repository.RegistroMedicoRepositorio;
import medical.app.service.RegistroMedicoService;

@Service
public class RegistroMedicoServiceImpl implements RegistroMedicoService{

	@Autowired
	private RegistroMedicoRepositorio registroMedicoRepositorio;
	
	@Override
	@Transactional(readOnly = false)
	public RegistroMedico registrar(RegistroMedico registroMedico) {
		return registroMedicoRepositorio.save(registroMedico);
	}

	@Override
	@Transactional(readOnly = false)
	public RegistroMedico modificar(RegistroMedico registroMedico) {
		return registroMedicoRepositorio.save(registroMedico);
	}

}
