package medical.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import medical.app.models.Direccion;
import medical.app.repository.DireccionRepositorio;
import medical.app.service.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService{

	@Autowired
	private DireccionRepositorio direccionRepositorio;
	
	@Override
	@Transactional(readOnly = false)
	public Direccion registrar(Direccion direccion) {
		return direccionRepositorio.save(direccion);
	}

	@Override
	@Transactional(readOnly = false)
	public Direccion modificar(Direccion direccion) {
		return direccionRepositorio.save(direccion);
	}

	@Override
	@Transactional(readOnly = false)
	public boolean eliminar(Long id) {
		if(direccionRepositorio.existsById(id)) {
			direccionRepositorio.deleteById(id);
			return true;
		}else 
			return false;
	}

}
