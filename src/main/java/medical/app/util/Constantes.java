package medical.app.util;

public class Constantes {

	private Constantes() {}
	
	//Response
	public static final String EMAIL_ERROR_RESPONSE = "Email ya registrado";
	
	public static final String DNI_ERROR_RESPONSE = "DNI ya registrado";
	
	public static final String REGISTRO_ERROR_RESPONSE = "Error al registrar al usuario";
	
	public static final String REGISTRO_EXITO_RESPONSE = "Se registró al usuario exitosamente";
	
	public static final String OBTENER_HISTORIAL_ERROR_RESPONSE = "Error al obtener historial del paciente";
	
	public static final String HISTORIAL_RESPONSE = "HistorialPaciente";
	
	
	//TipoMensaje
	public static final String MSG = "Mensaje";
	
	public static final String ERROR_MSG = "Error";
	
	public static final String EXITO_MSG = "Exito";
	
	public static final String ADVERTENCIA_MSG = "Advertencia";
	
	
	//PathsEntidad
	public static final String PACIENTE = "/paciente";
	
	public static final String DOCTOR = "/doctor";

	public static final String CITA = "/cita";
	
	public static final String ESPECIALIDAD = "/especialidad";
	
	public static final String ADMINISTRADOR = "/admin";
	
	//PathsFuncion
	public static final String REGISTRAR = "/registrar";
	
	public static final String LISTAR = "/listar";

	public static final String MODIFICAR = "/modificar";
}
