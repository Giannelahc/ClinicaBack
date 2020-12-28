package medical.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medical.app.dto.HistorialPacienteDTO;
import medical.app.models.HistorialPaciente;
import medical.app.service.HistorialPacienteService;
import medical.app.service.PersonaService;
import medical.app.util.Constantes;
import medical.app.util.Funciones;

@RestController
@RequestMapping(Constantes.PACIENTE)
public class PacienteController {
	
	@Autowired
	private HistorialPacienteService pacienteService;
	
	@Autowired
	private PersonaService personaService;
	
	@PostMapping(Constantes.REGISTRAR)
	public ResponseEntity<Map<String,Object>> registrar(@RequestBody HistorialPacienteDTO paciente){
		Map<String,Object> response = new HashMap<>();
		try {
			if(personaService.existePorEmail(paciente.getPersona().getEmail())) {
				response.put(Constantes.ERROR_MSG, Constantes.EMAIL_ERROR_RESPONSE);
			}else if(personaService.existePorDni(paciente.getPersona().getDni()))
				response.put(Constantes.ERROR_MSG, Constantes.DNI_ERROR_RESPONSE);
			else {
				//paciente.getPersona().setPassword(passwordEncoder);
				HistorialPaciente hPaciente = new HistorialPaciente();
				hPaciente.setFechaNacimiento(Funciones.convertirFecha(paciente.getFechaNacimiento()));
				hPaciente.setPersona(personaService.registrar(paciente.getPersona()));
				pacienteService.registrar(hPaciente);
				response.put(Constantes.EXITO_MSG, Constantes.REGISTRO_EXITO_RESPONSE);
			}
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}catch(Exception e) {
			response.put(Constantes.ERROR_MSG, Constantes.REGISTRO_ERROR_RESPONSE);
			response.put(Constantes.MSG, e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(Constantes.LISTAR+"/{id}")
	public ResponseEntity<Map<String,Object>> obtenerHistorialPorPersona(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		try {
			response.put(Constantes.HISTORIAL_RESPONSE, pacienteService.obtenerPorPersona(id));
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch(Exception e) {
			response.put(Constantes.ERROR_MSG, Constantes.OBTENER_HISTORIAL_ERROR_RESPONSE);
			response.put(Constantes.MSG, e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
}
