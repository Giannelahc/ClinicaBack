package medical.app.service;

import medical.app.models.Persona;

public interface PersonaService extends ICrud<Persona>{

	boolean existePorEmail(String email);
	boolean existePorDni(String dni);
	
}
