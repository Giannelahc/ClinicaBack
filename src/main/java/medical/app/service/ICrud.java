package medical.app.service;

import java.util.List;

public interface ICrud <T>{

	T registrar(T obj);
	T modificar(T obj);
	List<T> listar();
	Boolean eliminar(Long id);
}
