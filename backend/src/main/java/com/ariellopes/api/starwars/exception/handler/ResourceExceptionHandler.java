package com.ariellopes.api.starwars.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ariellopes.api.starwars.exception.handler.validation.StandardError;
import com.ariellopes.api.starwars.exception.handler.validation.ValidationError;
import com.ariellopes.api.starwars.exception.model.PlanetaJaExisteException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e,
			                                                            HttpServletRequest request){
		ValidationError erro = new ValidationError();
		
	   for(FieldError x : e.getBindingResult().getFieldErrors()) {
		   erro.addError(x.getField(), x.getDefaultMessage());
	   }
			
			
	    erro.setTimestamp(System.currentTimeMillis());
		erro.setStatus(422);
		erro.setError("Erro de Validação");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		erro.setMensagemDesenvolvedor("http://erros.starwars.com/422");
		
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
	}
	
	@ExceptionHandler(PlanetaJaExisteException.class)
	public ResponseEntity<StandardError> handlerObjectNotFoundException(PlanetaJaExisteException e,
			                                                            HttpServletRequest request){
		StandardError erro = new StandardError();
		
		erro.setTimestamp(System.currentTimeMillis());
		erro.setStatus(400);
		erro.setError("Planeta já existe");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		erro.setMensagemDesenvolvedor("http://erros.starwars.com/400");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}