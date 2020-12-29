package medical.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import medical.app.dto.HistorialPacienteDTO;
import medical.app.models.Direccion;
import medical.app.models.HistorialPaciente;
import medical.app.models.HistorialPaciente.HistorialPacienteBuilder;
import medical.app.models.Persona;
import medical.app.models.Persona.PersonaBuilder;
import medical.app.service.DireccionService;
import medical.app.service.HistorialPacienteService;
import medical.app.service.PersonaService;
import medical.app.util.Constantes;
import medical.app.util.Funciones;

@Api(tags = "Paciente")
@RestController
@RequestMapping(Constantes.PACIENTE)
public class PacienteController {
	
	@Autowired
	private HistorialPacienteService pacienteService;
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private DireccionService direccionService;
	
	@PostMapping(Constantes.REGISTRAR)
	public ResponseEntity<Map<String,Object>> registrar(@RequestBody HistorialPacienteDTO paciente){
		Map<String,Object> response = new HashMap<>();
		try {
			if(personaService.existePorEmail(paciente.getEmail())) {
				response.put(Constantes.ERROR_MSG, Constantes.EMAIL_ERROR_RESPONSE);
			}else if(personaService.existePorDni(paciente.getDni()))
				response.put(Constantes.ERROR_MSG, Constantes.DNI_ERROR_RESPONSE);
			else {
				//paciente.getPersona().setPassword(passwordEncoder);
				
				Persona persona = (new PersonaBuilder()
						.nombreCompleto(paciente.getNombreCompleto().split(" ")[0], paciente.getNombreCompleto().split(" ")[1], paciente.getNombreCompleto().split(" ")[2])
						.credenciales(paciente.getEmail(), paciente.getPassword(), paciente.getRoles())
						.dni(paciente.getDni())
						.build());
				
				pacienteService.registrar((new HistorialPacienteBuilder(personaService.registrar(persona)))
						.fechaNacimiento(Funciones.convertirFecha(paciente.getFechaNacimiento()))
						.build());
				
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
			HistorialPaciente historial = pacienteService.obtenerPorPersona(id);
			historial.setFechaCreacion(Funciones.convertirFecha(historial.getFechaCreacion()));
			historial.setFechaNacimiento(Funciones.convertirFecha(historial.getFechaNacimiento()));
			response.put(Constantes.HISTORIAL_RESPONSE, historial);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch(Exception e) {
			response.put(Constantes.ERROR_MSG, Constantes.OBTENER_HISTORIAL_ERROR_RESPONSE);
			response.put(Constantes.MSG, e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(Constantes.MODIFICAR)
	public ResponseEntity<Map<String,Object>> modificarHistorial(@RequestBody HistorialPacienteDTO paciente){
		Map<String, Object> response = new HashMap<>();
		try {
			if(pacienteService.existePorId(paciente.getId())) {
				
				Persona persona = (new PersonaBuilder()
						.id(paciente.getIdPersona())
						.nombreCompleto(paciente.getNombreCompleto().split(" ")[0], paciente.getNombreCompleto().split(" ")[1], paciente.getNombreCompleto().split(" ")[2])
						.credenciales(paciente.getEmail(), paciente.getPassword(), paciente.getRoles())
						.dni(paciente.getDni())
						.build());
			
				Direccion direccion = new Direccion();
				direccion.setId(paciente.getIdDireccion());
				direccion.setDireccion(paciente.getDireccion());
				direccion.setProvincia(paciente.getProvincia());
				direccion.setDepartamento(paciente.getDepartamento());
				
				pacienteService.registrar((new HistorialPacienteBuilder(personaService.modificar(persona)))
						.direccionActualYnacim(direccionService.modificar(direccion), paciente.getLugarNacimiento())
						.datosPersonales(paciente.getEdad(), paciente.getEstadoCivil(), paciente.getSexo(), paciente.getCelular())
						.datosClinicos(paciente.getAlergias(), paciente.getTipoSangre(), paciente.getAntecedentesFamiliares(), paciente.getObservaciones())
						.fechaNacimiento(Funciones.convertirFecha(paciente.getFechaNacimiento()))
						.id(paciente.getId())
						.build());
				
				response.put(Constantes.EXITO_MSG, Constantes.MODIFICACION_EXITO_RESPONSE);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}else {
				response.put(Constantes.ERROR_MSG, Constantes.ID_ERROR_RESPONSE);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			response.put(Constantes.ERROR_MSG, Constantes.MODIFICACION_ERROR_RESPONSE);
			response.put(Constantes.MSG, e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
}
