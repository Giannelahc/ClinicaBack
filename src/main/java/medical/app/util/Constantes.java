package medical.app.util;

public class Constantes {

	private Constantes() {}
	
	//Mensaje
	//Autenticacion
	public static final String EMAIL_ERROR_RESPONSE = "Email ya registrado";
	
	public static final String DNI_ERROR_RESPONSE = "DNI ya registrado";
	
	public static final String ID_ERROR_RESPONSE = "Usuario no encontrado";
	
	
	
	public static final String REGISTRO_ERROR_MSG = "Error al registrar al usuario";
	
	public static final String REGISTRO_EXITO_MSG = "Se registró al usuario exitosamente";
	
	public static final String MODIFICACION_ERROR_MSG = "Error al modificar al usuario";
	
	public static final String MODIFICACION_EXITO_MSG = "Se modifico al usuario exitosamente";
	
	public static final String OBTENER_HISTORIAL_ERROR_MSG = "Error al obtener historial del paciente";
	
	public static final String DATA_OBJECT_RESPONSE = "data";
	
	//Contenido
	public static final String MSG_TXT = "mensaje";
	
	public static final String TITULO_TXT = "titulo";
	
	public static final String TIPO_TXT = "tipo";
	
	//TituloMensaje
	public static final String TITULO_ERROR = "ERROR!";
	
	public static final String TITULO_EXITO = "EXITO!";
	
	public static final String TITULO_ADVERTENCIA = "ADVERTENCIA!";
	
	public static final String TITULO_INFO = "AVISO!";
	
	//TipoMensaje
	public static final String TIPO_ERROR = "error";
	
	public static final String TIPO_EXITO = "success";
	
	public static final String TIPO_ADVERTENCIA = "warning";
	
	public static final String TIPO_INFO = "info";
	
	
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
