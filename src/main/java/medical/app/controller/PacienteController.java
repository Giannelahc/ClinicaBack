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
			if(personaService.existePorEmail(paciente.getPersona().getEmail())) {
				response.put(Constantes.TITULO_TXT, Constantes.TITULO_ADVERTENCIA);
				response.put(Constantes.TIPO_TXT, Constantes.TIPO_ADVERTENCIA);
				response.put(Constantes.MSG_TXT, Constantes.EMAIL_ERROR_RESPONSE);
			}else if(personaService.existePorDni(paciente.getPersona().getDni())) {
				response.put(Constantes.TITULO_TXT, Constantes.DNI_ERROR_RESPONSE);
				response.put(Constantes.TIPO_TXT, Constantes.TIPO_ADVERTENCIA);
				response.put(Constantes.MSG_TXT, Constantes.DNI_ERROR_RESPONSE);
			}
			else {
				//paciente.getPersona().setPassword(passwordEncoder);
				
				Persona persona = (new PersonaBuilder()
						.nombreCompleto(paciente.getPersona().getNombre(), paciente.getPersona().getApellidos())
						.credenciales(paciente.getPersona().getEmail(), paciente.getPersona().getPassword(), paciente.getPersona().getRole(), paciente.getPersona().getTipoUsuario())
						.dni(paciente.getPersona().getDni())
						.build());
				
				pacienteService.registrar((new HistorialPacienteBuilder(personaService.registrar(persona)))
						.fechaNacimiento(Funciones.convertirFecha(paciente.getFechaNacimiento()))
						.build());
				
				response.put(Constantes.TITULO_TXT, Constantes.TITULO_EXITO);
				response.put(Constantes.TIPO_TXT, Constantes.TIPO_EXITO);
				response.put(Constantes.MSG_TXT, Constantes.REGISTRO_EXITO_MSG);
			}
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}catch(Exception e) {
			response.put(Constantes.TITULO_TXT, Constantes.TITULO_ERROR);
			response.put(Constantes.TIPO_TXT, Constantes.TIPO_ERROR);
			response.put(Constantes.MSG_TXT, Constantes.REGISTRO_ERROR_MSG);//e.getMessage()
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
			response.put(Constantes.DATA_OBJECT_RESPONSE, historial);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch(Exception e) {
			response.put(Constantes.TIPO_ERROR, Constantes.OBTENER_HISTORIAL_ERROR_MSG);
			response.put(Constantes.MSG_TXT, e.getMessage());
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
						.nombreCompleto(paciente.getPersona().getNombre(), paciente.getPersona().getApellidos())
						.credenciales(paciente.getPersona().getEmail(), paciente.getPersona().getPassword(), paciente.getPersona().getRole(), paciente.getPersona().getTipoUsuario())
						.dni(paciente.getPersona().getDni())
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
				
				response.put(Constantes.TITULO_TXT, Constantes.TITULO_EXITO);
				response.put(Constantes.TIPO_TXT, Constantes.TIPO_EXITO);
				response.put(Constantes.MSG_TXT, Constantes.MODIFICACION_EXITO_MSG);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}else {
				response.put(Constantes.TITULO_TXT, Constantes.TITULO_ADVERTENCIA);
				response.put(Constantes.TIPO_TXT, Constantes.TIPO_ADVERTENCIA);
				response.put(Constantes.MSG_TXT, Constantes.ID_ERROR_RESPONSE);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			response.put(Constantes.TITULO_TXT, Constantes.TITULO_ERROR);
			response.put(Constantes.TIPO_TXT, Constantes.TIPO_ERROR);
			response.put(Constantes.MSG_TXT, Constantes.MODIFICACION_ERROR_MSG);//e.getMessage()
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
}
