package br.com.gustavo.studentstasks.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.gustavo.studentstasks.services.exceptions.DatabaseException;
import br.com.gustavo.studentstasks.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError();
		standardError.setTimeStamp(Instant.now());
		standardError.setStatus(httpStatus.value());
		standardError.setError("Resource Not Found");
		standardError.setMessage(ex.getMessage());
		standardError.setPath(request.getRequestURI());

		return ResponseEntity.status(httpStatus).body(standardError);
	}
	
	public ResponseEntity<StandardError> databaseException (DatabaseException e, HttpServletRequest request){
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		StandardError standardError = new StandardError();
		standardError.setTimeStamp(Instant.now());
		standardError.setStatus(httpStatus.value());
		standardError.setError("Resource Not Found");
		standardError.setMessage(e.getMessage());
		standardError.setPath(request.getRequestURI());

		return ResponseEntity.status(httpStatus).body(standardError);
	}
	
	

}
