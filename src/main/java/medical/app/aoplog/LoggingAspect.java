package medical.app.aoplog;

import java.util.Calendar;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import medical.app.models.Auditoria;
import medical.app.models.Persona;
import medical.app.repository.AuditoriaRepositorio;

@Component
@Aspect
public class LoggingAspect {

	@Autowired
	private AuditoriaRepositorio auditoriaRepositorio;
	
	@Around("execution(* medical.app.service.*Service*.*(..))")
	public Object logService(ProceedingJoinPoint proceedingJoinPoint) {
		Logger log = LoggerFactory.getLogger(proceedingJoinPoint.getTarget().getClass());
		Object result = null;
		String metodo = proceedingJoinPoint.getSignature().getName();
		
		final StopWatch stopWatch = new StopWatch();
        
        stopWatch.start();
        
        if(proceedingJoinPoint.getArgs().length > 0)
        	log.info(metodo + "()input "+proceedingJoinPoint.getArgs());
        
        try {
        	result = proceedingJoinPoint.proceed();
        }catch(Throwable e) {
        	log.error(e.getMessage());
        }
        
        log.info(metodo + "(): tiempo transcurrido " + stopWatch + " ms.");
		return result;
	}
	
	@After("execution(* medical.app.service.PersonaService.registrar(..)) ||"+
			"execution(* medical.app.service.PersonaService.modificar(..)) ||"+
			"execution(* medical.app.service.PersonaService.eliminar(..))")
	public void auditService(JoinPoint joinPoint) {
		Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		
		String metodo = joinPoint.getSignature().getName();
		Long id = null;
		if(metodo.startsWith("registrar") || metodo.startsWith("modificar")){
			Object[] parametros = joinPoint.getArgs();
			medical.app.models.Persona persona = (Persona)parametros[0];
			id = persona.getId();
		}else if(metodo.startsWith("eliminar")) {
			Object[] parametros = joinPoint.getArgs();
			id = (long)parametros[0];
		}
		
		log.info(metodo + ": registrando auditoria");
		auditoriaRepositorio.save(new Auditoria("persona", id, Calendar.getInstance().getTime(), metodo));
	}
}
