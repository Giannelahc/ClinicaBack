package medical.app.service;

import medical.app.models.Direccion;

public interface DireccionService {

	Direccion registrar(Direccion direccion);
	Direccion modificar(Direccion direccion);
	boolean eliminar(Long id);
}
