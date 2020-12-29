package medical.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import medical.app.service.EspecialidadService;
import medical.app.util.Constantes;

@RestController
@RequestMapping(Constantes.ESPECIALIDAD)
@Api(tags = "Especialidad")
public class EspecialidadController {

	@Autowired
	private EspecialidadService especialidadService;
	
}
