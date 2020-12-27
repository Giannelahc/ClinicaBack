package medical.app.service;

import medical.app.models.RegistroMedico;

public interface RegistroMedicoService {

	RegistroMedico registrar(RegistroMedico registroMedico);
	RegistroMedico modificar(RegistroMedico registroMedico);
}
